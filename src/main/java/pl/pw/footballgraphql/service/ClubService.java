package pl.pw.footballgraphql.service;

import org.springframework.stereotype.Service;
import pl.pw.footballgraphql.entity.Club;
import pl.pw.footballgraphql.repository.ClubRepository;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club getClubs(String id) {
        return clubRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalArgumentException("Club with given id=" + id + " not found"));
    }
}
