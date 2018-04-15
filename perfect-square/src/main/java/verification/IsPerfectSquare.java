package verification;

import static java.util.Arrays.stream;

import java.util.List;

public class IsPerfectSquare {

  private static final int DISTINCT = 1;

  public boolean execute(final InputValue inputValue) {

    final List<String[]> listArray = inputValue.getListArray();
    final int size = listArray.size();
    final int[] lineResult = new int[size];
    final int[] columnResult = new int[size];
    int leftDiagonalResult = 0;
    int rightDiagonalResult = 0;

    for (int line = 0; line < size; line++) {
      for (int column = 0; column < size; column++) {

        final int item = Integer.parseInt(listArray.get(line)[column]);

        lineResult[line] += item;
        columnResult[column] += item;

        if (line == column) {
          leftDiagonalResult += item;
        }

        if ((line + column) == (size - 1)) {
          rightDiagonalResult += item;
        }
      }
    }

    boolean success = (DISTINCT == stream(lineResult).distinct().count()) && (DISTINCT == stream(columnResult).distinct().count());

    if (success) {
      final int valueReference = lineResult[0];
      success = (valueReference == columnResult[0]) && (valueReference == leftDiagonalResult) && (valueReference == rightDiagonalResult);
    }

    return success;
  }
}
