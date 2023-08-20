package eu.sportradar.footballscoreboard.entity;

import java.time.Instant;
import java.util.Objects;

public class ScoreBoard {
    String homeTeamName;
    String awayTeamName;
    int homeTeamScore;
    int awayTeamScore;
    int totalGoalsScored;
    public Instant matchStartTime;
    boolean isGameCompleted;

    public ScoreBoard(String homeTeamName, String awayTeamName) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
    }

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored = totalGoalsScored;
    }

    public Instant getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(Instant matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoard that = (ScoreBoard) o;
        return homeTeamScore == that.homeTeamScore && awayTeamScore == that.awayTeamScore && homeTeamName.equals(that.homeTeamName) && awayTeamName.equals(that.awayTeamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "homeTeamName='" + homeTeamName + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                ", totalGoalsScored=" + totalGoalsScored +
                ", matchStartTime=" + matchStartTime +
                '}';
    }
}
