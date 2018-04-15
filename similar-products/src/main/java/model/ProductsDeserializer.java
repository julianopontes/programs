package model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductsDeserializer extends JsonDeserializer<Map<Long, Product>> {

  private static final String ID = "id";

  @Override
  public Map<Long, Product> deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

    final ObjectCodec codec = p.getCodec();
    final TreeNode treeNode = codec.readTree(p);
    final Map<Long, Product> productMap = new HashMap<>();

    if (treeNode.isArray()) {
      for (final JsonNode jsonNode : (ArrayNode) treeNode) {
        final JsonNode id = jsonNode.get(ID);
        if (id != null) {
          productMap.put(id.asLong(), codec.treeToValue(jsonNode, Product.class));
        }
      }
    }

    return productMap;
  }
}
