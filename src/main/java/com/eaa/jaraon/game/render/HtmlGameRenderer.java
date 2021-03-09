/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.game.render;

import com.eaa.jaraon.model.Game;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.stringtemplate.v4.ST;

/**
 *
 * @author esteban
 */
public class HtmlGameRenderer implements GameRenderer {

    @Override
    public InputStream render(Game game) {
        try {
            String indexTpl = IOUtils.toString(HtmlGameRenderer.class.getResourceAsStream("/html/game-index.template.html"), "UTF-8");

            ST indexTemplate = new ST(indexTpl, '~', '~');
            indexTemplate.add("game", game);
            return new ByteArrayInputStream(indexTemplate.render().getBytes());
        } catch (IOException ex) {
            throw new IllegalStateException("Exception Rendering the Game", ex);
        }
    }

}
