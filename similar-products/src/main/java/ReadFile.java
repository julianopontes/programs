import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import model.JsonProducts;

class ReadFile {

  private static final int PARAMS_LENGTH = 2;

  private final ObjectMapper objectMapper = new ObjectMapper();

  Optional<JsonProducts> execute(final String[] args) {

    JsonProducts jsonProducts = null;
    if (PARAMS_LENGTH == args.length) {
      try {
        jsonProducts = objectMapper.readValue(new File(args[0]), JsonProducts.class);
      } catch (final IOException e) {
        logError(e.getMessage());
      }
    } else {
      logError("Parâmetros de entrada inválidos");
    }

    return Optional.ofNullable(jsonProducts);
  }

  private void logError(final String message) {
    System.err.println(message);
  }
}