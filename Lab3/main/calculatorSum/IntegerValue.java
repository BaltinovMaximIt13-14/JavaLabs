package ru.baltinov.main.calculatorSum;

public class IntegerValue implements NumericValue {
  private int value;

  public IntegerValue(int value) {
    this.value = value;
  }

  @Override
  public double toDouble() {
    return (double) value;
  }
}