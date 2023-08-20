package eu.sportradar.footballscoreboard.services;

import eu.sportradar.footballscoreboard.entity.ScoreBoard;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardServicesImpl implements ScoreBoardServices {

    public List<ScoreBoard> scoreBoardList = new ArrayList<ScoreBoard>();

    public boolean startGame(String homeTeamName, String awayTeamName) {
        ScoreBoard currentGameScoreBoard;
        if (homeTeamName == null || "".equals(homeTeamName) || awayTeamName == null || "".equals(awayTeamName)) {
            System.out.println("Invalid Team names");
            return false;
        }

        currentGameScoreBoard = new ScoreBoard(homeTeamName, awayTeamName);
        currentGameScoreBoard.setMatchStartTime(Instant.now());
        scoreBoardList.add(currentGameScoreBoard);
        return true;
    }

    public boolean finishGame(String homeTeamName, String awayTeamName) {
        ScoreBoard currentGameScoreBoard=getScore(homeTeamName,awayTeamName);
        if (currentGameScoreBoard == null) {
            System.out.println("No Game found with given details");
            return false;
        }
        scoreBoardList.remove(currentGameScoreBoard);
        return true;
    }

    public boolean updateGame(String homeTeamName, int homeTeamScore, String awayTeamName, int awayTeamScore) {
        ScoreBoard currentGameScoreBoard=getScore(homeTeamName,awayTeamName);
        if (currentGameScoreBoard == null) {
            System.out.println("No Game found with given details");
            return false;
        }
        currentGameScoreBoard.setHomeTeamScore(homeTeamScore);
        currentGameScoreBoard.setAwayTeamScore(awayTeamScore);
        currentGameScoreBoard.setTotalGoalsScored(homeTeamScore + awayTeamScore);
        return true;
    }

    public List<ScoreBoard> getSummary() {
        Comparator<ScoreBoard> comparator = Comparator.comparing(scoreBoard -> scoreBoard.getTotalGoalsScored());
        comparator = comparator.thenComparing(Comparator.comparing(scoreBoard -> scoreBoard.getMatchStartTime()));
        List<ScoreBoard> list = scoreBoardList.stream().sorted(comparator).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    private ScoreBoard getScore(String homeTeamName, String awayTeamName){
        ScoreBoard scoreBoard=scoreBoardList.stream().filter(sb -> homeTeamName.equals(sb.getHomeTeamName()) && awayTeamName.equals(sb.getAwayTeamName()) )
                .findAny()
                .orElse(null);
        return scoreBoard;
    }
}
