import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    Semaphore A,B,C,D;
    public FizzBuzz(int n) {
        this.n = n;
        A = new Semaphore(1);
        B = new Semaphore(0);
        C = new Semaphore(0);
        D = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i =1;i<=n;i++){
            A.acquire();
            if(i%3==0 && i%5 != 0){
                printFizz.run();
            }
            B.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i =1;i<=n;i++){
            B.acquire();
            if(i%3 != 0 && i%5 == 0){
                printBuzz.run();
            }
            C.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i =1;i<=n;i++){
            C.acquire();
            if(i%3==0 && i%5 == 0){
                printFizzBuzz.run();
            }
            D.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i =1;i<=n;i++){
            D.acquire();
            if(i%3 !=0 && i%5 != 0){
                printNumber.accept(i);
            }
            A.release();
        }
    }
}