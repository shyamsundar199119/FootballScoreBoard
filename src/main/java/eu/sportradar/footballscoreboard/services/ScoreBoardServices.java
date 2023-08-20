package eu.sportradar.footballscoreboard.services;

import eu.sportradar.footballscoreboard.entity.ScoreBoard;

import java.util.List;

public interface ScoreBoardServices {

    public boolean startGame(String homeTeamName, String awayTeamName);

    public boolean finishGame(String homeTeamName, String awayTeamName);

    public boolean updateGame(String homeTeamName, int homeTeamScore, String awayTeamName, int awayTeamScore);

    public List<ScoreBoard> getSummary();
}
