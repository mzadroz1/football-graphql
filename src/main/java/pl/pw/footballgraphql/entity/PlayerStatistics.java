package pl.pw.footballgraphql.entity;

public class PlayerStatistics {
  private Player player;

  private int matchCount;

  private int goalsScored;

  private int yellowCards;

  private int redCards;

  public PlayerStatistics() {
  }

  public PlayerStatistics(Player player, int matchCount, int goalsScored, int yellowCards,
                          int redCards) {
    this.player = player;
    this.matchCount = matchCount;
    this.goalsScored = goalsScored;
    this.yellowCards = yellowCards;
    this.redCards = redCards;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public void setMatchCount(int matchCount) {
    this.matchCount = matchCount;
  }

  public int getGoalsScored() {
    return goalsScored;
  }

  public void setGoalsScored(int goalsScored) {
    this.goalsScored = goalsScored;
  }

  public int getYellowCards() {
    return yellowCards;
  }

  public void setYellowCards(int yellowCards) {
    this.yellowCards = yellowCards;
  }

  public int getRedCards() {
    return redCards;
  }

  public void setRedCards(int redCards) {
    this.redCards = redCards;
  }

  @Override
  public String toString() {
    return "PlayerStatistics{" + "player='" + player + "'," +"matchCount='" + matchCount + "'," +"goalsScored='" + goalsScored + "'," +"yellowCards='" + yellowCards + "'," +"redCards='" + redCards + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatistics that = (PlayerStatistics) o;
        return java.util.Objects.equals(player, that.player) &&
                            matchCount == that.matchCount &&
                            goalsScored == that.goalsScored &&
                            yellowCards == that.yellowCards &&
                            redCards == that.redCards;
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(player, matchCount, goalsScored, yellowCards, redCards);
  }
}
