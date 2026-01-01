package memory;

public class MemoryDemo {

    static int staticVar = 100;   // class-level
    int instanceVar = 200;        // object-level

    void show() {
        int localVar = 300;       // method-level

        System.out.println("Inside show()");
        System.out.println("Local Var: " + localVar);
        System.out.println("Instance Var: " + instanceVar);
        System.out.println("Static Var: " + staticVar);

        
    }

    public static void main(String[] args) {

        MemoryDemo obj1 = new MemoryDemo();
        MemoryDemo obj2 = new MemoryDemo();

        System.out.println("Object identity (heap objects):");
        System.out.println("obj1 hash: " + System.identityHashCode(obj1));
        System.out.println("obj2 hash: " + System.identityHashCode(obj2));

        System.out.println("\nStatic variable (shared):");
        System.out.println("obj1.staticVar: " + obj1.staticVar);
        System.out.println("obj2.staticVar: " + obj2.staticVar);

        System.out.println("\nInstance variable (separate per object):");
        System.out.println("obj1.instanceVar: " + obj1.instanceVar);
        System.out.println("obj2.instanceVar: " + obj2.instanceVar);

        obj1.show();
    }
}
