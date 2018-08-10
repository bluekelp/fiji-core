package com.bluekelp.fiji.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Stack;

/** This is the Interpreter of Definitions.
 *
 * This is the oddest class of the suite.
 *
 * Consider possible implementations of Definition interpretation.
 *
 * The Definition could keep its own interpretive pointer, but that
 * would not be re-entrant, since a Definition instance is unitary
 * in a Dictionary no matter who calls it.
 *
 * Going to the other extreme, interpretation implementation could
 * easily grow tediously procedural.
 *
 * What we have here is the phenomenon of two parallel return stacks,
 * the Java VM stack for one, and the other our stack of activation
 * records which both get popped at the tail of the (effectively) recursive
 * call to InnerInterpreter.interpret().
 *
 * This all could have been shoehorned into the Engine, but breaking
 * it out into its own class makes it easier to keep straight while coding.
 */
public class InnerInterpreter {
    /** Nesting definitions. */
    private Stack returnStack;

    /** Nested LOOPs. */
    private Stack loopStack;

    /** Current definition + instruction pointer*/
    private Interpretation interpretation;

    /** The Engine we're associated with.*/
    private Engine myEngine;

    /** Arity/1 ctor. InnerInterpreter must be associated with an Engine.
     * @param e Engine associated with this inner Interpreter.
     */
    InnerInterpreter(Engine e) {
        reinit(e);
    }

    /** Dump the return stack, effectively.
     * @return String representation of this object.
     */
    public String toString() {
        String result = "An InnerInterpreter with the following status:\n";

        result += "Current definition: ";
        if (null == interpretation) {
            result +=  "No current definition.";
        }
        else {
            result += interpretation.definition.toString();
        }
        result += "\nReturn stack:";

        Enumeration e = returnStack.elements();
        if (e.hasMoreElements()) {
            result += "\n";
            while (e.hasMoreElements()) {
                Interpretation i = (Interpretation) e.nextElement();
                result += i.definition.toString() + "\n";
            }
        }
        else {
            result += " Stack empty.\n";
        }
        return result;
    }

    /** Reinitialize the InnerInterpreter, discarding previous state.
     * @param e The Engine associated with this instance.
     */
    private void reinit(Engine e) {
        myEngine = e;
        returnStack = new Stack();
        loopStack   = new Stack();
        interpretation = null;
    }

    /** Return Engine with which this instance is associated.
     * @return Engine associated with this instance.
     */
    public Engine getEngine() { return myEngine; }

    /** Return current definition being interpreted by this instance.
     * @return The definition under interpretation.
     */
    public Definition getCurrentDefinition() {
        Definition d = null;
        if (null != interpretation) {
            d = interpretation.definition;
        }
        return d;
    }

    /** Push into a Definition.
     * @param d New definition for interpretation.
     */
    private void nest(Definition d) {
        if (null != interpretation)                /* If we're in a Definition.*/ {
            returnStack.push(interpretation);/* Push it so we can nest into this one.*/
        }
        interpretation = new Interpretation(d);    /* Now this becomes current.*/
    }

    /** Pop out of a Definition.
     * @return The Definition which had been under interpretation but is no longer,
     * having been discarded in favor of the popped def resuming interpretation.
     */
    private Definition unnest() {
        Definition wasCurrent = interpretation.definition;
        if (returnStack.empty()) {
            interpretation = null;
        }
        else {
            interpretation = (Interpretation) returnStack.pop();
        }
        return wasCurrent;
    }

    // Run the current Definition
    void interpret(Definition d) throws InvocationTargetException, IllegalAccessException {
        nest(d);
        while (interpretation.index <= interpretation.definition.lastIndex()) {
            Semantic s =     /* Here's where the instruction pointer gets bumped.*/
            interpretation.definition.nthSemantic(interpretation.index++);
            s.execute(myEngine);
        }
        unnest();
    }

    /** Exit the current Definition. */
    void exitCurrentDefinition() {
        interpretation.index = interpretation.definition.lastIndex() + 1;
    }

    /** Add positive or negative delta to the instruction pointer.
     * This is how control flow works, in conjunction with ParameterizedPrimitive.
     *
     * Bump it past end and the definition just exits on the 'while' loop
     * in interpret().
     * @param delta the increment to the IP.
     */
    void bump(int delta) {
        interpretation.index =
        Math.min( Math.max(interpretation.index + delta, 0)/* Maybe throw on <0?*/
        , interpretation.definition.lastIndex() + 1      /* Past end.*/
        );    /* No real reason to min() it, 'while' loop just exits.*/
    }

