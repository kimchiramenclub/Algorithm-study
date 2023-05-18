package 자료구조.LinkedList;
import java.util.NoSuchElementException;


/*  LinkedList

    - Tree, graph를 구현할 때 자주 사용
    - 삽입/삭제가 자주 일어날 때
    - 얼만큼의 데이터가 들어올 지 예측이 안될 때
    - 조회 작업이 적을 때


    장점 : - 메모리 물리적 연속성 필요가 없어, 메모리 사용이 더 자유로움.
          - Runtime 중에도 size가 조절되므로 resizing이 필요없어, 메모리 낭비가 없음.

    단점 : - Next address를 저장해야 하므로 데이터 하나당 차지하는 메모리가 더 크다.


    시간복잡도 정리
    - add : O(1)            (실질적으로는 rear까지 조회해야 하므로 O(N))
    - add(index) : O(1)     (실질적으로는 index까지 조회해야 하므로 O(N))
    - remove : O(1)         (head만 제거하므로 기본 remove는 조회 필요 X)
    - remove(index) : O(1)  (실질적으로는 index까지 조회해야 하므로 O(N))
    - get(index) : O(N)
    - search : O(N)
*/

public class MyLinkedList<T> {
    // LinkedList의 기본 구조체가 되는 Node
    // 각각 데이터값, 다음 Node의 address를 저장함.
    // 물리적 메모리상 비연속적, 논리적 연속성
    static class Node<T> {
        private T data;        // Node에 닮길 data
        private Node<T> next;  // 다음 Node의 주소를 가리키는 변수

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;   // 가장 앞의 Node
    private int size;

    public void MyLinkedList() {    // LinkedList 선언
        this.head = null;
        this.size = 0;
    }

    // LinkedList의 end에 Data를 insert
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) head = newNode; // 비어있는 리스트라면, 삽입한 노드를 head로
        else {
            Node<T> currentNode = getNode(size-1);  // 현재 마지막 Node access
            currentNode.next = newNode; // 현재 마지막 node가 새로 insert된 node를 가리키게 함.
        }
        size++;
    }

    // LinkedList의 특정 index에 data를 insert
    public void add(int index, T data) {
        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;    // 맨 앞에 insert될 새 Node가 현재 head node를 가리키게 함(null이였다면, 그대로 null)
            head = newNode;         // 새 Node가 head가 됨
        } else {
            Node<T> previousNode = getNode(index-1); // previous(index-1) -- newNode -- indexNode
            newNode.next = previousNode.next;              // indexNode를 newNode가 가리키게 함.
            previousNode.next = newNode;                   // previous Node는 새로 insert된 newNode를 가리킴
        }
        size++;
    }

    // head Node 제거  (API에서도 기본 remove는 head 제거)
    public void remove() {
        // 빈 List라면, 에러 출력
        if (head == null) throw new NoSuchElementException("List is empty!");

        Node<T> removedNode = head;
        head = removedNode.next; // List의 head Node를 대체
        removedNode.next = null; // 기존 head Node의 연결을 잘라냄
        size--;
    }

    public void remove(int index){
        if(index == 0){
            Node<T> removedNode = head;
            head = removedNode.next; // List의 head Node를 대체
            removedNode.next = null; // 삭제될 Node의 연결을 잘라냄
        } else{
            Node<T> previousNode = getNode(index-1);    // 삭제될 대상 이전 Node를 access
            Node<T> removedNode = previousNode.next;
            previousNode.next = removedNode.next;       // 이전 Node가 삭제될 Node의 다음을 가리키게 함
            removedNode.next = null;                    // 삭제될 Node의 연결을 잘라냄
        }
        size--;
    }

    // add, remove 메서드에서 활용. index 값에 따른 에러 처리를 대신 해줌
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> indexNode = head;           // 조회 시작위치
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.next;     // next를 통해 Node를 넘어가며 해당 index의 Node 조회
        }
        return indexNode;
    }

    public T get(int index) {
        Node<T> indexNode = getNode(index); // getNode 메서드를 사용해 해당 index의 Node access
        return indexNode.data;              // 해당 index Node의 데이터 return
    }
}
