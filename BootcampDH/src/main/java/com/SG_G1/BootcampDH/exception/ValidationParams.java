package com.SG_G1.BootcampDH.exception;

public class ValidationParams extends RuntimeException{

    public ValidationParams() {
    }

    public ValidationParams(String message) {
        super(message);
    }
}
