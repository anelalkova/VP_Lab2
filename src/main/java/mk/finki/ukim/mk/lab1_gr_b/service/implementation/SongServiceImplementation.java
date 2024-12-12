package mk.finki.ukim.mk.lab1_gr_b.service.implementation;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import mk.finki.ukim.mk.lab1_gr_b.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab1_gr_b.repository.jpa.SongRepository;
import mk.finki.ukim.mk.lab1_gr_b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (artist == null || artist.getId() == null || song == null || song.getTrackId() == null) {
            throw new IllegalArgumentException("Artist and song must not be null, and both must have valid IDs.");
        }

        Artist existingArtist = artistRepository.findById(artist.getId())
                .orElseThrow(() -> new IllegalArgumentException("Artist not found with ID: " + artist.getId()));

        Song existingSong = songRepository.findById(song.getTrackId())
                .orElseThrow(() -> new IllegalArgumentException("Song not found with ID: " + song.getTrackId()));

        existingSong.getPerformers().add(existingArtist);
        songRepository.save(existingSong);

        return existingArtist;
    }

    @Override
    public Song findByTrackId(Long trackId) {
        return songRepository.findById(trackId)
                .orElseThrow(() -> new IllegalArgumentException("Song not found with track ID: " + trackId));
    }

    @Override
    public void addRating(int rating, Song song) {
        if (song == null || song.getTrackId() == null) {
            throw new IllegalArgumentException("Song must not be null and must have a valid ID.");
        }
        Song existingSong = songRepository.findById(song.getTrackId())
                .orElseThrow(() -> new IllegalArgumentException("Song not found with ID: " + song.getTrackId()));

        existingSong.getRatings().add(rating);
        songRepository.save(existingSong);
    }

    @Override
    public void deleteSong(Song song) {
        if (song == null || song.getTrackId() == null) {
            throw new IllegalArgumentException("Song must not be null and must have a valid ID.");
        }
        songRepository.deleteById(song.getTrackId());
    }

    @Override
    public void updateSong(Long id, Song song) {
        if (song == null || id == null) {
            throw new IllegalArgumentException("Song and ID must not be null.");
        }

        Song existingSong = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Song not found with ID: " + id));

        existingSong.setTitle(song.getTitle());
        existingSong.setGenre(song.getGenre());
        existingSong.setReleaseYear(song.getReleaseYear());
        existingSong.setAlbum(song.getAlbum());
        existingSong.setPerformers(song.getPerformers());
        songRepository.save(existingSong);
    }

    @Override
    public void saveSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }
        songRepository.save(song);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId){
        return songRepository.findAllByAlbum_Id(albumId);
    }
}
