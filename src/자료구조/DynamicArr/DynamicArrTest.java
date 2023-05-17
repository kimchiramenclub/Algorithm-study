package 자료구조.DynamicArr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrTest {

    @Test
    public void testDynamicArrayMethods() {
        DynamicArr<Integer> dynamicArray = new DynamicArr<>(2);

        // 동적 배열 capacity 설정 체크
        assertEquals(2,dynamicArray.capacity());

        // 동적 배열에 item 추가
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        // 동적 배열 capacity resizing(doubling) 체크
        assertEquals(4, dynamicArray.capacity());
        assertEquals(3, dynamicArray.size());
        assertEquals(Integer.valueOf(1), dynamicArray.get(0));
        assertEquals(Integer.valueOf(2), dynamicArray.get(1));
        assertEquals(Integer.valueOf(3), dynamicArray.get(2));

        // index 1의 값 제거후 동적 배열 size 체크
        dynamicArray.remove(1);
        assertEquals(2, dynamicArray.size());
        assertEquals(Integer.valueOf(1), dynamicArray.get(0));
        assertEquals(Integer.valueOf(3), dynamicArray.get(1));
    }
}
