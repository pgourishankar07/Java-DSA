import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PQ {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        public int compareTo(Student s) {
            return this.rank - s.rank;

        };

    }

    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Time complexity of add is o(logn)
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(5);
        pq.add(6);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove()); // remove : o(logn)
        }

        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        // Time complexity of add is o(logn)
        pq2.add(new Student("Arun", 5));
        pq2.add(new Student("Karan", 10));
        pq2.add(new Student("John", 1));
        pq2.add(new Student("Ram", 2));

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name + "--->" + pq2.peek().rank); // remove : o(logn)
            pq2.remove();
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

        TreeSet<Integer> set = new TreeSet<>(comp);

        set.add(2);
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(4);

        set.pollFirst();
        set.pollFirst();

        set.add(3);
        set.add(1);

        System.out.println("TreeSet : ");
        System.out.println(set);

    }
}
