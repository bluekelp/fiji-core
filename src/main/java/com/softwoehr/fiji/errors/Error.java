/* Error.java ...  */
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

/**
 * An Error class for SoftWoehr
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Error extends java.lang.Error {
    public static class desktop {
        public static class shell {

            // Invalid numeric conversion base for Interpreter.
            public static class BadBase extends com.softwoehr.fiji.errors.Error {
                public BadBase(Throwable t) {
                    super(t);
                }
                public BadBase(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Invalid character display code page requested from host system.
            public static class BadEncoding extends com.softwoehr.fiji.errors.Error {
                public BadEncoding(Throwable t) {
                    super(t);
                }
                public BadEncoding(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Invalid name offered for a Semantic.
            public static class BadName extends com.softwoehr.fiji.errors.Error {
                public BadName(Throwable t) {
                    super(t);
                }
                public BadName(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Attempt to perform a Variable operation on a non-Variable.
            public static class NonVariable extends com.softwoehr.fiji.errors.Error {
                public NonVariable(Throwable t) {
                    super(t);
                }
                public NonVariable(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Attempt to perform a Value operation on a non-Value.
            public static class NonValue extends com.softwoehr.fiji.errors.Error {
                public NonValue(Throwable t) {
                    super(t);
                }
                public NonValue(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Exception encoutered in execution semantics of a Primitive.
            public static class BadPrimitiveExecute extends com.softwoehr.fiji.errors.Error {
                public BadPrimitiveExecute(Throwable t) {
                    super(t);
                }
                public BadPrimitiveExecute(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Exception encoutered in compilation semantics of a Primitive.
            public static class BadPrimitiveCompile extends com.softwoehr.fiji.errors.Error {
                public BadPrimitiveCompile(Throwable t) {
                    super(t);
                }
                public BadPrimitiveCompile(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Exception encoutered in compilation semantics of a Primitive.
            public static class CompileToValue extends com.softwoehr.fiji.errors.Error {
                public CompileToValue(Throwable t) {
                    super(t);
                }
                public CompileToValue(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Name not found in the Interpreter search order.
            public static class NameNotFound extends com.softwoehr.fiji.errors.Error {
                public NameNotFound(Throwable t) {
                    super(t);
                }
                public NameNotFound(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }

            // Control flow stack imbalance.
            public static class ControlFlowStackImbalance extends com.softwoehr.fiji.errors.Error {
                public ControlFlowStackImbalance(Throwable t) {
                    super(t);
                }
                public ControlFlowStackImbalance(String s, java.lang.Throwable t) {
                    super(s, t);
                }
            }
        }
    }

    public static class BackToMain extends com.softwoehr.fiji.errors.Error {
        public BackToMain(Throwable t) {
            super(t);
        }
        public BackToMain(String s, java.lang.Throwable t) {
            super(s, t);
        }
    }

    public static class BadArgToMain extends com.softwoehr.fiji.errors.Error {
        public BadArgToMain(Throwable t) {
            super(t);
        }
        public BadArgToMain(String s, java.lang.Throwable t) {
            super(s, t);
        }
    }

    Error(Throwable t) {
        super(t);
    }

    Error(String s, java.lang.Throwable t) {
        super(s, t);
    }
}