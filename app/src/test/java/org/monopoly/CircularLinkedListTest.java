package org.monopoly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularLinkedListTest {

  @Test
  void cllHasANullCurrentNodeAtStart() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    assertNull(cll.currentNode);
  }

  @Test
  void cllAppendWorks() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    cll.append(10);
    assertEquals(10, cll.currentNode);
  }

  @Test
  void cllGetWorks() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    cll.append(10);
    cll.append(6);
    assertEquals(6, cll.get(1));
  }

  @Test
  void cllRemoveWorks() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    cll.append(10);
    cll.append(6);
    assertEquals(10, cll.remove(0)); //returns the removed value
    assertEquals(6, cll.currentNode); //moves then updates nodes
  }

  @Test
  void cllStepWorks() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    cll.append(10);
    cll.append(76);
    cll.step();
    assertEquals(76, cll.currentNode); //moves to the next entry
    cll.step();
    assertEquals(10, cll.currentNode); // loops when reaching the end
  }

  @Test
  void cllRollWorks() {
    CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(5);
    cll.append(10);
    cll.append(76);
    cll.roll();
    assertNotNull(cll.currentNode);
  }
}
