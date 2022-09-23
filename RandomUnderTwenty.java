public class RandomUnderTwenty implements Strat
{

  @Override
  public void newRound(int numWinsNeeded) {

  }

  @Override
  public int getNumbner() {
    return (int)(Math.random()*21);
  }

  @Override
  public void roundEnded(boolean outcome, int[] opAnswers, int winner) {

  }
}