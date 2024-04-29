public class Main {


    public synchronized void m1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        synchronized (this) {
            m2();
        }
    }

    public synchronized void m2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        synchronized (this) {
            m1();
        }
    }

    public static void main(String[] args) {

        Main t1 = new Main();
        Main t2 = new Main();
        new Thread(() -> {
            try {
                t1.m1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                t2.m2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}