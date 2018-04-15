import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadradoPerfeitoTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setup() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void tearDown() {
    System.setOut(System.out);
    System.setErr(System.err);
  }

  @Test
  public void shouldNotBePerfect() {
    QuadradoPerfeito.main(new String[]{Paths.get("src", "test", "resources", "quadrado.txt").toString()});

    assertEquals("O quadrado não é perfeito", errContent.toString().trim());
  }

  @Test
  public void shouldBePerfect() {
    QuadradoPerfeito.main(new String[]{Paths.get("src", "test", "resources", "perfect-square.txt").toString()});

    assertThat(outContent.toString(), containsString("O quadrado é perfeito"));
    assertThat(outContent.toString(), containsString("Número de operações necessário para deixar o quadrado perfeito: 36"));
  }
}