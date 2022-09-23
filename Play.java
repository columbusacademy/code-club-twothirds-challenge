import java.util.ArrayList;

public class Play
{
  public static void main(String[] args)
  {

    Strat player1 = new RandomGuesser();
    Strat player2 = new RandomUnderTwenty();
    Strat player3 = new AlwaysOne();
    Strat player4 = new ImitateWinner();

    ArrayList<Strat> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);
    players.add(player3);
    players.add(player4);

    int winner = TwoThirds.play(players,10);
    System.out.println("winner = " + winner);
  }
}