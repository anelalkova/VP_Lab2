package mk.finki.ukim.mk.lab1_gr_b.web.controller;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import mk.finki.ukim.mk.lab1_gr_b.service.ArtistService;
import mk.finki.ukim.mk.lab1_gr_b.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtist(@RequestParam(required = false) Long selectedSongId, Model model) {
        if (selectedSongId == null || songService.findByTrackId(selectedSongId) == null) {
            System.out.println("Invalid song ID: " + selectedSongId);
            return "redirect:/songs?error=No+valid+song+selected";
        }

        List<Artist> list = artistService.listArtists();
        System.out.println("Artists found: " + (list != null ? list.size() : "null"));

        model.addAttribute("listArtists", list);
        model.addAttribute("selectedSongId", selectedSongId);

        return "artistsList";
    }

    @PostMapping("/addArtist")
    public String addArtist(@RequestParam("selectedArtist") Long artistId,
                            @RequestParam("selectedSongId") Long songId,
                            RedirectAttributes redirectAttributes) {
        if (artistId == null || songId == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid artist or song selected.");
            return "redirect:/artist";
        }

        Artist artist = artistService.findById(artistId);
        Song song = songService.findByTrackId(songId);
        if (artist != null && song != null) {
            songService.addArtistToSong(artist, song);
            redirectAttributes.addFlashAttribute("success", "Artist added to the song successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Artist or song not found.");
        }

        return "redirect:/songs/songDetails/" + songId;
    }
}
