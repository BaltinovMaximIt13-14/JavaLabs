package ru.baltinov.main.calculatorSum;

public class FractionValue implements NumericValue{
  private int numerator;
  private int denominator;

  public FractionValue(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }
}
