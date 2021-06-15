package _08_clean_code_n_refactoring.exercise;

public class TennisGame {
    public static String caseDrawScore(int playerScore) {
        String score = "";
        switch (playerScore) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public static String casePlayerScoreForty(int playerOneScore, int playerTwoScore) {
        String score = "";
        int minusResult = playerOneScore - playerTwoScore;
        boolean playerOneAdvantage = minusResult == 1;
        boolean playerTwoAdvantage = minusResult == -1;
        boolean playerOneWin = minusResult >= 2;
        if (playerOneAdvantage) {
            score = "Advantage player1";
        } else if (playerTwoAdvantage) {
            score = "Advantage player2";
        } else if (playerOneWin) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    public static String casePlayerScored(int playerOneScore, int playerTwoScore){
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOneScore;
            else {
                score += "-";
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    public static String getScore(String playerOneName, String playerTwoName, int playerOneScore, int playerTwoScore) {
        boolean drawScore = playerOneScore == playerTwoScore;
        if (drawScore) {
            return caseDrawScore(playerOneScore);
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return casePlayerScoreForty(playerOneScore, playerTwoScore);
        } else {
            return casePlayerScored(playerOneScore,playerTwoScore);
        }
    }

}