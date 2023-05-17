package 자료구조.DynamicArr;

/*  Dynamic Array
    - 자바의 ArrayList는 Dynamic Array의 역할을 함.
    - 조회 작업이 자주 일어날 때
    - 데이터의 갯수를 알고 있을 때
    - 데이터를 반복문을 통해 빠르게 순회할 때
    - 일반적으로는 list보다 메모리를 적게 사용

    장점 : - 데이터 접근, 할당이 O(1)으로 빠름
          - 맨 뒤의 데이터 추가/삭제 O(1)으로 빠름

    단점 : - 특정 위치의 데이터 추가/삭제 O(N)으로 느림
          - resizing 일어날 때, memory 사용량이 늘어나고 느림(값 복사 : O(N))
          - 메모리 낭비가 있음.


    시간복잡도 정리
    - add : O(1)    O(N) worst case
    - add(index) : O(N)
    - remove : O(1)
    - remove(index) : O(N)
    - get(index) : O(1)

*/

public class DynamicArr<T> {
    private int size = 0;
    private int capacity;
    private int growthFactor = 2; // array resize 방식 : doubling
    private Object[] array;

    // 동적 배열의 기본 크기를 설정하지 않고 선언
    public DynamicArr() {
        this.capacity = 10; // 기본 설정 크기 = 10;
        this.array = new Object[capacity];
    }

    // 동적 배열의 기본 크기를 설정하며 선언
    public DynamicArr(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    // array에 item을 추가하는 메서드
    // 시간복잡도 : O(1)     최악 : O(N)
    public void add(T item){
        // 만약 배열이 가득 차있다면, 동적으로 확장
        if(size == capacity){
            grow();
        }
        array[size] = item;
        size++;
    }

    // array의 마지막 item을 삭제하는 메서드
    // 시간복잡도 : O(1)
    public void remove(){
        array[size] = null;
        size--;
    }

    // array의 특정 인덱스의 item을 삭제하는 메서드
    // 시간복잡도 : O(N)
    public void remove(int index){
        // 삭제할 item의 index값이 잘못 됐다면, error throw
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        // 해당 index의 item을 삭제했으므로, 그 뒤의 item들을 한자리씩 앞으로 옮김
        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        array[size] = null; // item들을 한자리씩 당겨왔으므로, 마지막 자리는 null
    }

    // array의 size 리턴
    public int size(){
        return size;
    }

    // array의 capacity 리턴
    public int capacity(){
        return capacity;
    }

    // 해당 index의 item을 가져옴
    @SuppressWarnings("unchecked")
    public T get(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return (T) array[index];
    }

    // array를 자동적으로 확장하는 메서드
    public void grow(){
        capacity *= growthFactor; // array의 capacity를 double
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size); // 크기를 늘린 array에 기존의 item 복사
        array = newArray; // 크기 변경한 array로 대체
    }
}

