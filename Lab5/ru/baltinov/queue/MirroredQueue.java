package ru.baltinov.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MirroredQueue {

  private final Queue<Integer> queue;

  // Конструктор
  public MirroredQueue(List<Integer> list) {
    this.queue = new LinkedList<>();

    for (Integer item : list) {
      this.queue.offer(item);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      this.queue.offer(list.get(i));
    }
  }

  //Геттер
  public Queue<Integer> getQueue() {
    return new LinkedList<>(this.queue);
  }

  // Текстовое представление
  @Override
  public String toString() {
    return queue.toString();
  }
}