package shallowdeepcopy;

public class DeepCopyDemo {

    public static void main(String[] args) {

        Address address = new Address("Indore");
        Person p1 = new Person("Rahul", address);

        // Deep copy
        Person p2 = new Person(p1);

        // Modify copied object
        p2.address.city = "Bhopal";

        System.out.println("P1 City: " + p1.address.city);
        System.out.println("P2 City: " + p2.address.city);
    }
}

