package mk.finki.ukim.mk.lab1_gr_b.service;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;

import java.util.List;

public interface SongService{
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);
    void addRating(int rating, Song song);
    void deleteSong(Song song);
    void updateSong(Long id, Song song);
    void saveSong(Song song);
    List<Song>findAllByAlbum_Id(Long albumId);
}