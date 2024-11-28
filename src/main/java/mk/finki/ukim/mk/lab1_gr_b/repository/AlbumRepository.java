package mk.finki.ukim.mk.lab1_gr_b.repository;

import mk.finki.ukim.mk.lab1_gr_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1_gr_b.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }
    public Album findById(long id){
        return DataHolder.albums.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }
}
