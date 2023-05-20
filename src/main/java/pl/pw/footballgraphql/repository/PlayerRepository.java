package pl.pw.footballgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.footballgraphql.entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByClub_ClubId(Long clubId);


}