import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore number = new Semaphore(1);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            number.acquire();
            synchronized (this) {
                if (current > n) break;
                if (current % 3 == 0 && current % 5 == 0) {
                    fizzbuzz.release();
                } else if (current % 3 == 0) {
                    fizz.release();
                } else if (current % 5 == 0) {
                    buzz.release();
                } else {
                    printNumber.accept(current);
                    current++;
                    number.release();
                }
            }
        }
        // Release other semaphores in case they're waiting after `n` is exceeded
        fizz.release();
        buzz.release();
        fizzbuzz.release();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizz.acquire();
            synchronized (this) {
                if (current > n) break;
                printFizz.run();
                current++;
                number.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzz.acquire();
            synchronized (this) {
                if (current > n) break;
                printBuzz.run();
                current++;
                number.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzbuzz.acquire();
            synchronized (this) {
                if (current > n) break;
                printFizzBuzz.run();
                current++;
                number.release();
            }
        }
    }
}
