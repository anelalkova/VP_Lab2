package mk.finki.ukim.mk.lab1_gr_b.service;

import mk.finki.ukim.mk.lab1_gr_b.model.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();
    public Album findById(long id);
}
