public class RunnerDemo {
  public static void main(String[] args) {
      Runner[] runners = {new Machine(), new Athlete(), new PoliticalCandidate()};

      for (Runner runner : runners) {
          runner.run();
      }
  }
}