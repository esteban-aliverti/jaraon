/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author esteban
 */
public class Game {
    private List<Integer> lowValuesPool;
    private List<Integer> highValuesPool;
    private List<Integer> lowSignsPool;
    private List<Integer> highSignsPool;

    private Map<Integer, Value> dictionary;
    private List<List<Value>> pyramid;

    public Game(List<Integer> lowValuesPool, List<Integer> highValuesPool, List<Integer> lowSignsPool, List<Integer> highSignsPool, Map<Integer, Value> dictionary, List<List<Value>> pyramid) {
        this.lowValuesPool = lowValuesPool;
        this.highValuesPool = highValuesPool;
        this.lowSignsPool = lowSignsPool;
        this.highSignsPool = highSignsPool;
        this.dictionary = dictionary;
        this.pyramid = pyramid;
    }

    public List<Character> getLowSignsPoolAsChars() {
        return getAsChars(lowSignsPool);
    }

    public List<Character> getHighSignsPoolAsChars() {
        return getAsChars(highSignsPool);
    }

    private List<Character> getAsChars(List<Integer> ints) {
        List<Character> result = new ArrayList<>();
        for (Integer i : ints) {
            result.add((char) i.intValue());
        }
        return result;
    }

    public List<Integer> getLowValuesPool() {
        return lowValuesPool;
    }

    public void setLowValuesPool(List<Integer> lowValuesPool) {
        this.lowValuesPool = lowValuesPool;
    }

    public List<Integer> getHighValuesPool() {
        return highValuesPool;
    }

    public void setHighValuesPool(List<Integer> highValuesPool) {
        this.highValuesPool = highValuesPool;
    }

    public List<Integer> getLowSignsPool() {
        return lowSignsPool;
    }

    public void setLowSignsPool(List<Integer> lowSignsPool) {
        this.lowSignsPool = lowSignsPool;
    }

    public List<Integer> getHighSignsPool() {
        return highSignsPool;
    }

    public void setHighSignsPool(List<Integer> highSignsPool) {
        this.highSignsPool = highSignsPool;
    }

    public Map<Integer, Value> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<Integer, Value> dictionary) {
        this.dictionary = dictionary;
    }

    public List<List<Value>> getPyramid() {
        return pyramid;
    }

    public void setPyramid(List<List<Value>> pyramid) {
        this.pyramid = pyramid;
    }

}
