package com.softwoehr.fiji.core;

import java.util.HashMap;
import java.util.Map;

/** This is a word list of Semantics. They
 * are keyed by their names. If a Semantic of an
 * existing name is keyed in, the previous is lost.
 */
public class Dictionary extends Semantic {
    private Map<String, Entry> dict;

    public Dictionary() {
        reinit("Anonymous Dictionary.");
    }

    public Dictionary(String name) {
        reinit(name);
    }

    // Reinit discarding previous state.
    private void reinit(String name) {
        setName(name);
        dict = new HashMap<>();
    }

    // Do a string dump dict's name.
    public String toString() {
        return "A Dictionary named " + getName();
    }

    /** Add a Semantic in, comes with its own key. If key
     * already exists, push the previous Semantic for the key
     * (so that it can later be restored if the user 'forget's
     * the active Semantic) and set the active Semantic to the
     * Semantic presented to this method.
     */
    void put(Semantic s) {
        String name = s.getName();
        Entry entry = findEntry(name);
        if (null == entry) {
            entry = new Entry(s);
            dict.put(name, entry);
        }
        else {
            entry.push(s);
        }
    }

    // Find a Entry by name in a dict.
    private Entry findEntry(String name) {
        return dict.get(name);
    }

    // Find a Semantic by name in a dict.
    Semantic find(String name) {
        Semantic s = null;
        Entry entry = findEntry(name);
        if (null != entry) {
            s = entry.getSemantic();
        }
        return s;
    }

    /** 'Forget' the active Semantic for a name, popping the previous
     * Semantic in its place. If no previous Semantic
     * is stacked, remove the entry from the Dictionary.
     */
    void forget(String name) {
        Entry entry = dict.get(name);
        if (null != entry) {
            Semantic s = entry.pop();
            if (null == s) {
                dict.remove(name);
            }
        }
    }

    // Utterly discard a dict entry.
    void discard(String name) {
        dict.remove(name);
    }

