package com.softwoehr.fiji.core;

import java.util.Stack;

/**
 * The entries in a Dictionary are composite entities, an active defintion
 * for an entry and a stack of previous definitions which were overridden
 * by redefinition of the same name. Thus when we 'forget' a definition,
 * the previous definition of that same name in this same dict is
 * restored to visibility.
 */
class Entry {
    // Create a Entry on a Semantic.
    Entry(Semantic s) {
        semantic = s;
        semanticStack = null;/* Only have a stack if one needed, memory impact.*/
    }

    // The active Semantic of a word.
    private Semantic semantic;

    // The stack of previous Semantics of this same word.
    private Stack<Semantic> semanticStack;

    // Get the Semantic to which this entry refers.
    public Semantic getSemantic() {
        return semantic;
    }

    // Get the name of the semantic to which this entry refers.
    public String getName() {
        return semantic.getName();
    }

    // Change the active Semantic.
    public void push(Semantic s) {
        if (null == semanticStack) {
            semanticStack = new Stack<>();
        }
        semanticStack.push(semantic);
        semantic = s;
    }

    /** Pop the Semantic stack to restore an active Semantic,
     * discarding that which was the active Semantic. Returns
     * that Semantic which becomes the active Semantic as a
     * a result of this operation.
     */
    Semantic pop() {
        semantic = null;                         /* Throw away active Semantic.*/
        if (null != semanticStack)/* If we have a stack of previous Semantic(s) ...*/ {
            // .. then it's a non-empty stack, since we chuck our empties.
            semantic = (Semantic)semanticStack.pop();        /* Restore previous.*/
            if (semanticStack.empty()) /* Don't keep empty stacks, memory impact.*/ {
                semanticStack = null;        /* Chuck away if empty, memory impact.*/
            }
        }
        return semantic;   /* Lets caller know if this entry is dead (== null).*/
    }
}