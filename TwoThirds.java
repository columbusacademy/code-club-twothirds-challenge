import java.util.ArrayList;


public class TwoThirds
{
  public static int play(ArrayList<Strat> strats, int numWinsNeeded)
  {
    Player[] players = new Player[strats.size()];
    int[] nums = new int[strats.size()];
    String[] names = new String[players.length];

    for(int i = 0; i< strats.size(); i++)
      players[i]=new Player(strats.get(i));

    for (int i = 0; i<players.length;i++)
      names[i] = players[i].getName();

    BarDisplay display = new BarDisplay(1000,700,"scores",players.length,names);



    for (int i = 0; i<numWinsNeeded; i++)
    {
      int n = playRound(players);
      nums[n]+=1;
      try{Thread.sleep(1000);}catch(Exception e){}//Uncomment this to remove delay
      display.updateValues(nums);
    }

    int winner = 0;
    System.out.println();
    for(int i = 0; i<nums.length; i++) {
      System.out.println(players[i].getName() + " scored: " + nums[i]);
      if (nums[winner] < nums[i])
        winner = i;
    }

    return winner;
  }
  

  private static int playRound(Player[] players) {
    try { Thread.sleep(200/ players.length); } catch(Exception e) { }//Remove if taking too long
    int[] nums = new int[players.length];
    double sum = 0;
    System.out.println();
    for (int i = 0; i < nums.length; i++) {
      int n = players[i].getNumber();
      nums[i] = n;
      sum += n;

    }
    int winner = 0;
    double avrege = 2*(sum / players.length)/3;
    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(avrege-nums[i])<Math.abs(avrege-nums[winner]))
        winner = i;
    }

    for(int i = 0; i<players.length; i++) {
      if(i==winner)
        players[i].roundEnded(true,nums,winner);
      else
        players[i].roundEnded(false,nums,winner);
    }



    System.out.println();

//
//    for(int i = 0; i<players.length; i++)
//      System.out.print(players[i].getName()+": " + nums[i]+"  ");
//    System.out.print("avrege was: " + avrege + "   "+ "winner: "+players[winner].getName());



    return winner;
  }
}