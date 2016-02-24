import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ListBoundedIntSetTestSuiteRunner {

  public static void main (final String[] args) {
    final Result result =
      JUnitCore.runClasses(ListBoundedIntSetTestSuite.class);
    for (final Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    if (result.wasSuccessful()) {
      System.out.println("Congratulations: all tests passed!");
    }
    final int runs      = result.getRunCount();
    final int failures  = result.getFailureCount();
    final int ignores   = result.getIgnoreCount();
    final int successes = runs - failures;
    System.out.printf("Tests run:     %d%n", runs);
    if (ignores > 0) {
      System.out.printf("Tests ignored: %d%n", ignores);
    }
    System.out.printf("Tests passed:  %d%n", successes);
    if (failures > 0) {
      System.out.printf("Tests failed:  %d%n", failures);
    }
  }
}
