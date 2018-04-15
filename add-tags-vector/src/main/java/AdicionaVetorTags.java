import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.json.JsonObject;

/**
 * Add tags vector
 */
public class AdicionaVetorTags {

  static final String PRODUTOS_PROCESSADOS = "produtos-processados.txt";

  public static void main(final String[] args) {

    new ReadFile().execute(args).ifPresent(bufferedReader -> {

      final JsonObject jsonObject = new ProcessJson().addTagsVector(bufferedReader);

      try {
        bufferedReader.close();
      } catch (final IOException e) {
        System.err.println(e.getMessage());
      }

      try {
        Files.write(Paths.get("", PRODUTOS_PROCESSADOS), jsonObject.toString().getBytes());
      } catch (final IOException e) {
        System.err.println(e.getMessage());
      }
    });
  }
}