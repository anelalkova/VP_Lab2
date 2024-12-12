package mk.finki.ukim.mk.lab1_gr_b.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab1_gr_b.model.Album;
import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Anastasija", "Lalkova", "Student"));
        artists.add(new Artist("Marshall", "Matters", "Rapper"));
        artists.add(new Artist("Beyonce", "Knowels", "Gotta respect the queen"));
        artists.add(new Artist("2Pac", "Shaqur", "Ne znam dali e tocno prezimeto"));
        artists.add(new Artist("Sabrina", "Carpenter", "Idek"));

        albums = new ArrayList<>();
        Album album1 = new Album("Album1", "Pop", "2002");
        Album album2 = new Album("Album2", "Rap", "2012");
        Album album3 = new Album("Album3", "Classical", "2011");
        Album album4 = new Album("Album4", "Rock", "2021");
        Album album5 = new Album("Album5", "Pop", "2000");
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);

        songs = new ArrayList<>();
        songs.add(new Song("The Real Slim Shady", "Rap", 2001, album1));
        songs.add(new Song( "Good Graces", "Pop", 2024, album2));
        songs.add(new Song("Single Ladies", "Pop", 2008, album3));
        songs.add(new Song( "Moa pesna", "Classic", 2003, album4));
        songs.add(new Song( "Title", "Techno", 2000, album5));
    }
}