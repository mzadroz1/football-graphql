package pl.pw.footballgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.footballgraphql.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}