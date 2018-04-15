import java.nio.file.Paths;
import org.junit.Test;

public class BuscaProdutosSimilaresTest {

  @Test
  public void shouldFindSimilarProducts() {
    BuscaProdutosSimilares.main(new String[]{
        Paths.get("src", "test", "resources", "produtos-processados.txt").toString(),
        "8371"
    });
  }

  @Test
  public void shouldNotFindSimilarProducts() {
    BuscaProdutosSimilares.main(new String[]{
        Paths.get("src", "test", "resources", "produtos-processados.txt").toString(),
        "1111111111"
    });
  }
}