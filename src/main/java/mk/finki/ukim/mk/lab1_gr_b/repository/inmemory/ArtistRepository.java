/*
package mk.finki.ukim.mk.lab1_gr_b.repository.inmemory;

import mk.finki.ukim.mk.lab1_gr_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }

    public Artist findById(Long id){
        return DataHolder.artists.stream().filter(artist -> artist.getId().equals(id)).findFirst().orElse(null);
    }
}
*/
