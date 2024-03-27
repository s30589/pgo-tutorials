public class Person {
    public String firstName;
    public String lastName;
    public String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

public class Student extends Person {
    public int studentId;
    public StudentGroup group;

    // Konstruktor
    public Student(String firstName, String lastName, String email, int studentId, StudentGroup group) {
        super(firstName, lastName, email);
        this.studentId = studentId;
        this.group = group;
    }
}

import java.util.ArrayList;
        import java.util.List;

public class StudentGroup {
    public String groupName;
    public List<Student> students;

    // Konstruktor
    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    // Metoda do dodawania studentów do grupy
    public void addStudent(Student student) {
        students.add(student);
    }
}

public class Teacher extends Person {
    public int teacherId;
    public List<StudentGroup> groupsTeaching;

    // Konstruktor
    public Teacher(String firstName, String lastName, String email, int teacherId) {
        super(firstName, lastName, email);
        this.teacherId = teacherId;
        this.groupsTeaching = new ArrayList<>();
    }

    // Metoda do dodawania grupy do listy grup uczonych przez nauczyciela
    public void addGroupTeaching(StudentGroup group) {
        groupsTeaching.add(group);
    }
}
import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    public String groupName;
    public List<Student> students;

    // Maksymalna liczba osób w grupie
    private static final int MAX_GROUP_SIZE = 15;

    // Konstruktor
    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    // Metoda do dodawania studentów do grupy
    public void addStudent(Student student) {
        if (students.size() >= MAX_GROUP_SIZE) {
            throw new IllegalStateException("Grupa jest pełna, nie można dodać więcej studentów.");
        }
        if (students.contains(student)) {
            throw new IllegalStateException("Ten student już należy do grupy.");
        }
        students.add(student);
    }
}

public class Student extends Person {
    public int studentId;
    public StudentGroup group;
    public List<Double> grades;

    // Maksymalna liczba ocen dla studenta
    private static final int MAX_GRADES = 20;

    // Konstruktor
    public Student(String firstName, String lastName, String email, int studentId, StudentGroup group) {
        super(firstName, lastName, email);
        this.studentId = studentId;
        this.group = group;
        this.grades = new ArrayList<>();
    }

    // Metoda dodająca ocenę
    public void addGrade(double grade) {
        if (grades.size() >= MAX_GRADES) {
            throw new IllegalStateException("Student osiągnął maksymalną liczbę ocen.");
        }
        grades.add(grade);
    }

    // Metoda obliczająca średnią ocen
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Student nie ma żadnej oceny.");
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        return roundToNearestGrade(average);
    }

    // Metoda zaokrąglająca średnią ocenę do najbliższej dopuszczalnej wartości
    private double roundToNearestGrade(double average) {
        double[] validGrades = {2, 2.5, 3, 3.5, 4, 4.5, 5};
        double closestGrade = validGrades[0];
        for (double grade : validGrades) {
            if (Math.abs(grade - average) < Math.abs(closestGrade - average)) {
                closestGrade = grade;
            }
        }
        return closestGrade;
    }
}