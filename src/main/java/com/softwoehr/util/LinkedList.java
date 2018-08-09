// LinkedList.java
// A linked list implementation.

package com.softwoehr.util;

import java.util.*;

public class LinkedList {
    
    public interface Linkable {
        public Linkable getNext();
        public void setNext(Linkable node);
    }
    
    Linkable head = null;
    
    public void addHead (Linkable node) {
        node.setNext(head);
        head = node;
    }
    
    public void addTail (Linkable node) {
        Enumeration e = enumerate();
        if (!e.hasMoreElements()) {
            addHead(node);
        }
        else {
            Linkable lastNode = null;
            while (e.hasMoreElements()) {
                lastNode = (Linkable) e.nextElement();
            }
            if (lastNode == null) {
                head = node;
            }
            else {
                lastNode.setNext(node);
            }
            node.setNext(null); // probably redundant
        }
    }
    
    public void remove (Linkable node) {
        Linkable previous = null;
        Linkable current = head;
        Enumeration e = enumerate();
        while (e.hasMoreElements()) {
            if (current == e.nextElement()) {
                
                if (previous == null) {
                    
                    if (e.hasMoreElements()) {
                        head = (Linkable) e.nextElement();
                    }
                    else {
                        head = null;
                    }
                }
                
                else {
                    if (e.hasMoreElements()) {
                        previous.setNext((Linkable) e.nextElement());
                        current.setNext(null);
                    }
                    else {
                        previous.setNext(null);
                    }
                }
                
                break;
            }
        }
    }
    
    public int numberOfElements() {
        Enumeration e = enumerate();
        int elements = 0;
        while (e.hasMoreElements()) {
            e.nextElement();
            elements++;
        }
        return elements;
    }
    
    public Enumeration enumerate() {
        
        return new Enumeration() {
            
            Linkable current = head;
            
            public boolean hasMoreElements() {
                return (current != null);
            }
            
            public Object nextElement() {
                if (current == null) {
                    throw new NoSuchElementException("LinkedList");
                }
                Object value = current;
                current = (Linkable) current.getNext();
                return value;
            }
        };
    }
    
    public static void main (String argv[]) {
        
        if (argv.length == 0) {
            System.out.println("usage: java LinkedList [arg] [arg] ...");
            System.out.println("... manipulates a linked list of the text argument strings you provide.");
            return;
        }
        
        LinkedList l = new LinkedList();
        
        for (int i = 0; i < argv.length; i++) {
            l.addHead (new LinkableString(argv[i]));
        }
        
        System.out.println("I created a LinkedList of your command-line arguments.");
        System.out.println("It has " + l.numberOfElements() + " elements.");
        System.out.println("Here's a backwards-linked-list listing of all (if any) of the command line arguments:");
        Enumeration e = l.enumerate();
        while (e.hasMoreElements()) {
            System.out.println (((LinkableString) e.nextElement()).string());
        }
        
        System.out.println("Now I'll add an element to the tail.");
        l.addTail (new LinkableString("Hi, I'm the tail node!"));
        System.out.println("Here's a backwards-linked-list listing of all (if any) of the command line arguments:");
        e = l.enumerate();
        while (e.hasMoreElements()) {
            System.out.println (((LinkableString) e.nextElement()).string());
        }
        
        while (l.head != null) {
            System.out.println ("Now I'll remove the head element.");
            l.remove(l.head);
            System.out.println("The list now has " + l.numberOfElements() + " element(s) remaining.");
            e = l.enumerate();
            while (e.hasMoreElements()) {
                System.out.println (((LinkableString) e.nextElement()).string());
            }
        }
        
        return;
    }
    
}

class LinkableString implements LinkedList.Linkable {
    
    public String s;
    private LinkedList.Linkable next = null;
    
    public LinkableString() {this("");}
    public LinkableString(String s) { this.s = s; }
    public String string() { return s; }
    public LinkedList.Linkable getNext () { return next; }
    public void setNext(LinkedList.Linkable node) { next = node; }
}

// End of LinkedList.java

