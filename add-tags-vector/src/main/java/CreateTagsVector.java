import javax.json.JsonArray;
import javax.json.JsonValue;

class CreateTagsVector {

  private static final int VECTOR_SIZE = 20;

  int[] execute(final JsonArray tags) {
    final int[] tagsVector = new int[VECTOR_SIZE];

    for (final JsonValue tag : tags) {
      final int index = Characteristic.indexOf(tag.toString());
      if (index > -1) {
        tagsVector[index] = 1;
      }
    }
    return tagsVector;
  }
}
