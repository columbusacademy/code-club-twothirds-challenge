public class Player
{
  private Strat strategy;
  private int roundsWon;
  private int roundsLost;
  private int[] previouseNums;
  private int lastWinner;
  public Player(Strat strategy)
  {
    this.strategy = strategy;
    roundsWon=0;
    roundsLost=0;
  }


  public String getName()
  {
    return strategy.getClass().getName();
  }
  
  public void roundEnded(boolean outcome, int[] nums, int winner)
  {
    strategy.roundEnded(outcome,nums,winner);
    if (outcome)
      roundsWon++;
    else
      roundsLost++;
    previouseNums = nums;
    lastWinner = winner;


  }

  public int getNumber()
  {
    int num = strategy.getNumbner();
    if (num<0 || num>100)
      throw new RuntimeException(strategy.getClass().getName() +
              " returned invalid number: "+ num);
    return num;
  }
  

  public int getRoundsWon()
  {
    return roundsWon;
  }

}