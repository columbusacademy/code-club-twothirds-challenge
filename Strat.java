public interface Strat
{

  void newRound(int numWinsNeeded);

  int getNumbner();

  void roundEnded(boolean outcome, int[] opAnswers, int winner);


}