/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.game.render;

import com.eaa.jaraon.model.Game;
import com.eaa.jaraon.model.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Wrapper of {@link Game} adding utility methods for {@link HtmlGameRenderer}.
 *
 * @author esteban
 */
public class HtmlGame {

    private final Game game;

    public HtmlGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public List<List<Character>> getLowHelperTableValues() {
        return getHelperTableValues(game.getLowSignsPool(), game.getLowValuesPool(), game.getDictionary());
    }

    public List<List<Character>> getHighHelperTableValues() {
        return getHelperTableValues(game.getHighSignsPool(), game.getHighValuesPool(), game.getDictionary());
    }

    private List<List<Character>> getHelperTableValues(List<Integer> signs, List<Integer> values, Map<Integer, Value> dict) {
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
}
