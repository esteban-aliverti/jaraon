/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.model;

import com.eaa.jaraon.model.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.toMap;

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
    private Map<Character, Value> inverseDictionary;
    private List<List<Value>> pyramid;

    public Game(List<Integer> lowValuesPool, List<Integer> highValuesPool, List<Integer> lowSignsPool, List<Integer> highSignsPool, Map<Integer, Value> dictionary, List<List<Value>> pyramid) {
        this.lowValuesPool = lowValuesPool;
        this.highValuesPool = highValuesPool;
        this.lowSignsPool = lowSignsPool;
        this.highSignsPool = highSignsPool;
        this.dictionary = dictionary;
        this.inverseDictionary = createInverseDictionary(dictionary);
        this.pyramid = pyramid;
    }

    public Value getValueForValue(int v) {
        return this.dictionary.get(v);
    }

    public Value getValueForChar(char c) {
        return this.inverseDictionary.get(c);
    }

    public List<Character> getLowSignsPoolAsChars() {
        return getAsChars(lowSignsPool);
    }

    public List<Character> getHighSignsPoolAsChars() {
        return getAsChars(highSignsPool);
    }

    public List<List<Character>> getLowHelperTableValues() {
        return getHelperTableValues(lowSignsPool, lowValuesPool, dictionary);
    }

    public List<List<Character>> getHighHelperTableValues() {
        return getHelperTableValues(highSignsPool, highValuesPool, dictionary);
    }

    private List<Character> getAsChars(List<Integer> ints) {
        List<Character> result = new ArrayList<>();
        for (Integer i : ints) {
            result.add((char) i.intValue());
        }
        return result;
    }

    public List<List<Character>> getHelperTableValues(List<Integer> signs, List<Integer> values, Map<Integer, Value> dict) {
        List<List<Character>> table = new ArrayList<>();
        for (Integer sign : signs) {
            List<Character> row = new ArrayList<>();
            table.add(row);
            row.add((char) sign.intValue()); //add the sign as the first element
            for (Integer val : values) {
                row.add((dict.get(val).getSign() == (char) sign.intValue()) ? 'X' : ' ');
            }
        }
        return table;
    }

    private Map<Character, Value> createInverseDictionary(Map<Integer, Value> dictionary) {
        return dictionary.values().stream().collect(toMap(Value::getSign, Function.identity()));
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
