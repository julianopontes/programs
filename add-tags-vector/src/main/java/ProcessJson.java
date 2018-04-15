import java.io.BufferedReader;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;

class ProcessJson {

  final private CreateTagsVector createTagsVector = new CreateTagsVector();

  JsonObject addTagsVector(final BufferedReader bufferedReader) {

    final JsonReader reader = Json.createReader(bufferedReader);

    final JsonArrayBuilder productsBuilder = Json.createArrayBuilder();

    final JsonArray products = reader.readObject().getJsonArray(ProductFields.PRODUCTS);
    for (final JsonValue product : products) {
      final JsonArray tags = product.asJsonObject().getJsonArray(ProductFields.TAGS);

      productsBuilder.add(createProductBuilder(product, createTagsVector.execute(tags)));
    }

    return Json.createObjectBuilder()
        .add(ProductFields.PRODUCTS, productsBuilder)
        .build();
  }

  private JsonObjectBuilder createProductBuilder(final JsonValue source, final int[] tagsVector) {
    final JsonObjectBuilder productBuilder = Json.createObjectBuilder();
    for (final Entry<String, JsonValue> entry : source.asJsonObject().entrySet()) {
      productBuilder.add(entry.getKey(), entry.getValue());
    }

    final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

    for (final int value : tagsVector) {
      arrayBuilder.add(value);
    }

    productBuilder.add(ProductFields.TAGS_VECTOR, arrayBuilder);

    return productBuilder;
  }
}
