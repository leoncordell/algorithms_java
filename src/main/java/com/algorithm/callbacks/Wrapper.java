package com.algorithm.callbacks;

public class Wrapper implements SomethingWithCallBack{

    private final WrappedObject wrappedObject;

    Wrapper(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void doSomething() {
        wrappedObject.doSomething();
    }

    void doSomethingElse() {
        System.out.println("We can do everything the wrapped object can, and more!");
    }

    @Override
    public void call() {
        System.out.println("Wrapper callback!");
    }
}
