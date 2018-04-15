import static org.junit.Assert.assertEquals;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import javax.json.JsonObject;
import org.junit.Test;

public class ProcessJsonTest {

  private final ProcessJson processJson = new ProcessJson();

  @Test
  public void shouldAddTagsVector() throws IOException {

    final BufferedReader bufferedReader = new BufferedReader(
        new FileReader(Paths.get("src", "test", "resources", "produtos.txt").toString()));

    final JsonObject jsonObject = processJson.addTagsVector(bufferedReader);

    final Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonObject.toString());
    assertEquals(25, ((List) JsonPath.read(document, "$.products")).size());
    assertEquals(25, ((List) JsonPath.read(document, "$.products.[*].tagsVector")).size());
    assertEquals(20, ((List) JsonPath.read(document, "$.products.[0].tagsVector")).size());

    bufferedReader.close();

  }
}