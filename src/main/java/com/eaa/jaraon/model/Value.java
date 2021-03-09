/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.model;

/**
 *
 * @author esteban
 */
public class Value {

    private final int value;
    private final char sign;
    private final boolean low;

    public Value(int value, char sign, boolean low) {
        this.value = value;
        this.sign = sign;
        this.low = low;
    }

    public int getValue() {
        return value;
    }

    public char getSign() {
        return sign;
    }

    public boolean isLow() {
        return low;
    }

}
