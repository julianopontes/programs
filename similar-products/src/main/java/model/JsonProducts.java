package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;

public class JsonProducts {

  @JsonDeserialize(using = ProductsDeserializer.class)
  private Map<Long, Product> products;

  public Map<Long, Product> getProducts() {
    return products;
  }

  public void setProducts(final Map<Long, Product> products) {
    this.products = products;
  }
}