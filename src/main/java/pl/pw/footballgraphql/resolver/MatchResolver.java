package pl.pw.footballgraphql.resolver;


import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.pw.footballgraphql.entity.Match;
import pl.pw.footballgraphql.service.MatchService;

import java.util.List;

@DgsComponent
public class MatchResolver {

    private final MatchService matchService;

    public MatchResolver(MatchService matchService) {
        this.matchService = matchService;
    }

    @DgsQuery
    public List<Match> matches(@InputArgument String clubId) {
        return matchService.getAllMatchesForClub(clubId);
    }
}
