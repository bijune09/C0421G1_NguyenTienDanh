package _08_clean_code_n_refactoring.exercise;

public class TennisGame {

    public static String getScore(String playerOneName, String playerTwoName, int scoreOne, int scoreTwo) {
        if (scoreOne == scoreTwo) {
            return drawScore(scoreOne);
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            return advantageScore(scoreOne, scoreTwo);
        } else {
            return playerScore(scoreOne) + "-" + playerScore(scoreTwo);
        }
    }

    public static String playerScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }


    public static String advantageScore(int scoreOne, int scoreTwo) {
        int minusResult = scoreOne - scoreTwo;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    public static String drawScore(int ScoreOne) {
        switch (ScoreOne) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";

            case 2:
                return "Thirty-All";

            case 3:
                return "Forty-All";

            default:
                return "Deuce";

        }
    }

}