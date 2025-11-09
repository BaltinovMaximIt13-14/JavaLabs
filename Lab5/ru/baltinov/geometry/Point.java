package ru.baltinov.geometry;

//Абстрактный класс точки для связи характеристик
public abstract class Point {
  @Override
  public abstract String toString();
  public abstract Point copy();
  @Override
  public abstract boolean equals(Object obj);
  @Override
  public abstract int hashCode();
}