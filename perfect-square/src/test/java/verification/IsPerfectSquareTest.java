package verification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class IsPerfectSquareTest {

  private final IsPerfectSquare isPerfectSquare = new IsPerfectSquare();

  @Test
  public void shouldBePerfectBecauseAllElementAreEquals() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");

    assertTrue(isPerfectSquare.execute(new InputValue(stringList)));
  }

  @Test
  public void shouldBePerfectBecauseSumAreEquals() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("15 8 1 24 17");
    stringList.add("16 14 7 5 23");
    stringList.add("22 20 13 6 4");
    stringList.add("3 21 19 12 10");
    stringList.add("9 2 25 18 11");

    assertTrue(isPerfectSquare.execute(new InputValue(stringList)));
  }

  @Test
  public void shouldNotBePerfectBecauseLineDifference() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1 1 1 1 2");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");
    stringList.add("1 1 1 1 1");

    assertFalse(isPerfectSquare.execute(new InputValue(stringList)));
  }

  @Test
  public void shouldNotBePerfectBecauseColumnDifference() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1 2 3 4 5");
    stringList.add("1 2 3 4 5");
    stringList.add("1 2 3 4 5");
    stringList.add("1 2 3 4 5");
    stringList.add("1 2 3 4 5");

    assertFalse(isPerfectSquare.execute(new InputValue(stringList)));
  }

  @Test
  public void shouldNotBePerfectBecauseLeftDiagonalDifference() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("2 1 1 1 1");
    stringList.add("1 2 1 1 1");
    stringList.add("1 1 2 1 1");
    stringList.add("1 1 1 2 1");
    stringList.add("1 1 1 1 2");

    assertFalse(isPerfectSquare.execute(new InputValue(stringList)));
  }

  @Test
  public void shouldNotBePerfectBecauseRightDiagonalDifference() {
    final ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1 1 1 1 2");
    stringList.add("1 1 1 2 1");
    stringList.add("1 1 2 1 1");
    stringList.add("1 2 1 1 1");
    stringList.add("2 1 1 1 1");

    assertFalse(isPerfectSquare.execute(new InputValue(stringList)));
  }
}