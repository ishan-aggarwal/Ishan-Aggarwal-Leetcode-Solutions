class Foo {

    private Semaphore forTwo;
    private Semaphore forThree;
    
    public Foo() {
        forTwo = new Semaphore(0);
        forThree = new Semaphore(0);
    }


    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        forTwo.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        forTwo.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        forThree.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        
        forThree.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}