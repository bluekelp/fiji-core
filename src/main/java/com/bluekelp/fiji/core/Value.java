package com.bluekelp.fiji.core;

// Value is a self-fetching Variable.
public class Value extends Semantic
{
  private Object datum = null;

  public Value () {
    super("Anonymous Value");
    }

  Value(String name) {
    super(name);
  }

  public String toString () {
    return "A Value named " + getName() + " whose value is " + datum;
    }

  // Execution semantics are to push own datum.
  public void execute (Engine e) {
    e.push(datum);
    }

  public Object getDatum() {
    return datum;
    }

  void setDatum(Object o) {
    datum = o;
    }
}