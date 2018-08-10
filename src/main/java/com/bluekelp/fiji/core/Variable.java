package com.bluekelp.fiji.core;

public class Variable extends Semantic
{
  private Object datum = null;

  public Variable () {
    super("Anonymous Variable");
    }

  Variable(String name) {
    super(name);
  }

  public String toString () {
    return "A Variable named " + getName() + " whose value is " + datum ;
    }

  // A method for the FIJI operator '@' to use.
  void fetch(Engine e) {
    e.push(datum);
    }

  // A method for the FIJI operator '!' to use.
  void store(Engine e) {
    datum = e.pop();
    }
}
