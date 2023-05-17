package pl.pw.footballgraphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.pw.footballgraphql.entity.Player;
import pl.pw.footballgraphql.entity.PlayerStatistics;
import pl.pw.footballgraphql.service.PlayerService;

import java.util.List;

@DgsComponent
public class PlayerResolver {

    private final PlayerService playerService;

    public PlayerResolver(PlayerService playerService) {
        this.playerService = playerService;
    }

    @DgsQuery
    public List<Player> players() {
        return playerService.getAllPlayers();
    }

    @DgsQuery
    public List<PlayerStatistics> playersStatistics() {
        return playerService.getPlayersStatistics();
    }

    @DgsQuery
    public PlayerStatistics playerStatistics(@InputArgument String id) {
        return playerService.getPlayerStatistics(id);
    }

}
