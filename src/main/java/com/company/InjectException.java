package com.company;

public class InjectException extends Exception {
    InjectException(Exception e){
        super(e.getMessage());
    }
}
