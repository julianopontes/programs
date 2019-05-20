package model;

public class ProductSimilarity implements Comparable<ProductSimilarity> {

  private double similarity;
  private Product product;

  public ProductSimilarity(final double similarity, final Product product) {
    this.similarity = similarity;
    this.product = product;
  }

  public double getSimilarity() {
    return similarity;
  }

  public Product getProduct() {
    return product;
  }

  @Override
  public int compareTo(final ProductSimilarity o) {
    return Double.compare(similarity, o.similarity) * -1;
  }
}