package mk.finki.ukim.mk.lab1_gr_b.repository.jpa;

import mk.finki.ukim.mk.lab1_gr_b.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {}
