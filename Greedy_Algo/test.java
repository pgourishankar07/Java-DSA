import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class test {
    static class Student implements Comparable<Student> {
        String name;
        int age;

        Student(String s, int a) {
            name = s;
            age = a;
        }

        public int compareTo(Student s) {
            return this.age - s.age;
        }

        public String toString() {
            return "Student{name='" + name + "', age=" + age + '}';
        }
    }

    public static void main(String args[]) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("Ram", 20));
        list.add(new Student("sam", 10));
        list.add(new Student("kam", 40));

        Collections.sort(list);
        list.forEach((i) -> {
            System.out.println(i);
        });
    }
}

/*
 *
 * Comparable -- compareTo(1) -- natural ordering -- implement in the same class
 * -- 1 way to sort
 * Comparator -- compare(2) -- custom ordering -- implement in another class --
 * many ways
 * 
 */