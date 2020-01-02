package Exceptions;

import Exceptions.TacticalChaosGameException;

public class IllegalGameMove extends TacticalChaosGameException {
    public IllegalGameMove(String s) {
        super(s);
    }
}
