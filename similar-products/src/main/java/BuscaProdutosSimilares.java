import model.Product;
import model.ProductSimilarity;

public class BuscaProdutosSimilares {

  public static void main(final String[] args) {

    new ReadFile().execute(args).ifPresent(jsonProducts ->

        new FindSimilarProducts(jsonProducts).find(Long.valueOf(args[1])).ifPresent(similarResult -> {

          final Product searched = similarResult.getSearched();
          System.out.format("\nOs três produtos mais similares ao produto %d %s são:\n", searched.getId(), searched.getName());

          for (final ProductSimilarity productSimilarity : similarResult.getSimilarities()) {

            final Product product = productSimilarity.getProduct();
            System.out.format("\n- %d (%s) com S=%f\n", product.getId(), product.getName(), productSimilarity.getSimilarity());
          }
        })
    );
  }
}