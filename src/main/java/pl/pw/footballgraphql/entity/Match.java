package pl.pw.footballgraphql.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false)
    private Long matchId;

    @Column(name = "match_date", nullable = false)
    private LocalDate matchDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "host", nullable = false)
    private Club host;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "visitor", nullable = false)
    private Club visitor;

    @OneToMany(mappedBy = "match")
    private Set<PlayerMatch> playerMatches = new LinkedHashSet<>();

    @Column(name = "host_goals")
    private Integer hostGoals;

    @Column(name = "visitor_goals")
    private Integer visitorGoals;

    public Integer getVisitorGoals() {
        return visitorGoals;
    }

    public void setVisitorGoals(Integer visitorGoals) {
        this.visitorGoals = visitorGoals;
    }

    public Integer getHostGoals() {
        return hostGoals;
    }

    public void setHostGoals(Integer hostGoals) {
        this.hostGoals = hostGoals;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public Club getHost() {
        return host;
    }

    public void setHost(Club host) {
        this.host = host;
    }

    public Club getVisitor() {
        return visitor;
    }

    public void setVisitor(Club visitor) {
        this.visitor = visitor;
    }

    public Set<PlayerMatch> getPlayerMatches() {
        return playerMatches;
    }

    public void setPlayerMatches(Set<PlayerMatch> playerMatches) {
        this.playerMatches = playerMatches;
    }

}