import java.nio.file.Paths;
import org.junit.Test;

public class AdicionaVetorTagsTest {


  @Test
  public void shouldAddTagsVector() {
    AdicionaVetorTags.main(new String[]{Paths.get("src", "test", "resources", "produtos.txt").toString()});
  }
}