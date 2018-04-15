import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class ReadFileTest {

  private final ReadFile readFile = new ReadFile();

  @Test
  public void shouldReadFileAndParseLines() {

    final Optional<List<String>> stringList = readFile.execute(
        new String[]{Paths.get("src", "test", "resources", "quadrado.txt").toString()});

    assertTrue(stringList.isPresent());
    assertEquals(17, stringList.get().size());
  }

  @Test
  public void shouldExitBecauseFileNotFound() {

    final Optional<List<String>> stringList = readFile.execute(
        new String[]{Paths.get("src", "test", "resources", "AAAA.txt").toString()});

    assertFalse(stringList.isPresent());
  }
}