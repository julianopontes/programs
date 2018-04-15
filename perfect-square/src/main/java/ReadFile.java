import static java.lang.String.format;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

class ReadFile {

  private static final int PARAMS_LENGTH = 1;

  Optional<List<String>> execute(final String[] args) {

    List<String> stringList = null;
    if (PARAMS_LENGTH == args.length) {
      try {
        stringList = Files.readAllLines(new File(args[0]).toPath(), Charset.defaultCharset());
      } catch (final java.io.IOException e) {
        logError(format("Erro ao ler arquivo: %s \n", e.getMessage()));
      }
    } else {
      logError("Parâmetro de entrada inválido");
    }

    return Optional.ofNullable(stringList);
  }

  private void logError(final String message) {
    System.err.println(message);
  }
}
