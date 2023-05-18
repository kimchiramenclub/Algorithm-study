package 자료구조.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyLinkedListTest {
    static MyLinkedList<Integer> linkedList;

    @BeforeEach
    public void setup() {
        linkedList = new MyLinkedList<>();

    }

    @Test    // List가 처음에 비어있는지 확인
    public void testListNull(){
        assertEquals(0, linkedList.size());
    }

    @Test   // List의 마지막 index에 item이 추가되는 지 확인
    public void testAddToEndOfList() {
        linkedList.add(1);
        linkedList.add(2);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test   // 해당 index에 item이 추가되는 지 확인
    public void testAddAtIndex() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1, 3);

        assertEquals(1, linkedList.get(0));
        assertEquals(3, linkedList.get(1));
        assertEquals(2, linkedList.get(2));
        assertEquals(3, linkedList.size());
    }

    @Test   // list의 head item이 제거되는 지 확인
    public void testRemoveFromHead() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.remove();

        assertEquals(2, linkedList.get(0));
        assertEquals(1, linkedList.size());
    }

    @Test   // 해당 index의 item이 제거되는 지 확인
    public void testRemoveAtIndex() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(1);

        assertEquals(1, linkedList.get(0));
        assertEquals(3, linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test   // 해당 index의 item을 제대로 불러오는 지 체크
    public void testGet() {
        linkedList.add(1);

        assertEquals(1, linkedList.get(0));
    }

    @Test   // 각 메서드마다 invalid한 index에 대해 에러가 throw 되는 지 체크
    public void testIndexOutOfBounds() {
        linkedList.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(3, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(2));
    }

    @Test   // list가 비어있을 때 제거하면 에러가 throw 되는 지 체크
    public void testListEmptyException() {
        assertThrows(NoSuchElementException.class, linkedList::remove);
    }
}
