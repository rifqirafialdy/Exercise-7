package org.Rifqi.execption;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(){
        super("Invalid Input, Please enter a valid input or q to quit");
    }
}
