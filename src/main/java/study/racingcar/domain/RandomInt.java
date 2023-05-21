package study.racingcar.domain;

public class RandomInt {

  private final int number;

  public RandomInt(final int number) {
    this.number = number;
  }

  public boolean isGreaterThan(int minimumMoveValue) {
    return this.number >= minimumMoveValue;
  }
}
