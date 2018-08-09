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

package com.softwoehr.fiji.errors;


/*  End of Exceptions.java */

/**
 * An Exception base class for SoftWoehr.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Exceptions extends java.lang.Exception {
    public static class desktop {
        public static class shell {

            /**
             * Stack too shallow for operation.
             */
            public static class StackUnderflow extends com.softwoehr.fiji.errors.Exceptions {
                public StackUnderflow(Throwable t) {
                    super(t);
                }

                public StackUnderflow(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * An entity was passed as an instance of a class but is not.
             */
            public static class NotClassInstance extends com.softwoehr.fiji.errors.Exceptions {
                public NotClassInstance(Throwable t) {
                    super(t);
                }

                public NotClassInstance(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * An entity was passed as an instance of a reflected class but is not.
             */
            public static class NonReflectedType extends com.softwoehr.fiji.errors.Exceptions {
                public NonReflectedType(Throwable t) {
                    super(t);
                }

                public NonReflectedType(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * A String was passed to represent a class name but doesn't.
             */
            public static class NotClassName extends com.softwoehr.fiji.errors.Exceptions {
                public NotClassName(Throwable t) {
                    super(t);
                }

                public NotClassName(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Invalid numeric conversion base for Interpreter.
             */
            public static class BadBase extends com.softwoehr.fiji.errors.Exceptions {
                public BadBase(Throwable t) {
                    super(t);
                }

                public BadBase(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Invalid character display code page requested from host system.
             */
            public static class BadEncoding extends com.softwoehr.fiji.errors.Exceptions {
                public BadEncoding(Throwable t) {
                    super(t);
                }

                public BadEncoding(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Invalid name offered for a Semantic.
             */
            public static class BadName extends com.softwoehr.fiji.errors.Exceptions {
                public BadName(Throwable t) {
                    super(t);
                }

                public BadName(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Attempt to perform a Variable operation on a non-Variable.
             */
            public static class NonVariable extends com.softwoehr.fiji.errors.Exceptions {
                public NonVariable(Throwable t) {
                    super(t);
                }

                public NonVariable(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Attempt to perform a Value operation on a non-Value.
             */
            public static class NonValue extends com.softwoehr.fiji.errors.Exceptions {
                public NonValue(Throwable t) {
                    super(t);
                }

                public NonValue(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Exception encoutered in execution semantics of a Primitive.
             */
            public static class BadPrimitiveExecute extends com.softwoehr.fiji.errors.Exceptions {
                public BadPrimitiveExecute(Throwable t) {
                    super(t);
                }

                public BadPrimitiveExecute(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Exception encoutered in execution semantics of a Definition.
             */
            public static class BadDefinitionExecute extends com.softwoehr.fiji.errors.Exceptions {
                public BadDefinitionExecute(Throwable t) {
                    super(t);
                }

                public BadDefinitionExecute(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Exception encoutered in compilation semantics of a Primitive.
             */
            public static class BadPrimitiveCompile extends com.softwoehr.fiji.errors.Exceptions {
                public BadPrimitiveCompile(Throwable t) {
                    super(t);
                }

                public BadPrimitiveCompile(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Exception encoutered in compilation semantics of a Definition.
             */
            public static class BadDefinitionCompile extends com.softwoehr.fiji.errors.Exceptions {
                public BadDefinitionCompile(Throwable t) {
                    super(t);
                }

                public BadDefinitionCompile(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Exception encoutered in compilation semantics of a Value.
             */
            public static class CompileToValue extends com.softwoehr.fiji.errors.Exceptions {
                public CompileToValue(Throwable t) {
                    super(t);
                }

                public CompileToValue(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Name not found in the Interpreter search order.
             */
            public static class NameNotFound extends com.softwoehr.fiji.errors.Exceptions {
                public NameNotFound(Throwable t) {
                    super(t);
                }

                public NameNotFound(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Control flow stack imbalance.
             */
            public static class ControlFlowStackImbalance extends com.softwoehr.fiji.errors.Exceptions {
                public ControlFlowStackImbalance(Throwable t) {
                    super(t);
                }

                public ControlFlowStackImbalance(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * ParamaterizedPrimitive possess useless parameter object.
             */
            public static class InvalidParameterObject extends com.softwoehr.fiji.errors.Exceptions {
                public InvalidParameterObject(Throwable t) {
                    super(t);
                }

                public InvalidParameterObject(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Non-Boolean passed to a conditional.
             */
            public static class ConditionalNonBoolean extends com.softwoehr.fiji.errors.Exceptions {
                public ConditionalNonBoolean(Throwable t) {
                    super(t);
                }

                public ConditionalNonBoolean(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Problem during branch resolution, bad branch, bad object types, etc.
             */
            public static class BranchResolution extends com.softwoehr.fiji.errors.Exceptions {
                public BranchResolution(Throwable t) {
                    super(t);
                }

                public BranchResolution(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            /**
             * Interpret-time use of compile-only syntax.
             */
            public static class CompileOnly extends com.softwoehr.fiji.errors.Exceptions {
                public CompileOnly(Throwable t) {
                    super(t);
                }

                public CompileOnly(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            public static class OpenIfBranch extends com.softwoehr.fiji.errors.Exceptions {
                public OpenIfBranch(Throwable t) {
                    super(t);
                }

                public OpenIfBranch(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }
        }
    }

    Exceptions(Throwable t) {
        super(t);
    }

    Exceptions(String s, java.lang.Throwable t) {
        super(s, t);
    }
}