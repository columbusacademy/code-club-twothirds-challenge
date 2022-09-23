public class ImitateWinner implements Strat
{
  private int round=0;
  private int[] nums;
  private int winner;

  @Override
  public void newRound(int numWinsNeeded) {
  }

  @Override
  public int getNumbner() {
    if(round==0)
      return 99;
    return nums[winner];
  }

  @Override
  public void roundEnded(boolean outcome, int[] othersAnswers, int winner) {
    nums = othersAnswers;
    this.winner = winner;
    round+=1;
  }
}