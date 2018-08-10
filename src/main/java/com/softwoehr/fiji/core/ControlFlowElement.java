package com.softwoehr.fiji.core;

/** ControlFlowElement wrappers a Semantic pushed on the control flow
 * stack along with information about the context when the entry
 * was pushed. Definitions may nest and the current definition is
 * pushed to support this, but the real nice thing aside from the
 * marginally useful ability to nest definitions is that it's easy
 * for the compiler to know a definition was messed up when it
 * doesn't find a Definition control flow element on popping the
 * control flow stack.
 */
public class ControlFlowElement {
    /** The Semantic this entry represents. */
    public Semantic element;

    /** Interpret/compile state at time this entry was created. */
    public boolean state;

    /** The Class this ControlFlowElement represents, since
     * sometimes this.element is null, e.g., in the case
     * of a pushed null currentDefinition.
     */
    public Class semanticClass;

    /** Creates a ControlFlowElement for a
     * specific Semantic  with a null element.
     * @param s
     * @param e  */
    public ControlFlowElement(Semantic s, Engine e) {
        reinit(s,e);
    }

    /** Creates a ControlFlowElement representing specific
     * type of Semantic with a non-null element.
     * @param s
     * @param e
     * @param c  */
    public ControlFlowElement(Semantic s, Engine e, Class c) {
        reinit(s,e,c);
    }

    /** Reinitialize the ControlFlowElement, discarding previous state.
     * @param s
     * @param e  */
    public void reinit(Semantic s, Engine e) {
        reinit(s, e, s.getClass());
    }

    /** Reinitialize the ControlFlowElement, discarding previous state.
     * @param s
     * @param e
     * @param c  */
    public void reinit(Semantic s, Engine e, Class c) {
        element = s;
        state = e.state;
        semanticClass = c;
    }

    /** Return the class of the Semantic element this entry represents.
     * @return  */
    public Class elementClass() {
        return semanticClass;
    }

    /** Return the Semantic element this entry represents.
     * @return  */
    public Semantic getElement() {
        return element;
    }
}
