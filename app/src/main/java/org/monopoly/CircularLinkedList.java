package org.monopoly;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.SplittableRandom;

public class CircularLinkedList<T> extends AbstractList<T> {

  private static int DEFAULT_SIZE = 10;
  private static SplittableRandom RAND = new SplittableRandom();

  public T currentNode;
  private T elements[];
  private int point = 0; // current selected node
  private int size = 0; // tail "pointer"

  @SuppressWarnings("unchecked")
  public CircularLinkedList() {
    elements = (T[]) new Object[DEFAULT_SIZE];
  }

  @SuppressWarnings("unchecked")
  public CircularLinkedList(int capacity) {
    elements = (T[]) new Object[capacity];
  }

  public int size() {
    return size;
  }

  public T get(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException(
        "Index: " + index + ", is out of bounds for Size: " + size
      );
    }

    while (index >= size) {
      index -= size;
    }

    return elements[index];
  }

  public void append(T element) {
    if (size >= elements.length) {
      resize();
    }
    elements[size] = element;
    size++;
    updateCurrentNode();
  }

  public void append(T element, int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException(
        "Index: " + index + ", is out of bounds for Size: " + size
      );
    }
    if (index >= size) {
      resize();
    }
    for (int i = size - 1; i >= index; i--) {
      elements[i + 1] = elements[i];
    }
    elements[index] = element;
    size++;
    if (currentNode == null) {
      updateCurrentNode();
    }
  }

  public T remove(int index) {
    while (index < 0) {
      index += size;
    }
    while (index >= size) {
      index -= size;
    }
    T value = elements[index];
    for (int i = index; i < size - 1; i++) {
      elements[i] = elements[i + 1];
    }
    size--;
    updateCurrentNode();
    return value;
  }

  public void step() {
    point++;
    if (point >= size) {
      point -= size;
    }
    updateCurrentNode();
  }

  public void roll() {
    int d6A = RAND.nextInt(1, 7);
    int d6B = RAND.nextInt(1, 7);
    int total = d6A + d6B;

    for (int x = 0; x < total; x++) {
      step();
    }
  }

  private void checkPoint() {
    if ((point >= size) & (size != 0)) {
      point = size - 1;
    } else if (point < 0) {
      point = 0;
    }
  }

  private void updateCurrentNode() {
    checkPoint();
    currentNode = elements[point];
  }

  private void resize() {
    int newsize = elements.length * 2;
    elements = Arrays.copyOf(elements, newsize);
  }
}
