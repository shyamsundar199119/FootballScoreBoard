package eu.sportradar.footballscoreboard.services;

import eu.sportradar.footballscoreboard.entity.ScoreBoard;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardServicesTest {

    @InjectMocks
    ScoreBoardServices scoreBoardServices= new ScoreBoardServicesImpl();

    @Test
    public void startGame() {
        assertTrue(scoreBoardServices.startGame("Germany","Spain"));
        assertFalse(scoreBoardServices.startGame("",""));
        assertFalse(scoreBoardServices.startGame(null,null));
    }

    @Test
    public void finishGame() {
        assertFalse(scoreBoardServices.finishGame("Germany","Spain"));
        scoreBoardServices.startGame("Germany","Spain");
        assertTrue(scoreBoardServices.finishGame("Germany","Spain"));
        assertFalse(scoreBoardServices.finishGame("Germany","Spain"));
    }

    @Test
    public void updateGame() {
        assertFalse(scoreBoardServices.updateGame("Germany",1,"Spain",0));
        scoreBoardServices.startGame("Germany","Spain");
        assertTrue(scoreBoardServices.updateGame("Germany",1,"Spain",0));
    }

    @Test
    public void getSummary() {
        List<ScoreBoard> scoreBoardList=new ArrayList<ScoreBoard>();

        ScoreBoard sb1=new ScoreBoard("Mexico","Canada");
        sb1.setHomeTeamScore(0);
        sb1.setAwayTeamScore(5);

        ScoreBoard sb2=new ScoreBoard("Spain","Brazil");
        sb2.setHomeTeamScore(10);
        sb2.setAwayTeamScore(2);

        ScoreBoard sb3=new ScoreBoard("Germany","France");
        sb3.setHomeTeamScore(2);
        sb3.setAwayTeamScore(2);

        ScoreBoard sb4=new ScoreBoard("Uruguay","Italy");
        sb4.setHomeTeamScore(6);
        sb4.setAwayTeamScore(6);

        ScoreBoard sb5=new ScoreBoard("Argentina","Australia");
        sb5.setHomeTeamScore(3);
        sb5.setAwayTeamScore(1);

        scoreBoardList.add(sb4);
        scoreBoardList.add(sb2);
        scoreBoardList.add(sb1);
        scoreBoardList.add(sb5);
        scoreBoardList.add(sb3);



        scoreBoardServices.startGame("Mexico","Canada");
        scoreBoardServices.updateGame("Mexico",0,"Canada",5);

        scoreBoardServices.startGame("Spain","Brazil");
        scoreBoardServices.updateGame("Spain",10,"Brazil",2);

        scoreBoardServices.startGame("Germany","France");
        scoreBoardServices.updateGame("Germany",2,"France",2);

        scoreBoardServices.startGame("Uruguay","Italy");
        scoreBoardServices.updateGame("Uruguay",6, "Italy",6);

        scoreBoardServices.startGame("Argentina","Australia");
        scoreBoardServices.updateGame("Argentina",3,"Australia",1);

        scoreBoardList.stream().forEach(System.out::println);
        System.out.println("--------------");
        scoreBoardServices.getSummary().stream().forEach(System.out::println);
        assertTrue(scoreBoardServices.getSummary().equals(scoreBoardList));

    }
}