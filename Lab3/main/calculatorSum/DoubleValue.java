package ru.baltinov.main.calculatorSum;

public class DoubleValue implements NumericValue {
  private double value;

  public DoubleValue(double value) {
    this.value = value;
  }

  @Override
  public double toDouble() {
    return value;
  }
}