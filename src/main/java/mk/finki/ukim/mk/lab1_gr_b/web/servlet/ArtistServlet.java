/*
package mk.finki.ukim.mk.lab1_gr_b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab1_gr_b.service.ArtistService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ArtistServlet", urlPatterns = "")
public class ArtistServlet extends HttpServlet {
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

*/
/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedSongId = req.getParameter("selectedSongId");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        if (selectedSongId != null) {
            req.getSession().setAttribute("selectedSongId", selectedSongId);
        }

        context.setVariable("selectedSongId", selectedSongId);
        context.setVariable("listArtists", artistService.listArtists());
        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
    }
*//*



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String selectedArtistId = req.getParameter("selectedArtist");
        req.getSession().setAttribute("selectedArtistId", selectedArtistId);
        resp.sendRedirect("/songDetails");
    }
}
*/
