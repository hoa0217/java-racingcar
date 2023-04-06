package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositiveTest {

  @Test
  void create() {
    Positive positive = new Positive("3");
    assertThat(positive.getNumber()).isEqualTo(3);
  }

}
