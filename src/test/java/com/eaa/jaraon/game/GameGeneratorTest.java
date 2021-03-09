/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaa.jaraon.game;

import com.eaa.jaraon.game.render.HtmlGameRenderer;
import com.eaa.jaraon.model.Game;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 *
 * @author esteban
 */
public class GameGeneratorTest {

    @Test
    public void test() throws IOException {

        Game game = new GameGenerator().generate(4);
        InputStream is = new HtmlGameRenderer().render(game);

        File f = new File("/tmp/index.html");
        FileUtils.writeByteArrayToFile(f, IOUtils.toString(is, "UTF-8").getBytes());
    }
}
