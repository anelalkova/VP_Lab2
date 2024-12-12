package mk.finki.ukim.mk.lab1_gr_b.service.implementation;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import mk.finki.ukim.mk.lab1_gr_b.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab1_gr_b.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImplementation implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImplementation(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artist not found with ID: " + id));
    }
}
