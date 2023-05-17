package pl.pw.footballgraphql.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import pl.pw.footballgraphql.entity.Player;
import pl.pw.footballgraphql.entity.PlayerStatistics;
import pl.pw.footballgraphql.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository)  {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerStatistics getPlayerStatistics(String id) {
        Long playerId = Long.parseLong(id);
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player with given id=" + id + " not found"));
        return getPlayerStatistics(player);
    }

    public List<PlayerStatistics> getPlayersStatistics() {
        return playerRepository.findAll().stream()
                .map(PlayerService::getPlayerStatistics)
                .collect(Collectors.toList());
    }

    @NotNull
    private static PlayerStatistics getPlayerStatistics(Player player) {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        playerStatistics.setMatchCount(player.getPlayerMatches().size());
        playerStatistics.setPlayer(player);
        player.getPlayerMatches().forEach(
                playerMatch -> {
                    playerStatistics.setGoalsScored(playerStatistics.getGoalsScored() + playerMatch.getGoals());
                    playerStatistics.setYellowCards(playerStatistics.getYellowCards() + playerMatch.getYellowCards());
                    playerStatistics.setRedCards(playerStatistics.getRedCards() + playerMatch.getRedCard());
                }
        );
        return playerStatistics;
    }
}
