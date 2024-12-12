package mk.finki.ukim.mk.lab1_gr_b.repository.jpa;

import mk.finki.ukim.mk.lab1_gr_b.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByAlbum_Id(Long albumId);
}
