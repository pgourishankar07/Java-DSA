import java.util.Stack;

public class _11_StockSpan {
    Stack<Integer> s = new Stack<>();

    public void StockSpanner() {
    }

    public int next(int price) {

        s.push(price);
        int count = 0;

        // Creating a copy of the stack
        Stack<Integer> temp = new Stack<>();
        for (Integer i : s) {
            temp.push(i);
        }

        while (!temp.isEmpty()) {
            if (temp.pop() <= price) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
