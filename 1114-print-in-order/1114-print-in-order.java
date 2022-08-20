class Foo {

    private Semaphore one;
    private Semaphore two;
    
    public Foo() {
        one = new Semaphore(0);
        two = new Semaphore(0);
    }


    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        one.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        
        two.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}