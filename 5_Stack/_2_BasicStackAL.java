import java.util.ArrayList;

public class _2_BasicStackAL {

    static class stack {

        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;

        }

        public void push(int val) {
            list.add(val);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;

        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }

            int top = list.get(list.size() - 1);
            return top;
        }
    }

    public static void main(String args[]) {
        stack s = new stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println();

        while (!s.isEmpty()) {
            System.out.println("|   |");
            System.out.println("| " + s.pop() + " |");
            System.out.println("|___|");
        }
        System.out.println();

    }

}
