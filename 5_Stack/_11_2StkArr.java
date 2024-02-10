
class twoStack {
    int[] arr;
    int size;
    int top1, top2;

    twoStack(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = (n / 2) - 1;
    }

    boolean isEmpty1() {
        return top1 == -1;
    }

    boolean isEmpty2() {
        return top2 == size / 2 - 1;
    }

    void push1(int val) {

        if (top1 == size / 2 - 1) {
            System.out.println("Stack OverFlow");
            return;
        }
        top1++;
        arr[top1] = val;
    }

    void push2(int val) {

        if (top2 == size - 1) {
            System.out.println("Stack OverFlow");
            return;
        }
        top2++;
        arr[top2] = val;
    }

    int pop1() {
        if (isEmpty1()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = arr[top1];
        top1--;
        return val;
    }

    int pop2() {
        if (isEmpty2()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = arr[top2];
        top2--;
        return val;
    }

    int peek1() {
        return arr[top1];
    }

    int peek2() {
        return arr[top2];
    }
}

public class _11_2StkArr {
    public static void main(String args[]) {
        twoStack s = new twoStack(10);

        s.push1(5);
        s.push1(10);
        s.push1(15);
        s.push1(20);
        s.push1(25);

        s.push2(10);
        s.push2(20);
        s.push2(30);
        s.push2(40);
        s.push2(50);

        while (!s.isEmpty1()) {
            System.out.println(s.pop1());
        }

        while (!s.isEmpty2()) {
            System.out.println(s.pop2());
        }

    }
}
