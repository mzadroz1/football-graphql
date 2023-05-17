package pl.pw.footballgraphql.service;

import org.springframework.stereotype.Service;
import pl.pw.footballgraphql.entity.Match;
import pl.pw.footballgraphql.repository.MatchRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatchesForClub(String clubId) {
        long id = Long.parseLong(clubId);
        return matchRepository.findByHost_ClubIdOrVisitor_ClubId(id, id);
    }
}
