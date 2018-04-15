public enum Characteristic {

  NEUTRO,
  VELUDO,
  COURO,
  BASICS,
  FESTA,
  WORKWEAR,
  INVERNO,
  BOHO,
  ESTAMPAS,
  BALADA,
  COLORIDO,
  CASUAL,
  LISO,
  MODERNO,
  PASSEIO,
  METAL,
  VIAGEM,
  DELICADO,
  DESCOLADO,
  ELASTANO;

  static int indexOf(final String value) {

    final String compare = value.replace("\"", "").toUpperCase();
    int index = -1;
    for (final Characteristic characteristic : values()) {
      if (characteristic.name().equals(compare)) {
        index = characteristic.ordinal();
        break;
      }
    }

    return index;
  }
}