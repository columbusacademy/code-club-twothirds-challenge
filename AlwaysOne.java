public class AlwaysOne implements Strat
{

  @Override
  public void newRound(int numWinsNeeded) {

  }

  @Override
  public int getNumbner() {
    return 1;
  }

  @Override
  public void roundEnded(boolean outcome, int[] opAnswers, int winner) {

  }
}