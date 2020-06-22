package com.algorithm.callbacks;

final class SomeService {

    void performAsync(SomethingWithCallBack callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }

    void perform() {
        System.out.println("Service is being performed.");
    }
}

