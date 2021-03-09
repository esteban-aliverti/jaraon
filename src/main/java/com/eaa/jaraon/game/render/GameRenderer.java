/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.game.render;

import com.eaa.jaraon.model.Game;
import java.io.InputStream;

/**
 *
 * @author esteban
 */
public interface GameRenderer {

    public InputStream render(Game game);

}
