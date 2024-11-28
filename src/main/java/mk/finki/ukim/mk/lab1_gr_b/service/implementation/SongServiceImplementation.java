package mk.finki.ukim.mk.lab1_gr_b.service.implementation;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import mk.finki.ukim.mk.lab1_gr_b.repository.ArtistRepository;
import mk.finki.ukim.mk.lab1_gr_b.repository.SongRepository;
import mk.finki.ukim.mk.lab1_gr_b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImplementation implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImplementation(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        if (artist == null || artist.getId() == null || song == null) {
            throw new IllegalArgumentException("Artist and song must not be null, and artist must have a valid ID.");
        }

        Artist existingArtist = artistRepository.findById(artist.getId());

        songRepository.addArtistToSong(existingArtist, song);

        return existingArtist;
    }


    @Override
    public Song findByTrackId(Long trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void addRating(int rating, Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
        songRepository.addRating(rating, song);
    }

    @Override
    public void deleteSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
        songRepository.deleteSong(song);
    }

    @Override
    public void updateSong(Long id, Song song) {
        if(song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
        songRepository.updateSong(id, song);
    }

    @Override
    public void saveSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
        songRepository.saveSong(song);
    }
}
