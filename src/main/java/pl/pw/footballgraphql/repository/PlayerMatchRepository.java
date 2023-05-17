package pl.pw.footballgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.footballgraphql.entity.PlayerMatch;
import pl.pw.footballgraphql.entity.PlayerMatchId;

import java.util.List;

public interface PlayerMatchRepository extends JpaRepository<PlayerMatch, PlayerMatchId> {
    List<PlayerMatch> findById_PlayerId(Long playerId);


}