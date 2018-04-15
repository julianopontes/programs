import verification.InputValue;
import verification.IsPerfectSquare;

/**
 * Perfect Square
 */
public class QuadradoPerfeito {

  private final static ReadFile readFile = new ReadFile();
  private final static IsPerfectSquare isPerfectSquare = new IsPerfectSquare();

  public static void main(final String[] args) {

    readFile.execute(args).ifPresent(
        strings -> {
          if (isPerfectSquare.execute(new InputValue(strings))) {
            System.out.println("\nO quadrado é perfeito");
            System.out.format("\nNúmero de operações necessário para deixar o quadrado perfeito: %d\n", strings.size() * 2 + 2);
          } else {
            System.err.println("\nO quadrado não é perfeito\n");
          }
        });
  }
}
