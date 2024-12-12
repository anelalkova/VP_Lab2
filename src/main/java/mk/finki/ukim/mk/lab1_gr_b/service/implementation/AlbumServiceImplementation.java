package mk.finki.ukim.mk.lab1_gr_b.service.implementation;

import mk.finki.ukim.mk.lab1_gr_b.model.Album;
import mk.finki.ukim.mk.lab1_gr_b.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab1_gr_b.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImplementation implements AlbumService{

    AlbumRepository albumRepository;

    public AlbumServiceImplementation(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }
    @Override
    public Album findById(long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Album not found with ID: " + id));
    }
}
