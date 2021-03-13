package com.eaa.jaraon.web;

import com.eaa.jaraon.game.GameGenerator;
import com.eaa.jaraon.game.render.HtmlGameRenderer;
import com.eaa.jaraon.model.Game;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;

@Path("/")
public class GameResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response game() throws IOException {
        Game game = new GameGenerator().generate(4);
        InputStream gameStream = new HtmlGameRenderer().render(game);
        return Response.ok(IOUtils.toString(gameStream, "UTF-8"), MediaType.TEXT_HTML).build();
    }
}