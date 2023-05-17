package pl.pw.footballgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.footballgraphql.entity.Match;

import java.util.Arrays;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByHost_ClubIdOrVisitor_ClubId(Long clubId, Long clubId1);
    
    
}