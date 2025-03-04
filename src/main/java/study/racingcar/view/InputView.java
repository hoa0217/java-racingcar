package study.racingcar.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String QUESTION_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String QUESTION_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";
  private static final String DEFAULT_DELIMITER = ",";

  private InputView() {
  }

  public static String[] inputNameOfCars() {
    printQuestion(QUESTION_NAME_OF_CARS);
    return inputNames();
  }

  private static void printQuestion(String question) {
    System.out.println(question);
  }

  private static String[] inputNames() {
    return SCANNER.nextLine().split(DEFAULT_DELIMITER);
  }

  public static int inputNumberOfRaces() {
    printQuestion(QUESTION_NUMBER_OF_ROUNDS);
    return intputNumber();
  }

  private static int intputNumber() {
    int number = SCANNER.nextInt();

    validatePositiveNumber(number);
    return number;
  }

  private static void validatePositiveNumber(int number) {
    if (number <= 0) {
      throw new NumberFormatException("양의 정수가 아닌 값을 입력했습니다.: " + number);
    }
  }
}
