package mk.finki.ukim.mk.lab1_gr_b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private List<Integer> ratings;
    private double averageRating;
    private Album album;

    public Song(String title, String genre, int releaseYear, Album album) {
        this.trackId = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.averageRating = 0;
        this.album = album;
    }
}
