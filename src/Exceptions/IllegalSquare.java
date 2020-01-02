package Exceptions;

import Exceptions.TacticalChaosGameException;

public class IllegalSquare extends TacticalChaosGameException {
    public IllegalSquare(String s) {
        super(s);
    }
    public static void showErrorForConsole(int size){
        System.out.println("ILLEGAL_SQUARE_ERROR");
        System.err.println("Please enter a right number ... from 1 ---> " + size);

    }
}
