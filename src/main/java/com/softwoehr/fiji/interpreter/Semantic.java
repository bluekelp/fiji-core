package com.softwoehr.fiji.interpreter;

import java.lang.reflect.InvocationTargetException;

public class Semantic {
    private String name;

    public Semantic() {
        this("Anonymous Semantic");
    }

    public Semantic(String name) {
        this.name = name;
    }

    public String toString()
    {return "A Semantic named " + getName();}

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    /**
     * Execution semantics, the default behavior
     * being to push self to stack.
     */
    public void execute(Engine e) throws InvocationTargetException, IllegalAccessException {
        e.push(this);
    }

    /**
     * Compilation semantics, the default behavior
     * being to append self to the current definition.
     */

    public void compile(Engine e) throws InvocationTargetException, IllegalAccessException {
        e.getCurrentDefinition().append(this);
    }

    /**
     * Decompilation semantics. The default is to
     * push a Sematic array with 'this' as only entry.
     */
    public Semantic[] decompile() {
        Semantic decompilation [] = new Semantic[1];
        decompilation[0] = this;
        return decompilation;
    }
}