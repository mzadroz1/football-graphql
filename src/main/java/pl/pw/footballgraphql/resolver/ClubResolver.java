package pl.pw.footballgraphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.pw.footballgraphql.entity.Club;
import pl.pw.footballgraphql.service.ClubService;

import java.util.List;

@DgsComponent
public class ClubResolver {
    private final ClubService clubService;

    public ClubResolver(ClubService clubService) {
        this.clubService = clubService;
    }

    @DgsQuery
    public List<Club> clubs() {
        return clubService.getAllClubs();
    }

    @DgsQuery
    public Club club(@InputArgument String id) {
        return clubService.getClubs(id);
    }

}
