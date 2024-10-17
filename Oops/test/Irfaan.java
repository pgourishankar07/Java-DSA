class Student {
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

class CSE extends Student {
    int cgpa;

    CSE(int rrn, String name, int marks, int cgpa) {
        super(rrn, name, marks);
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student [rrn=" + rrn + ", name=" + name + ", marks=" + marks + ", cgpa=" + cgpa + "]";
    }

    public void print() {
        System.out.println("hello");
    }

}

public class Irfaan {

    public static void main(String[] args) {
        // System.out.println("Hello Irfaan");

        Student s1 = new Student(27, "Irfaan", 92);
        Student s2 = new CSE(22, "Gouri", 93, 9); // parent reference is refererring to CSE (its child)

        System.out.println(s1);
        // System.out.println(s2.cgpa); // u cant access the cgpa or any properties or
        // methods from child class because u have used
        // Student (parent class to create
        // object of CSE type)
        System.out.println(s2); // but see it can access method toString() from CSE ... this is due to method
                                // overriding and polymorphism in Java.

        /*
         * For overriding Parent class u need to have
         * that method() specified so that while creating object using Object Type it
         * will override
         */
    }
}
