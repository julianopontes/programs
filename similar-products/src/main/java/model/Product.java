package model;

import java.util.Arrays;

public class Product {

  private Long id;
  private String name;
  private String[] tags;
  private int[] tagsVector;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  public int[] getTagsVector() {
    return tagsVector;
  }

  public void setTagsVector(int[] tagsVector) {
    this.tagsVector = tagsVector;
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + id + "}";
  }
}