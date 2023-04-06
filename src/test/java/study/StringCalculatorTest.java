package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void 음수() {
    assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,1,2"))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void 콜론구분자() {
    assertThat(StringCalculator.splitAndSum("1;2")).isEqualTo(3);
  }

  @Test
  void 콤마구분자() {
    assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
  }

  @Test
  void 숫자_하나() {
    assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
  }

  @Test
  void 빈값() {
    assertThat(StringCalculator.splitAndSum("")).isEqualTo(0);
    assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
  }

}
