class Demo {
    int counter = 0;

    public synchronized void increment() {
        counter++;
    }
}


public class Concurrency {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(demo.counter);
    }
}
