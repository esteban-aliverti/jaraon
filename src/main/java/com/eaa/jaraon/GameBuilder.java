/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon;

import com.eaa.jaraon.model.Game;
import com.eaa.jaraon.model.Value;
import java.util.List;
import java.util.Map;


public class GameBuilder {

    private List<Integer> lowValuesPool;
    private List<Integer> highValuesPool;
    private List<Integer> lowSignsPool;
    private List<Integer> highSignsPool;
    private Map<Integer, Value> dictionary;
    private List<java.util.List<com.eaa.jaraon.model.Value>> pyramid;

    public GameBuilder() {
    }

    public GameBuilder setLowValuesPool(List<Integer> lowValuesPool) {
        this.lowValuesPool = lowValuesPool;
        return this;
    }

    public GameBuilder setHighValuesPool(List<Integer> highValuesPool) {
        this.highValuesPool = highValuesPool;
        return this;
    }

    public GameBuilder setLowSignsPool(List<Integer> lowSignsPool) {
        this.lowSignsPool = lowSignsPool;
        return this;
    }

    public GameBuilder setHighSignsPool(List<Integer> highSignsPool) {
        this.highSignsPool = highSignsPool;
        return this;
    }

    public GameBuilder setDictionary(Map<Integer, Value> dictionary) {
        this.dictionary = dictionary;
        return this;
    }

    public GameBuilder setPyramid(List<java.util.List<com.eaa.jaraon.model.Value>> pyramid) {
        this.pyramid = pyramid;
        return this;
    }

    public Game createGame() {
        return new Game(lowValuesPool, highValuesPool, lowSignsPool, highSignsPool, dictionary, pyramid);
    }

}
