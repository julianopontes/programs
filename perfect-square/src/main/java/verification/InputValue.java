package verification;

import java.util.List;
import java.util.stream.Collectors;

public class InputValue {

  private static final String SPACE = "\\s+";
  private final List<String[]> listArray;

  public InputValue(final List<String> list) {

    listArray = list.stream()
        .filter(s -> s.length() > 0)
        .map(string -> string.split(SPACE))
        .collect(Collectors.toList());
  }

  List<String[]> getListArray() {
    return listArray;
  }
}