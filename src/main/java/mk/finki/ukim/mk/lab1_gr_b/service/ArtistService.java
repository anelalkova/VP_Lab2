package mk.finki.ukim.mk.lab1_gr_b.service;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService{
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);
}