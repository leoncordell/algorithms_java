package com.algorithm.callbacks;

public class WrappedObject implements SomethingWithCallBack{
    private final SomeService service;

    WrappedObject(SomeService service) {
        this.service = service;
    }

    @Override
    public void doSomething() {
        service.performAsync(this);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}
