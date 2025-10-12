package ru.baltinov.main.calculatorSum;

public class SumCalculator {
  // Метод для сложения набора числовых значений
  public static double sum(NumericValue... values) {
    double result = 0.0;
    for (NumericValue value : values) {
      result += value.toDouble();
    }
    return result;
  }
}
