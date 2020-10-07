package GUI9NEW;


import java.util.Arrays;

public
class Main {

    public static void main(String[] args) {

// =============================================

        Student s0534 = new Student( 534, "tomaszew");
        Student s0583 = new Student( 583, "Ala");
        Student s1701 = new Student(1701, "Jan");

        Student[] tab = { s1701, s0534, s0583};

// =====================================
        System.out.println("===============");
        MyList<Student> list = new MyList<>();
        list.add(s0534);
        list.add(s0583);
        list.add(s1701);

        //list.show();

        System.out.println("_________________");
        for( Student s : list)
        System.out.println(s);

    }
}
