package mk.finki.ukim.mk.lab1_gr_b.web.controller;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}