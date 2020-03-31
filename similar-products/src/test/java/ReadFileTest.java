import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.Optional;
import model.JsonProducts;
import org.junit.Test;

public class ReadFileTest {

  private final ReadFile readFile = new ReadFile();

  @Test
  public void shouldReadFileAndParseProducts() {

    final Optional<JsonProducts> jsonProducts = readFile.execute(
        new String[]{Paths.get("src", "test", "resources", "produtos-processados.json").toString(), "8137"});

    assertTrue(jsonProducts.isPresent());
  }

  @Test
  public void shouldNotBePresentBecauseFileNotFound() {

    final Optional<JsonProducts> jsonProducts = readFile.execute(
        new String[]{Paths.get("src", "test", "resources", "AAAA.txt").toString(), "8137"});

    assertFalse(jsonProducts.isPresent());
  }

  @Test
  public void shouldNotBePresentBecauseIncorrectParams() {

    final Optional<JsonProducts> jsonProducts = readFile.execute(
        new String[]{Paths.get("src", "test", "resources", "AAAA.txt").toString()});

    assertFalse(jsonProducts.isPresent());
  }
}