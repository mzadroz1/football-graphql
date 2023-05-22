package pl.pw.footballgraphql.resolver;

import com.netflix.graphql.dgs.*;
import pl.pw.footballgraphql.entity.Player;
import pl.pw.footballgraphql.entity.PlayerStatistics;
import pl.pw.footballgraphql.generated.DgsConstants;
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



    @DgsData(parentType = DgsConstants.PLAYER.TYPE_NAME, field = DgsConstants.PLAYER.PlayerStatistics)
    public PlayerStatistics playerStatistics(DgsDataFetchingEnvironment dfe) {
        Player player = dfe.getSource();
        return playerService.getPlayerStatistics(player);
    }

}
