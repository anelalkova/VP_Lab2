package mk.finki.ukim.mk.lab1_gr_b.repository.jpa;

import mk.finki.ukim.mk.lab1_gr_b.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {}
