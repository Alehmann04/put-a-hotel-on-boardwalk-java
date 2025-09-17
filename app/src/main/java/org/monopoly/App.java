package org.monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

  public void fileReadingTest() {
    try (
      BufferedReader br = new BufferedReader(
        new FileReader("monopoly_spaces.txt")
      )
    ) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Error reading file.");
    }
  }

  public void createWholeBoard() {
    CircularLinkedList<String> board = new CircularLinkedList<String>();
    try (
      BufferedReader b_reader = new BufferedReader(
        new FileReader("../monopoly_spaces.txt")
      )
    ) {
      String line;
      while ((line = b_reader.readLine()) != null) {
        board.append(line);
      }
    } catch (IOException e) {
      System.err.println("Error reading file.");
    }
    System.out.println("Current Node: " + board.currentNode);
    System.out.println("Circular Board: " + board);
  }

  public void mainDemo() {
    CircularLinkedList<Double> list = new CircularLinkedList<Double>();
    list.append(1.0);
    list.append(2.0);
    System.out.println("Current Node: " + list.currentNode);
    list.append(3.0);
    list.append(5.0);
    list.append(4.0, 3);
    list.step();
    list.step();
    list.step();
    list.step();
    list.step();
    list.step();
    System.out.println("Current Node: " + list.currentNode);
    System.out.println("Circular List: " + list);
    System.out.println("index 00:" + list.get(0));
    System.out.println("index 01:" + list.get(1));
    System.out.println("index 02:" + list.get(2));
    System.out.println("index 03:" + list.get(3));
    System.out.println("index 04:" + list.get(4));
    System.out.println("index 05:" + list.get(5));
    System.out.println("index 06:" + list.get(6));
    System.out.println("index 07:" + list.get(7));
    System.out.println("index 08:" + list.get(8));
    System.out.println("index 09:" + list.get(9));
  }

  public static void main(String[] args) {
    new App().mainDemo();
    //new App().createWholeBoard();
  }
}
