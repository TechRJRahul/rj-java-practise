package multithreading;

public class MultiThreadDemo {
    // Shared variables
    static int counter = 0;                  // for synchronized demo
    static volatile boolean running = true;  // for volatile demo
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread();
        mythread.start();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread thread2 = new Thread(() -> System.out.println("Way 3 of thread creation, Java 8 functional programming style"));
        thread2.start();

        Thread lifecycleThread = new Thread(() -> {
            System.out.println("Thread state inside run(): " + Thread.currentThread().getState());
        });
        System.out.println("Before start(): " + lifecycleThread.getState());
        lifecycleThread.start();
        lifecycleThread.sleep(1000);
        System.out.println("In waiting/sleep state: " + lifecycleThread.getState());
        lifecycleThread.join(); // main waits
        System.out.println("After completion: " + lifecycleThread.getState());

        Thread thread3 = new Thread(MultiThreadDemo::incrementCounter);
        Thread thread4 = new Thread(MultiThreadDemo::incrementCounter);
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        System.out.println("Counter Value : " + counter);

          // Volitile demonstration
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started");
            while (running) {
                // busy wait
            }
            System.out.println("Worker thread stopped");
        });

        worker.start();
        Thread.sleep(1000);
        running = false; // visible immediately due to volatile
    }
    // synchronized method
    static synchronized void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
  

}
class Mythread extends Thread{
    public void run(){
        System.out.println("Way 1 of thread creation by extending Thread class");
    }
}
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Way 2 of thread creation by implementing runnable interface");
    }
}
