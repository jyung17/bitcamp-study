package com.eomcs.oop.ex05.test.x1;

public class CalculatorTest {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    Calculator2 upgradeCalculator = new Calculator2(calculator);

    upgradeCalculator.plus(100);
    upgradeCalculator.minus(200);
    upgradeCalculator.multiple(2);

    System.out.println(upgradeCalculator.getResult());
  }
}
