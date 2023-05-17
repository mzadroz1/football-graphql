package pl.pw.footballgraphql.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id", nullable = false)
    private Long clubId;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "short_name", nullable = false, length = 4)
    private String shortName;

    @Column(name = "founding_date", nullable = false)
    private LocalDate foundingDate;

    @OneToMany(mappedBy = "club")
    @BatchSize(size = 100)
    private Set<Player> players = new LinkedHashSet<>();

    @OneToMany(mappedBy = "host")
    @BatchSize(size = 100)
    private Set<Match> homeMatches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "visitor")
    @BatchSize(size = 100)
    private Set<Match> visitorMatches = new LinkedHashSet<>();

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(Set<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public Set<Match> getVisitorMatches() {
        return visitorMatches;
    }

    public void setVisitorMatches(Set<Match> visitorMatches) {
        this.visitorMatches = visitorMatches;
    }

}