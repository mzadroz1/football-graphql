package pl.pw.footballgraphql.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import pl.pw.footballgraphql.entity.Player;
import pl.pw.footballgraphql.entity.PlayerMatch;
import pl.pw.footballgraphql.entity.PlayerStatistics;
import pl.pw.footballgraphql.repository.PlayerRepository;

import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository)  {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @NotNull
    public PlayerStatistics getPlayerStatistics(Player player) {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        Set<PlayerMatch> playerMatches = player.getPlayerMatches();
        playerStatistics.setMatchCount(playerMatches.size());
        playerStatistics.setPlayer(player);
        playerMatches.forEach(
                playerMatch -> {
                    playerStatistics.setGoalsScored(playerStatistics.getGoalsScored() + playerMatch.getGoals());
                    playerStatistics.setYellowCards(playerStatistics.getYellowCards() + playerMatch.getYellowCards());
                    playerStatistics.setRedCards(playerStatistics.getRedCards() + playerMatch.getRedCard());
                }
        );
        return playerStatistics;
    }
}
