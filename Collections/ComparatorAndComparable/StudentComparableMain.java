package Collections.ComparatorAndComparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
За допомогою Comparable ми можемо сортувати нашу колекцію тільки на основі одного атрибута,
а за допомогою Comparator ми можемо забезпечити власне сортування на основі декількох атрибутів.

Висновок
І Comparable, і Comparator зазвичай використовуються в колекціях Java для реалізації функцій сортування.
Comparable необхідно реалізувати в класі, який вимагає сортування,
тоді як Comparator може бути реалізований в іншому класі або також може бути реалізований за допомогою лямбда-функції.
Якщо нам потрібне сортування за природним упорядкуванням на основі одного атрибута, то вам слід віддати перевагу Comparable,
а якщо потрібно кілька стратегій порівняння, замість цього рекомендується використовувати інтерфейс Comparator.
 */



/*
VarArgs (Variable Arguments) означає змінні аргументи. У Java ми можемо передавати змінну кількість аргументів одного типу в один і той самий метод.
Це спрощує створення методів, яким необхідно приймати змінну кількість аргументів.

До випуску JDK 5 ми не могли оголосити метод зі змінною кількістю аргументів.
Аргументи змінної довжини можна було обробляти або за допомогою перевантажених методів, або шляхом передачі масиву методу.
Вони обидва часто призводять до помилок, і погіршують читабельність коду. Щоб розв'язати цю проблему, в JDK 5 були введені змінні аргументи (Var Args).

Змінний аргумент - це функція Java, яка дозволяє нам передавати змінну кількість аргументів одному методу. Але є одне обмеження - вони мають бути одного типу.

VarArgs реалізується з використанням три крапки («...») в оголошенні методу.

 */


public class StudentComparableMain {
    public static void main(String[] args) {
        Students student = new Students(1, "David BeckhamA", "PHP");
        Students student1 = new Students(2, "Alan Smith", "Java");
        Students student2 = new Students(3, "Cristiano Ronaldo", "Python");
        List<Students> students = Arrays.asList(student, student1, student2);
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
        //thenComparing() – додає додаткове порівняння: якщо кафедри однакові, вібувається сортування за іменем.
        students.sort(new StudentDeptComparator().thenComparing(new StudentNameComparator()));
        System.out.println(students);
        students.sort((s1, s2) -> {
            return s1.getName().compareTo(s2.getName());
        });
        System.out.println(students);
    }
}

class StudentDeptComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.getDepartment().compareTo(o2.getDepartment());
    }
}

class StudentNameComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class Students implements Comparable<Students> {
    private Integer id;
    private String name;
    private String department;

    public Students(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public int compareTo(Students student) {
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +                ", department='" + department + '\'' +
                '}' + "\n";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
