package shallowdeepcopy;

public class Person {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy constructor
    // Person(Person other) {
    //     this.name = other.name;
    //     this.address = other.address; // SAME reference
    // }
    // Deep copy constructor
    Person(Person other) {
        this.name = other.name;
        this.address = new Address(other.address.city); // NEW object
    }
}