    /** Push the indices for a loop, checking for and avoiding loops
     * commencing with identical indices (32 bit loops are long!!!).
     * @param limit Loop limit
     * @param index Loop index
     * @param egress Exit point for IP.
     */
    void startLoop(int limit, int index, int egress) {
        announce("Pushing Loop on loop stack with limit "
        + new Integer(limit)
        + " and index "
        + new Integer(index)
        + " and egress "
        + new Integer(egress)
        );
        if (limit != index) {                        /* No '0 0 do .. loop' !!!*/
            loopStack.push(new Loop(limit, index, egress));
        }
        else {
            interpretation.index = egress;    /* If loop indices identical, skip.*/
        }
    }           /* public void startLoop (int limit, int index, int egress)*/

    /** Exit the loop on hitting a 'leave'. */
    void leaveLoop() {
        Loop l = (Loop) loopStack.pop();
        interpretation.index = l.egress;
    }

    /** Increment a loop record and return true if done.
     * @return <CODE>true</CODE> iff the loop is done.
     */
    boolean loop() {
        boolean result = false;
        Loop l = (Loop) loopStack.pop();
        result = l.loop();
        if (!result) {
            loopStack.push(l);
        }
        return result;
    }

    /** Increment a loop record by an increment and return true if done.
     * @param increment increment to plusloop by
     * @return <CODE>true</CODE> iff done.
     */
    boolean plusLoop(int increment) {
        boolean result = false;
        Loop l = (Loop) loopStack.pop();
        result = l.plusLoop(increment);
        announce("PlusLoop index="
        + new Integer(l.index)
        + " increment was "
        + new Integer(increment)
        + " limit= "
        + new Integer(l.limit)
        + " result is "
        + result
        );
        if (!result) {
            loopStack.push(l);
        }
        return result;
    }

    /** Return the loop index for the i'th loop.
     * @param i nesting level of the desired loop index, zero 0 based.
     * @return The index for that i'th loop.
     */
    int ithIndex(int i) {
        int size = loopStack.size();
        int desired = (size - 1) - i;
        Loop l = (Loop) loopStack.elementAt(desired);
        return l.index;
    }

    private void    announce(String s)   { myEngine.announce(s); }
}

/** The entry on the return stack. */
class Interpretation {

    /** Instruction pointer, i.e., offset in Semantic list.*/
    public int index;

    /** Current Definition. */
    public Definition definition;

    /** Construct an inner interpretive entry from a Definition to be executed.
     * @param d Definition to be contained in inner interpretive entry.
     */
    Interpretation(Definition d) {
        definition = d;
        index = 0;
    }
}

/** The entry on the loop stack. */
class Loop {

    /** The loop limit .*/
    int limit;

    /** The loop index. */
    public int index;

    /** The one-past-the-loop offset in the definition. */
    int egress;

    /** Instance object with limit, index and place to exit the loop.
     * @param limit Loop limit, loop exits when boundary between this
     * limit and (this limit - 1) is crossed in either direction.
     * @param index Start index of the loop.
     * @param egress IP offset in current def to jump to when done,
     * point past end of loop.
     */
    Loop(int limit, int index, int egress){
        this.limit  = limit;
        this.index  = index;
        this.egress = egress;
    }

    /** Bumps index and returns true if the new
     * index is equal to the limit.
     * @return true if the new
     * index is equal to the limit.
     */
    boolean loop() {
        boolean result = false;
        if (++index == limit) {
            result = true;
        }
        return result;
    }

    /** Bumps index by increment and returns true
     * if index is crossed the boundary between
     * the loop limit and the loop limit minus one.
     * Increment can be pos or neg.
     * @param increment Increment to plusloop by.
     * @return true if the exit condition has been reached by
     * crossing the boundary between the loop imit and the loop
     * limit minus one.
     */
    boolean plusLoop(int increment) {
        boolean result = false;
        if (index < limit) {
            index = index + increment;
            if (index >= limit) {
                result = true;
            }
        }
        else {                                                /* Index >= limit*/
            index = index + increment;
            if (index < limit) {
                result = true;
            }
        }
        return result;
    }
}
