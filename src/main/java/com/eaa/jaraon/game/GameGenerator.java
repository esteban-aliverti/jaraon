/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.game;

import com.eaa.jaraon.GameBuilder;
import com.eaa.jaraon.model.Game;
import com.eaa.jaraon.model.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;

/**
 *
 * @author esteban
 */
public class GameGenerator {

    private final static List<Integer> LOW_VALUES_POOL = IntStream.range(0, 5).boxed().collect(toList());
    private final static List<Integer> HIGH_VALUES_POOL = IntStream.range(5, 10).boxed().collect(toList());
    private final static List<Integer> LOW_SIGNS_POOL = IntStream.range('A', 'F').boxed().collect(toList());
    private final static List<Integer> HIGH_SIGNS_POOL = Arrays.stream(new int[]{'☘', '▲', '◆', '♥', '★'}).map(Integer::valueOf).boxed().collect(toList());

    public Game generate(int rows) {
        Map<Integer, Value> values = new HashMap<>();
        values.putAll(createValuesAndShuffle(LOW_VALUES_POOL, LOW_SIGNS_POOL).stream().collect(toMap(Value::getValue, Function.identity())));
        values.putAll(createValuesAndShuffle(HIGH_VALUES_POOL, HIGH_SIGNS_POOL).stream().collect(toMap(Value::getValue, Function.identity())));

        for (int i = 0; i < HIGH_VALUES_POOL.get(HIGH_VALUES_POOL.size() - 1) + 1; i++) {
            Value v = values.get(i);
        }

        int firstRowNumber = generateRandomDigits(5);

        List<Value> row = toValues(firstRowNumber, values);

        List<List<Value>> pyramid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            pyramid.add(row);
            row = createRow(row, values);
        }

        return new GameBuilder().setLowValuesPool(LOW_VALUES_POOL)
                .setHighValuesPool(HIGH_VALUES_POOL)
                .setLowSignsPool(LOW_SIGNS_POOL)
                .setHighSignsPool(HIGH_SIGNS_POOL)
                .setDictionary(values)
                .setPyramid(pyramid)
                .createGame();
    }

    private List<Value> createValuesAndShuffle(List<Integer> values, List<Integer> signs) {

        List<Integer> valuesPool = new ArrayList<>(values);
        Collections.shuffle(valuesPool);

        List<Integer> signsPool = new ArrayList<>(signs);
        Collections.shuffle(signsPool);

        List<Value> results = new ArrayList<>();
        for (int i = 0; i < valuesPool.size(); i++) {
            results.add(new Value(valuesPool.get(i), (char) signsPool.get(i).intValue(), isLow(valuesPool.get(i))));
        }
        return results;
    }

    private List<Value> toValues(int number, Map<Integer, Value> lookupTable) {
        String n = Integer.toString(number);

        List<Value> row = new ArrayList<>();
        for (int i = 0; i < n.length(); i++) {
            int index = Character.getNumericValue(n.charAt(i));
            row.add(lookupTable.get(index));
        }
        return row;
    }

    private List<Value> createRow(List<Value> values, Map<Integer, Value> lookupTable) {
        List<Value> row = new ArrayList<>();
        for (int i = 0; i < values.size() + 1; i++) {
            int v = i == 0 ? values.get(i).getValue() : i == values.size() ? values.get(i - 1).getValue() : (values.get(i - 1).getValue() + values.get(i).getValue()) % 10;
            row.add(lookupTable.get(v));
        }
        return row;
    }

    private static boolean isLow(int number) {
        return number <= LOW_VALUES_POOL.get(LOW_VALUES_POOL.size() - 1);
    }

    private static int generateRandomDigits(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }
}
