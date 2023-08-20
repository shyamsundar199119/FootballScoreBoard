# Football World Cup Score Board Library
The FootballScoreBoard library is a simple Java implementation of a Football World Cup Score Board. It allows you to start games, update scores, finish games, and retrieve a summary of games sorted by total score.

# Assumption

Summary will retrieve the list of match which is completed and on-going. 

Games will be sorted by total goals scored. And those games with the same total will sorted by most recently started game


# Features
Start a game by providing the home team and away team.
Update scores for ongoing games.
Finish a game and remove it from the scoreboard.
Get a summary of games ordered by total score.

# Usage
Clone or download the repository to your local machine.
Open the project in your preferred Java IDE.
Navigate to the ScoreBoardServicesImplTest.java and modify the test methods to test the library.

# Class Overview
## ScoreBoardServicesImpl
This class represents the main FootballScoreBoard library. It provides methods to manage games, update scores, and retrieve summaries.

## Methods
startGame(String homeTeam, String awayTeam): Starts a new game with the given home team and away team.
finishGame(String homeTeam, String awayTeam): Finishes a game and removes it from the scoreboard.
updateScore(String homeTeam, int homeScore, String awayTeam, int awayScore): Updates the score of an ongoing game.
getSummary(): Retrieves a summary of games ordered by total score.


## ScoreBoard
This class represents a single football game. It stores information about the home team, away team, home score, and away score.
