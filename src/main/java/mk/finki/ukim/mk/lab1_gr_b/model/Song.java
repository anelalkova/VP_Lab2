package mk.finki.ukim.mk.lab1_gr_b.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;

    @ManyToMany
    private List<Artist> performers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "song_ratings", joinColumns = @JoinColumn(name = "song_id"))
    @Column(name = "rating")
    private List<Integer> ratings = new ArrayList<>();

    @Transient
    private double averageRating;

    @ManyToOne
    private Album album;

    public Song(String title, String genre, int releaseYear, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }

    public Song() {}

    public double getAverageRating() {
        return ratings.isEmpty() ? 0 : ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
