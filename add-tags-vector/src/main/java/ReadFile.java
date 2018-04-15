import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

class ReadFile {

  private static final int PARAMS_LENGTH = 1;

  Optional<BufferedReader> execute(final String[] args) {

    BufferedReader bufferedReader = null;
    if (PARAMS_LENGTH == args.length) {
      try {
        bufferedReader = new BufferedReader(new FileReader(args[0]));
      } catch (final java.io.IOException e) {
        logError(format("Erro ao ler arquivo: %s \n", e.getMessage()));
      }
    } else {
      logError("Parâmetro de entrada inválido");
    }

    return Optional.ofNullable(bufferedReader);
  }

  private void logError(final String message) {
    System.err.println(message);
  }
}