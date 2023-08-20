package eu.sportradar.footballscoreboard.services;

import eu.sportradar.footballscoreboard.entity.ScoreBoard;

import java.util.List;

public interface ScoreBoardServices {

    public boolean startGame(String homeTeamName, String awayTeamName);

    public boolean finishGame();

    public boolean updateGame(int homeTeamScore, int awayTeamScore);

    public List<ScoreBoard> getSummary();
}
