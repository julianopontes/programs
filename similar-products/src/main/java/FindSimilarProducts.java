import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.JsonProducts;
import model.Product;
import model.ProductSimilarity;
import model.SimilarResult;

class FindSimilarProducts {

  private final JsonProducts jsonProducts;

  FindSimilarProducts(final JsonProducts jsonProducts) {
    this.jsonProducts = jsonProducts;
  }

  Optional<SimilarResult> find(final Long productId) {

    final Map<Long, Product> products = jsonProducts.getProducts();
    SimilarResult similarResult = null;
    if (products.containsKey(productId)) {

      final Product search = products.remove(productId);
      final List<ProductSimilarity> productSimilarities = getProductSimilarities(products, search);

      similarResult = new SimilarResult(search, getMostSimilar(productSimilarities));

      System.out.println(similarResult);

    } else {
      System.err.println("Produto não encontrado!");
    }

    return Optional.ofNullable(similarResult);
  }

  private List<ProductSimilarity> getProductSimilarities(final Map<Long, Product> products, final Product search) {

    final List<ProductSimilarity> productSimilarities = new ArrayList<>();
    for (final Product product : products.values()) {
      productSimilarities.add(new ProductSimilarity(calculateSimilarity(search.getTagsVector(), product.getTagsVector()), product));
    }
    Collections.sort(productSimilarities);

    return productSimilarities;
  }

  private List<ProductSimilarity> getMostSimilar(final List<ProductSimilarity> productSimilarities) {

    final List<ProductSimilarity> mostSimilar = new ArrayList<>();
    for (int i = 1; i < 4; i++) {
      mostSimilar.add(productSimilarities.remove(0));
    }

    return mostSimilar;
  }

  private Double calculateSimilarity(final int[] search, final int[] product) {

    double result = 0;
    for (int i = 0; i < search.length; i++) {
      result += Math.pow(search[i] - product[i], 2);
    }

    return 1 / (1 + Math.sqrt(result));
  }
}