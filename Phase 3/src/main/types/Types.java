package main.types;

public abstract class Types {
    public boolean isSameType(Types other) { return (this.getClass().equals(other.getClass())) && !((this instanceof NonType) || (other instanceof NonType)); }
}