    // Return a string of all words in the dict.
    public String words() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : dict.values()) {
            if (null != entry) {
                sb.append( entry.getName() + " ");
            }
        }
        return sb.toString();
    }

    /** Create a default dict for initial Engine.
     * Each invocation of this method results in
     * a unique instance. Alternatively, the
     * list could be a static member, but then
     * it had better be read-only to Interpreter
     * instances due to its being shared.
     */
    static Dictionary defaultWordlist() {
        Dictionary defaultList = new Dictionary("FIJI");
        try {
            defaultList.put(new Primitive("noop"         , "noop"                 ));
            defaultList.put(new Primitive("depth"        , "depth"                ));
            defaultList.put(new Primitive("dup"          , "dup"                  ));
            defaultList.put(new Primitive("drop"         , "drop"                 ));
            defaultList.put(new Primitive("swap"         , "swap"                 ));
            defaultList.put(new Primitive("over"         , "over"                 ));
            defaultList.put(new Primitive("rot"          , "rot"                  ));
            defaultList.put(new Primitive("roll"         , "roll"                 ));
            defaultList.put(new Primitive("pick"         , "pick"                 ));
            defaultList.put(new Primitive(".s"           , "dot_s"                ));
            defaultList.put(new Primitive(".c"           , "dot_c"                ));
            defaultList.put(new Primitive(".sc"          , "dot_sc"               ));
            defaultList.put(new Primitive("."            , "dot"                  ));
            defaultList.put(new Primitive(".."           , "dotdot"               ));
            defaultList.put(new Primitive(".r"           , "dot_r"                ));
            defaultList.put(new Primitive("warm"         , "warm"                 ));
            defaultList.put(new Primitive("cold"         , "cold"                 ));
            defaultList.put(new Primitive("quit"         , "quit"                 ));
            defaultList.put(new Primitive(">class"       , "getStackEntryClass"   ));
            defaultList.put(new Primitive(">string"      , "stackEntryToString"   ));
            defaultList.put(new Primitive("("            , "javaArgs"             ));
            defaultList.put(new Primitive(","            , "accumulateArg"        ));
            defaultList.put(new Primitive(")"            , "callJava"             ));
            defaultList.put(new Primitive("'"            , "lexeme"               ));
            defaultList.put(new Primitive("class"        , "classForName"         ));
            defaultList.put(new Primitive("bye"          , "bye"                  ));
            //defaultList.put(new Primitive("sysexit"      , "sysexit"              ));
            defaultList.put(new Primitive("true"         , "pushTrue"             ));
            defaultList.put(new Primitive("null"         , "pushNull"             ));
            defaultList.put(new Primitive("false"        , "pushFalse"            ));
            defaultList.put(new Primitive("()"           , "castParam"            ));
            defaultList.put(new Primitive("primitive"    , "classToPrimitiveType" ));
            defaultList.put(new Primitive(">primitive"   , "stackEntryToPrimitive"));
            defaultList.put(new Primitive("(primitive)"  , "stackEntryToPrimParam"));
            defaultList.put(new Primitive("l>i"          , "longToIntParam"       ));
            defaultList.put(new Primitive("find"         , "find"                 ));
            defaultList.put(new Primitive("execute"      , "execute"              ));
            defaultList.put(new Primitive("compile"      , "compile"              ));
            defaultList.put(new Primitive("["   /* Special compilation semantics.*/
            , "leftBracket"
            , "leftBracket"
            ));
            defaultList.put(new Primitive("]"   /* Special compilation semantics.*/
            , "rightBracket"
            , "rightBracket"
            ));
            defaultList.put(new Primitive("base"         , "popBase"              ));
            defaultList.put(new Primitive("base?"        , "pushBase"             ));
            defaultList.put(new Primitive("state"        , "doState"              ));
            defaultList.put(new Primitive("immediate?"   , "isImmediate"          ));
            defaultList.put(new Primitive("immediate"/* Special compilation semantics.*/
            , "compileOnly"
            , "setCurrentImmediate"
            ));
            defaultList.put(new Primitive("\""  /* Special compilation semantics.*/
            , "doubleQuote"
            , "compileDoubleQuote"
            ));
            defaultList.put(new Primitive("`"   /* Special compilation semantics.*/
            , "backTick"
            , "compileBackTick"
            ));
            defaultList.put(new Primitive("\\"  /* Special compilation semantics.*/
            , "comment"
            , "comment"
            ));
            defaultList.put(new Primitive("exit"         , "doExit"               ));
            defaultList.put(new Primitive("not"          , "not"                  ));
            defaultList.put(new Primitive("and"          , "and"                  ));
            defaultList.put(new Primitive("or"           , "or"                   ));
            defaultList.put(new Primitive("xor"          , "xor"                  ));
            defaultList.put(new Primitive("="            , "isEqual"              ));
            defaultList.put(new Primitive(">"            , "greaterThan"          ));
            defaultList.put(new Primitive("<"            , "lessThan"             ));
            defaultList.put(new Primitive("<>"           , "isUnequal"            ));
            defaultList.put(new Primitive("+"            , "add"                  ));
            defaultList.put(new Primitive("-"            , "sub"                  ));
            defaultList.put(new Primitive("*"            , "mul"                  ));
            defaultList.put(new Primitive("/"            , "div"                  ));
            defaultList.put(new Primitive("mod"          , "mod"                  ));
            defaultList.put(new Primitive("array"        , "array"                ));
            defaultList.put(new Primitive("dimarray"     , "dimarray"             ));
            defaultList.put(new Primitive("variable"     , "newVariable"          ));
            defaultList.put(new Primitive("!"            , "store"                ));
            defaultList.put(new Primitive("@"            , "fetch"                ));
            defaultList.put(new Primitive("value"        , "newValue"             ));
            defaultList.put(new Primitive("to"  /* Special compilation semantics.*/
            ,"toValue"
            ,"compileToValue"
            ));
            defaultList.put(new Primitive("{"            , "newAnonymousDefinition"));
            defaultList.put(new Primitive("}"
            ,"compileOnly"                      /* Special compilation semantics.*/
            ,"concludeAnonymousDefinition"
            ));
            defaultList.put(new Primitive(":"            , "newDefinition"         ));
            defaultList.put(new Primitive(";"   /* Special compilation semantics.*/
            ,"compileOnly"
            ,"concludeDefinition"
            ));
            defaultList.put(new Primitive("if"  /* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBranch"
            ));
            defaultList.put(new Primitive("else"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileAndResolveBranch"
            ));
            defaultList.put(new Primitive("then"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"resolveBranch"
            ));
            defaultList.put(new Primitive("begin"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"pushUnconditionalBranch"
            ));
            defaultList.put(new Primitive("again"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileUnconditionalBackwardsBranch"
            ));
            defaultList.put(new Primitive("until"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBackwardsBranch"
            ));
            defaultList.put(new Primitive("while"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBranch"   /* == 'if'*/
            ));
            defaultList.put(new Primitive("repeat"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"resolveTwoBranches"
            ));
            defaultList.put(new Primitive("cr"           , "cr"                   ));
            defaultList.put(new Primitive("do"  /* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileDo"
            ));
            defaultList.put(new Primitive("loop"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileLoop"
            ));
            defaultList.put(new Primitive("+loop"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compilePlusLoop"
            ));
            defaultList.put(new Primitive("leave"        , "doLeave"              ));
            defaultList.put(new Primitive("index"        , "index"                ));
            defaultList.put(new Primitive("verbose"      , "runtimeVerbose"       ));
            defaultList.put(new Primitive("decompile"    , "decompile"            ));
            defaultList.put(new Primitive("interpret"    , "interpret"            ));
            defaultList.put(new Primitive("load"         , "load"                 ));
            defaultList.put(new Primitive("version"      , "version"              ));
            defaultList.put(new Primitive("getorder"     , "getOrder"             ));
            defaultList.put(new Primitive("setorder"     , "setOrder"             ));
            defaultList.put(new Primitive("dict"         , "newWordlist"          ));
            defaultList.put(new Primitive("setcurrent"   , "setCurrent"           ));
            defaultList.put(new Primitive("getcurrent"   , "getCurrent"           ));
            defaultList.put(new Primitive("words"        , "words"                ));
            defaultList.put(new Primitive("forget"       , "forget"               ));
            defaultList.put(new Primitive("discard"      , "discard"              ));
            defaultList.put(defaultList);                    /* Add self to list!*/ // TODO why?
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return defaultList;
    }
}