package _08_clean_code_n_refactoring.exercise;

public class TennisGame {
    public static int scoreOfPlayer1, scoreOfPlayer2;
    public static boolean tie = scoreOfPlayer1 == scoreOfPlayer2;
    public static int minusResult = scoreOfPlayer1-scoreOfPlayer2;
    public static String score = "";


    public static String getScore(String playerOneName, String playerTwoName, int scoreOfPlayer1, int scoreOfPlayer2) {
        if (tie) {
            caseTie(scoreOfPlayer1);
        }
        else if (scoreOfPlayer1>=4 || scoreOfPlayer2>=4) {
            caseAdvantageForPlayer(minusResult);
        }
        else {
            caseOnePlayerTakeTheLead(scoreOfPlayer1,scoreOfPlayer2);
        }
        return score;
    }


    public static void caseTie(int PlayerScore){
        switch (PlayerScore){
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
    }

    public static void caseAdvantageForPlayer(int minusResult){
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
    }

    public static void caseOnePlayerTakeTheLead(int scoreOfPlayer1, int scoreOfPlayer2){
        int tempScore =0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = scoreOfPlayer1;
            else { score+="-"; tempScore = scoreOfPlayer2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getScore("Nam","Trung",15,30));
    }
}
