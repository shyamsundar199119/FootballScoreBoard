package eu.sportradar.footballscoreboard.services;

import eu.sportradar.footballscoreboard.entity.ScoreBoard;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardServicesImpl implements ScoreBoardServices {

    public ScoreBoard currentGameScoreBoard;
    public List<ScoreBoard> scoreBoardList = new ArrayList<ScoreBoard>();

    public boolean startGame(String homeTeamName, String awayTeamName) {

        if (homeTeamName == null || "".equals(homeTeamName) || awayTeamName == null || "".equals(awayTeamName)) {
            System.out.println("Invalid Team names");
            return false;
        }

        currentGameScoreBoard = new ScoreBoard(homeTeamName, awayTeamName);
        currentGameScoreBoard.setMatchStartTime(Instant.now());
        return true;
    }

    public boolean finishGame() {
        if (currentGameScoreBoard == null) {
            System.out.println("No Game in progress");
            return false;
        }
        currentGameScoreBoard.setTotalGoalsScored(currentGameScoreBoard.getHomeTeamScore() + currentGameScoreBoard.getAwayTeamScore());
        currentGameScoreBoard.setGameCompleted(true);
        scoreBoardList.add(currentGameScoreBoard);
        currentGameScoreBoard=null;
        return true;
    }

    public boolean updateGame(int homeTeamScore, int awayTeamScore) {
        if (currentGameScoreBoard == null) {
            System.out.println("No Game in progress");
            return false;
        }
        currentGameScoreBoard.setHomeTeamScore(homeTeamScore);
        currentGameScoreBoard.setAwayTeamScore(awayTeamScore);
        return true;
    }

    public List<ScoreBoard> getSummary() {
        Comparator<ScoreBoard> comparator = Comparator.comparing(scoreBoard -> scoreBoard.getTotalGoalsScored());
        comparator = comparator.thenComparing(Comparator.comparing(scoreBoard -> scoreBoard.getMatchStartTime()));
        List<ScoreBoard> list = scoreBoardList.stream().sorted(comparator).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }
}
