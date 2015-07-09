package dsa.test;

import dsa.entity.Student;
import dsa.list.TheList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("(1) - add test");
        TheList h = new TheList();
        System.out.println();
        
        h.add(1, "Student1", new Date());
        h.add(2, "Student2", new Date());
        h.add(3, "Student3", new Date());
        h.displayAll();

        System.out.println("(2) - add many test");

        int[] id = {4, 5, 6, 7};
        String[] name = {"Student4", "Student5", "Student6", "Student7"};
        Date[] dob = {new Date(), new Date(), new Date(), new Date()};
        int n = 4;
        h.addMany(id, name, dob, n);
        h.displayAll();

        System.out.println("(3) - delete last test");
        h.deleLast();
        h.displayAll();

        System.out.println("(4) - delete first test");
        h.deleFirst();
        h.displayAll();

        System.out.println("(5) - search by name test");
        Student p = h.searchByName("Student3");

        if (p != null) {
            System.out.println(p.toString());
        } else {
            System.out.println("Counldn't find such student");
        }

        System.out.println("(6) - size test");
        int size = h.size();
        System.out.println("Current number of elements is: " + size);

        System.out.println();
    }

}
