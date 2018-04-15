import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import org.junit.Test;

public class CreateTagsVectorTest {

  private CreateTagsVector createTagsVector = new CreateTagsVector();

  @Test
  public void shouldCreateTagsVectorWithOneCharacteristic() {

    final Characteristic[] characteristics = new Characteristic[]{Characteristic.NEUTRO};
    final JsonArray jsonArray = getJsonArray(characteristics);

    final int[] assertResult = getAssertResult(characteristics);

    assertEquals(1, jsonArray.size());
    assertArrayEquals(assertResult, createTagsVector.execute(jsonArray));
  }

  @Test
  public void shouldCreateTagsVectorWithTwoCharacteristics() {

    final Characteristic[] characteristics = new Characteristic[]{Characteristic.NEUTRO, Characteristic.COURO};
    final JsonArray jsonArray = getJsonArray(characteristics, "modinha");

    final int[] assertResult = getAssertResult(characteristics);

    assertEquals(3, jsonArray.size());
    assertArrayEquals(assertResult, createTagsVector.execute(jsonArray));
  }

  private int[] getAssertResult(final Characteristic[] characteristics) {
    final int[] assertResult = new int[20];
    for (final Characteristic characteristic : characteristics) {
      assertResult[characteristic.ordinal()] = 1;
    }
    return assertResult;
  }

  private JsonArray getJsonArray(final Characteristic[] characteristics, final String... otherValues) {
    final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    for (final Characteristic characteristic : characteristics) {
      arrayBuilder.add(getTag(characteristic));
    }

    for (final String otherValue : otherValues) {
      arrayBuilder.add(otherValue);
    }

    return arrayBuilder.build();
  }

  private String getTag(final Characteristic characteristic) {
    return characteristic.name().toLowerCase();
  }
}