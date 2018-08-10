package com.softwoehr.fiji.core;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the SearchOrder entity used by
 * FIJI to collate Wordlists.
 */
public class SearchOrder {

    // holds the search order
    private List<Dictionary> dictionaries = new ArrayList<>();

    SearchOrder() {
        reinit();
    }

    private void reinit() {
        dictionaries.clear();
    }

    // Find a Semantic (or null) somewhere in the search order.
    Semantic find(String name) {
        Semantic result = null;
        for (Dictionary w : dictionaries) {
            result = w.find(name);
            if (null != result) {
                break;
            }
        }
        return result;
    }

    /**
     * Pop the active Semantic of a wordlist entry by finding
     * the first occurrence of same in the search order. Remove
     * the entry if no previous Semantic for the name exists.
     *
     * see com.SoftWoehr.desktop.shell.Dictionary.forget#
     */
    boolean forget(String name) {
        boolean rc = false;
        Semantic result;
        for (Dictionary w : dictionaries) {
            result = w.find(name);
            if (null != result) {
                w.forget(name);    /* Pop the previous Semantic or discard if none.*/
                rc = true;                           /* Signal that name was found.*/
                break;
            }
        }
        return rc;
    }

    /**
     * Discard utterly a wordlist entry by finding
     * the first occurrence of same in the search order.
     *
     * see com.SoftWoehr.desktop.shell.Dictionary.discard#
     * */
    boolean discard(String name) {
        boolean rc = false;
        Semantic result;
        for (Dictionary w : dictionaries) {
            result = w.find(name);
            if (null != result) {
                w.discard(name);   /* Pop the previous Semantic or discard if none.*/
                rc = true;                           /* Signal that name was found.*/
                break;
            }
        }
        return rc;
    }

    // Push the search order topped by number of Dictionaries in search order.
    void getOrder(Engine z) {
        for (Dictionary w : dictionaries) {
            z.push(w);
        }
        z.push((long) dictionaries.size());
    }

    // Grab search order from stack
    void setOrder(Engine z) {
        reinit();                                        /* Empty search order.*/
        int numWordlists = ((Long) z.pop()).intValue();
        for (int i = 0; i < numWordlists; ++i) {
            dictionaries.add((Dictionary)z.pop());    /* Add wordlists to order.*/
        }
    }

    // Return names of all words in the search order.
    public String words() {
        final StringBuilder sb = new StringBuilder();
        dictionaries.forEach(wl -> sb.append(wl.words()));
        return sb.toString();
    }


    // Add a Dictionary to the SearchOrder
    public boolean add(Dictionary w) {
        return dictionaries.add(w);
    }

    // A simple Dictionary-typed method to addElement().
    Dictionary nthElement(int i) {
        return dictionaries.get(i);
    }
}