package mk.finki.ukim.mk.lab1_gr_b.repository;

import mk.finki.ukim.mk.lab1_gr_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Song findByTrackId(Long trackId){
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song){
        List<Artist>artists = song.getPerformers();
        artists.add(artist);
        song.setPerformers(artists);
        return artist;
    }

    public void addRating(int rating, Song song){
        List<Integer> ratings = song.getRatings();
        ratings.add(rating);
        song.setRatings(ratings);
        song.setAverageRating(song.getRatings().stream().mapToDouble(Integer::doubleValue).sum() / ratings.size());
    }

    public void deleteSong(Song song){
        DataHolder.songs.remove(song);
    }

    public void updateSong(Long id, Song song) {
        Song song1 = findByTrackId(id);
        DataHolder.songs.remove(song1);
        DataHolder.songs.add(song);
    }

    public void saveSong(Song song){
        DataHolder.songs.add(song);
    }
}
