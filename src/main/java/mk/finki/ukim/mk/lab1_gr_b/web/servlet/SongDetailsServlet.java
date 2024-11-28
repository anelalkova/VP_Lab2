/*
package mk.finki.ukim.mk.lab1_gr_b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import mk.finki.ukim.mk.lab1_gr_b.service.ArtistService;
import mk.finki.ukim.mk.lab1_gr_b.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    private static SongService songService;
    private static ArtistService artistService;
    private static SpringTemplateEngine springTemplateEngine;

    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        long songId = Long.parseLong((String) req.getSession().getAttribute("selectedSongId"));
        long artistId = Long.parseLong((String) req.getSession().getAttribute("selectedArtistId"));
        Song song = songService.findByTrackId(songId);
        Artist artist = artistService.ArtistfindById(artistId);
        if(song == null || artist == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            if (!song.getPerformers().contains(artist)) {
                songService.addArtistToSong(artist, song);
            }
        }
        context.setVariable("songDetails", song);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        long songId = Long.parseLong((String) req.getSession().getAttribute("selectedSongId"));
        String ratingstr = req.getParameter("typedRating");
        Song song = songService.findByTrackId(songId);
        if(song == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            if(!ratingstr.isEmpty() || ratingstr != null) {
                int rating = Integer.parseInt(ratingstr);
                if(rating > 0 || rating < 5) {
                    songService.addRating(rating, song);
                }else{
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
            }else{
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
        resp.sendRedirect("/songDetails");
    }
}
*/
