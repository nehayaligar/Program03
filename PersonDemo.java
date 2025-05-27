package PROGRAM03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Person {
    String name;
    Date dob;

    Person(String name, String dobString) {
        this.name = name;
        try {
            this.dob = new SimpleDateFormat("dd-MM-yyyy").parse(dobString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Use DD-MM-YYYY.");
        }
    }

    int getAge() {
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(dob);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Person Name: " + name);
        System.out.println("Date of Birth: " + dateFormat.format(dob));
        System.out.println("Age: " + getAge() + " years");
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person("Neha", "27-05-2000");
        person.displayInfo();
    }
}
