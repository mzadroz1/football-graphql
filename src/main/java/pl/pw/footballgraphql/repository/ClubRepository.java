package pl.pw.footballgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.footballgraphql.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}