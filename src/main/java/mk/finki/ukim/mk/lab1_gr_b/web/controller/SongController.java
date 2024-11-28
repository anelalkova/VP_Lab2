package mk.finki.ukim.mk.lab1_gr_b.web.controller;

import mk.finki.ukim.mk.lab1_gr_b.model.Album;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import mk.finki.ukim.mk.lab1_gr_b.service.AlbumService;
import mk.finki.ukim.mk.lab1_gr_b.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        List<Song> songs = songService.listSongs();

        if (error != null && !error.isEmpty()) {
            model.addAttribute("errorMessage", error);
        }

        model.addAttribute("listSongs", songs);
        return "listSongs";
    }

    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Model model) {
        Song song = songService.findByTrackId(id);
        if (song == null) {
            return "redirect:/songs?error=Song+not+found";
        }

        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "editSong";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedSong(@PathVariable Long id,
                                 @RequestParam String title,
                                 @RequestParam String genre,
                                 @RequestParam int releaseYear,
                                 @RequestParam Long albumId) {
        Album album = albumService.findById(albumId);
        songService.updateSong(id, new Song(title, genre, releaseYear, album));
        return "redirect:/songs";
    }



    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        Song song = songService.findByTrackId(id);
        this.songService.deleteSong(song);
        return "redirect:/songs";
    }

    @PostMapping("/selectSong")
    public String selectSong(@RequestParam Long selectedSongId, Model model) {
        Song song = songService.findByTrackId(selectedSongId);
        if (song == null) {
            return "redirect:/songs?error=Song+not+found";
        }
        model.addAttribute("selectedSongId", selectedSongId);
        return "redirect:/artist?selectedSongId=" + selectedSongId;
    }

    @GetMapping("/add")
    public String addSongForm(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId){
        Album album = albumService.findById(albumId);
        Song song = new Song(title, genre, releaseYear, album);
        songService.saveSong(song);
        return "redirect:/songs";
    }
    @GetMapping("/songDetails/{id}")
    public String getSongDetails(@PathVariable Long id, Model model) {
        Song song = songService.findByTrackId(id);
        if (song == null) {
            return "redirect:/songs?error=Song+not+found";
        }
        model.addAttribute("songDetails", song);
        return "songDetails";
    }

    @PostMapping("/addRating")
    public String addRating(@RequestParam int typedRating, @RequestParam Long songId, Model model) {
        Song song = songService.findByTrackId(songId);
        if (song == null) {
            return "redirect:/songs?error=Song+not+found";
        }
        songService.addRating(typedRating, song);
        return "redirect:/songs/songDetails/" + songId;
    }
}

