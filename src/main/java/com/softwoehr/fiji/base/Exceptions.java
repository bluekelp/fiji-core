/* Exceptions.java ...  */
/*********************************************/
/* Copyright *C* 1998, All Rights Reserved.  */
/* Jack J. Woehr jax@well.com jwoehr@ibm.net */
/* http://www.well.com/user/jax/rcfb         */
/* P.O. Box 51, Golden, Colorado 80402-0051  */
/*********************************************/
/*                                           */
/*    This Program is Free SoftWoehr.        */
/*                                           */
/* THERE IS NO GUARANTEE, NO WARRANTY AT ALL */
/*********************************************/
/*
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.softwoehr.fiji.base;

/** An Exception base class for SoftWoehr.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Exceptions extends java.lang.Exception {
    private Throwable t;

    /** Exceptions pertaining to com.SoftWoehr.desktop. */
    public static class desktop {
        /** Exceptions pertaining to com.SoftWoehr.desktop.shell. */
        public static class shell {

            /** Stack too shallow for operation. */
            public static class StackUnderflow extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public StackUnderflow(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public StackUnderflow(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                   /* StackUnderflow*/

            /** An entity was passed as an instance of a class but is not. */
            public static class NotClassInstance extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NotClassInstance(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NotClassInstance(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                 /* NotClassInstance*/

            /** An entity was passed as an instance of a reflected class but is not. */
            public static class NonReflectedType extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NonReflectedType(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NonReflectedType(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                 /* NonReflectedType*/

            /** A String was passed to represent a class name but doesn't. */
            public static class NotClassName extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NotClassName(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NotClassName(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                     /* NotClassName*/

            /** Invalid numeric conversion base for Interpreter. */
            public static class BadBase extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadBase(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadBase(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                          /* BadBase*/

            /** Invalid character display code page requested from host system.*/
            public static class BadEncoding extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadEncoding(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadEncoding(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                      /* BadEncoding*/

            /** Invalid name offered for a Semantic.*/
            public static class BadName extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadName(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadName(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                      /* BadEncoding*/

            /** Attempt to perform a Variable operation on a non-Variable.*/
            public static class NonVariable extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NonVariable(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NonVariable(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                      /* NonVariable*/

            /** Attempt to perform a Value operation on a non-Value.*/
            public static class NonValue extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NonValue(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NonValue(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                         /* NonValue*/

            /** Exception encoutered in execution semantics of a Primitive.*/
            public static class BadPrimitiveExecute extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadPrimitiveExecute(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadPrimitiveExecute(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                              /* BadPrimitiveExecute*/

            /** Exception encoutered in execution semantics of a Definition.*/
            public static class BadDefinitionExecute extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadDefinitionExecute(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadDefinitionExecute(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                             /* BadDefinitionExecute*/

            /** Exception encoutered in compilation semantics of a Primitive.*/
            public static class BadPrimitiveCompile extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadPrimitiveCompile(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadPrimitiveCompile(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                              /* BadPrimitiveCompile*/

            /** Exception encoutered in compilation semantics of a Definition.*/
            public static class BadDefinitionCompile extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BadDefinitionCompile(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BadDefinitionCompile(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                             /* BadDefinitionCompile*/

            /** Exception encoutered in compilation semantics of a Value.*/
            public static class CompileToValue extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public CompileToValue(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public CompileToValue(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                   /* CompileToValue*/

            /** Name not found in the Interpreter search order.*/
            public static class NameNotFound extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public NameNotFound(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public NameNotFound(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                     /* NameNotFound*/

            /** Control flow stack imbalance.*/
            public static class ControlFlowStackImbalance extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public ControlFlowStackImbalance(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public ControlFlowStackImbalance(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                        /* ControlFlowStackImbalance*/

            /** ParamaterizedPrimitive possess useless parameter object.*/
            public static class InvalidParameterObject extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public InvalidParameterObject(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public InvalidParameterObject(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                           /* InvalidParameterObject*/

            /** Non-Boolean passed to a conditional. */
            public static class ConditionalNonBoolean extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public ConditionalNonBoolean(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public ConditionalNonBoolean(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                            /* ConditionalNonBoolean*/

            /** Problem during branch resolution, bad branch, bad object types, etc. */
            public static class BranchResolution extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public BranchResolution(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public BranchResolution(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                 /* BranchResolution*/

            /** Interpret-time use of compile-only syntax. */
            public static class CompileOnly extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public CompileOnly(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public CompileOnly(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                      /* CompileOnly*/

            /** Problem compiling an if-branch. */
            public static class OpenIfBranch extends com.softwoehr.fiji.base.Exceptions {

                /** Arity/1 Throwable constructor. */
                public OpenIfBranch(Throwable t) {
                    super(t);
                }

                /** Arity/2 Throwable constructor. */
                public OpenIfBranch(String s, java.lang.Throwable t) {
                    super(s,t);
                }
            }                                                     /* OpenIfBranch*/
        }                                                              /* shell*/
    }                                                              /* desktop*/

    /** A buncha Exceptions types. */
    public static class BackToMain extends com.softwoehr.fiji.base.Exceptions {

        /** Arity/1 Throwable constructor. */
        public BackToMain(Throwable t) {
            super(t);
        }

        /** Arity/2 Throwable constructor. */
        public BackToMain(String s, java.lang.Throwable t) {
            super(s,t);
        }

    }

    /** A buncha Exceptions types. */
    public static class BadArgToMain extends com.softwoehr.fiji.base.Exceptions {

        /** Arity/1 Throwable constructor. */
        public BadArgToMain(Throwable t) {
            super(t);
        }

        /** Arity/2 Throwable constructor. */
        public BadArgToMain(String s, java.lang.Throwable t) {
            super(s,t);
        }
    }

    /** Arity/0 ctor. */
    public Exceptions() {
    }

    /** Arity/1 Throwable constructor. */
    public Exceptions(Throwable t) {
        this.t = t;
    }

    /** Arity/2 Throwable constructor. */
    public Exceptions(String s, java.lang.Throwable t) {
        super(s);
        this.t = t;
    }

    public String toString() {
        String result = super.toString();
        if (null != t) {
            result += "Embedded exception: " + t.toString();
        }                                                           /* End if*/
        return result;
    }

    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }

    /** Return the Throwable, if any, which occasioned this Exceptions. */
    public Throwable getThrowable() {
        return t;
    }
}                                                     /* End of Exceptions class*/

/*  End of Exceptions.java */
