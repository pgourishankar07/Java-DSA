import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparatorr {
    // Comparator
    // -- we are declarying this Student as static class because we are
    // declarying this calss inside our Class so if u want to access this class
    // inside main() then u need to specify this as static but if u declare this
    // clas outdie then no need to specify as static but this is not the case in
    // Leetcode platforms because we are not writting code inside main()
    static class Student {
        int rrn;
        String name;
        int marks;

        Student(int rrn, String name, int marks) {
            this.rrn = rrn;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student [rrn=" + rrn + ", name=" + name + ", marks=" + marks + "]";
        }

    }

    static class SortByRrn implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.rrn - b.rrn;
        }
    }

    // Cmparable
    static class Teachers implements Comparable<Teachers> {

        String name;
        int age;

        public Teachers(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Teachers s) {
            return this.age - s.age;
        }

        @Override
        public String toString() {
            return "Teachers [name=" + name + ", age=" + age + "]";
        }

    }

    public static void main(String[] args) {

        Comparator<Student> SortByMark = new Comparator<>() {
            public int compare(Student a, Student b) {
                return a.marks - b.marks;
            };
        };

        List<Student> list = new ArrayList<>();

        list.add(new Student(22, "Gouri", 467));
        list.add(new Student(19, "Cris", 320));
        list.add(new Student(2, "Tano", 487));

        System.out.println("Sort by Marks");
        Collections.sort(list, SortByMark);
        System.out.println(list);

        System.out.println("Sort by RRN");
        Collections.sort(list, new SortByRrn());
        System.out.println(list);

        // Comparable_______________________________________________________________________________________

        List<Teachers> list2 = new ArrayList<>();

        list2.add(new Teachers("Ram", 40));
        list2.add(new Teachers("sam", 20));
        list2.add(new Teachers("kam", 27));

        Collections.sort(list2); // without implementing the Comparable interface u cant able to sort it

        System.out.println(list2);
    }

}
/*
 * // The difference between comparator and comparable is
 * 
 * Comparator (u can compare anything) -- any custom order u can create a
 * various lot of options u can
 * bring like above code (sort by name ,sort by rrn) -- compare(a,b) takes two
 * parameter -- you have to create a new class implement Comparator or create
 * anonymous object and write logic
 * 
 * Comparable (make that object as comparable) -- only natural order sorting
 * there is no multiple choice of
 * sorting on various constraints/data types -- compareTo(a) takes only 1
 * parameter -- you have to implement to current class and override the function
 * so that when u call sort it will sort according to the condition
 * 
 */
