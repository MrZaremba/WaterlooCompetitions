import java.util.LinkedList;

public class Tests {
    public static void main(String[] args) {
        LinkedList<Integer> ints = new LinkedList<>();
        for(int i = 0; i< 10;i++){
            ints.add(i);
        }
        int size = ints.size();
        for(int i = 0;i < size;i++){
            System.out.println(ints.pollLast());
        }
    }
}
