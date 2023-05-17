package 자료구조.DynamicArr;

public class DynamicArrTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        DynamicArr<Integer> dynamicArray = new DynamicArr<>(2);
        sb.append("동적 배열 capacity 설정 : ").append(dynamicArray.capacity()).append("\n");
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        sb.append("\n동적 배열에 1,2,3 추가\n").append("\n");

        sb.append("동적 배열 capacity: ").append(dynamicArray.capacity()).append("\n");
        sb.append("동적 배열 size: ").append(dynamicArray.size()).append("\n");

        sb.append("동적 배열 : [");
        for(int i=0;i<dynamicArray.size();i++) sb.append(dynamicArray.get(i)).append(" ");
        sb.setLength(sb.length()-1);
        sb.append("]").append("\n");

        dynamicArray.remove(1);
        sb.append("\nIndex 1 제거\n\n");

        sb.append("변경된 동적 배열 size: ").append(dynamicArray.size()).append("\n");
        sb.append("변경된 동적 배열 : [");
        for(int i=0;i<dynamicArray.size();i++) sb.append(dynamicArray.get(i)).append(" ");
        sb.setLength(sb.length()-1);
        sb.append("]").append("\n");

        System.out.println(sb);
    }
}
