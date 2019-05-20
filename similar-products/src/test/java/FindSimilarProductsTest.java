import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import model.JsonProducts;
import model.ProductSimilarity;
import model.SimilarResult;
import org.junit.Test;

public class FindSimilarProductsTest {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void shouldFindSimilarities() throws IOException {

    final JsonProducts jsonProducts = objectMapper.readValue(
        new File(Paths.get("src", "test", "resources", "produtos-processados.txt").toString()),
        JsonProducts.class);

    final Optional<SimilarResult> similarResult = new FindSimilarProducts(jsonProducts).find(8104L);
    assertTrue(similarResult.isPresent());
    final List<ProductSimilarity> similarities = similarResult.get().getSimilarities();
    assertEquals(8314L, (long) similarities.get(0).getProduct().getId());
    assertEquals(7516L, (long) similarities.get(1).getProduct().getId());
    assertEquals(8301L, (long) similarities.get(2).getProduct().getId());
  }

  @Test
  public void shouldNotFindSimilarities() throws IOException {

    final JsonProducts jsonProducts = objectMapper.readValue(
        new File(Paths.get("src", "test", "resources", "produtos-processados.txt").toString()),
        JsonProducts.class);

    final Optional<SimilarResult> similarResult = new FindSimilarProducts(jsonProducts).find(22222222L);
    assertFalse(similarResult.isPresent());
  }
}