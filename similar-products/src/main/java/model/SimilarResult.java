package model;

import java.util.List;

public class SimilarResult {

  private final Product searched;
  private final List<ProductSimilarity> similarities;

  public SimilarResult(final Product searched, final List<ProductSimilarity> similarities) {
    this.searched = searched;
    this.similarities = similarities;
  }

  public Product getSearched() {
    return searched;
  }

  public List<ProductSimilarity> getSimilarities() {
    return similarities;
  }
}