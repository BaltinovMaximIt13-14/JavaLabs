package ru.baltinov.fraction;

public class Fraction implements FractionOperations {
  private int numerator;
  private int denominator;
  private final Cache<Double> decimalCache;

  // Конструктор
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }

    // Обработка отрицательных значений
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.decimalCache = new Cache<>(this::calculateDecimalValue);
  }

  // Геттеры
  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }


  // Строковое представление
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  // Сравнение объектов
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Fraction fraction = (Fraction) obj;
    return numerator == fraction.numerator &&
        denominator == fraction.denominator;
  }

  // Хэш-код
  @Override
  public int hashCode() {
    return 31 * numerator + denominator;
  }

  // Кэширование значения
  @Override
  public double getDecimalValue() {
    return decimalCache.getValue();
  }

  @Override
  public void setNumeratorAndDenominator(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }

    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    boolean valuesChanged = (this.numerator != numerator) || (this.denominator != denominator);

    this.numerator = numerator;
    this.denominator = denominator;
    if (valuesChanged) {
      decimalCache.invalidate();
    }
  }

  private double calculateDecimalValue() {
    return (double) numerator / denominator;
  }
}