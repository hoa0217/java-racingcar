package study.racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import study.racingcar.domain.Car;

public class ResultView {

  private static final int START_RACE_NUM = 0;
  private static final int FIRST_INDEX = 0;
  private static final String DEFAULT_FOOTPRINT = "-";
  private static final String DEFAULT_DELIMETER = ",";
  private static final String NEXT_LINE = "\n";

  private ResultView() {
  }

  public static void printResult(int raceNum, List<Car> cars) {
    printRaceNum(raceNum);
    printCars(cars);
  }

  private static void printRaceNum(int raceNum) {
    if (isStartLine(raceNum)) {
      System.out.print(NEXT_LINE + "실행 결과");
    }
    System.out.println(NEXT_LINE + "RACE " + (raceNum + 1));
  }

  private static boolean isStartLine(int raceNum) {
    return raceNum == START_RACE_NUM;
  }

  private static void printCars(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + DEFAULT_FOOTPRINT.repeat(car.getDistance()));
    }
  }

  public static void printWinners(List<Car> cars) {
    printWinnerNames(getWinnerNames(sortCars(cars)));
  }

  private static List<Car> sortCars(List<Car> cars) {
    Collections.sort(cars, (car1, car2) -> {
      return car2.getDistance() - car1.getDistance();
    });
    return cars;
  }

  private static List<String> getWinnerNames(List<Car> cars) {
    int maxDistance = cars.get(FIRST_INDEX).getDistance();
    List<String> winnerNames = new ArrayList<>();
    for (Car car : cars) {
      if (!isWinner(maxDistance, car)) {
        break;
      }
      winnerNames.add(car.getName());
    }
    return winnerNames;
  }

  private static boolean isWinner(int maxDistance, Car car) {
    return car.getDistance() == maxDistance;
  }

  private static void printWinnerNames(List<String> winners) {
    System.out.println(NEXT_LINE + String.join(DEFAULT_DELIMETER, winners) + "가 최종 우승했습니다.");
  }
}
