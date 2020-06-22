package com.algorithm.concurrency.completeableFuture;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class TwoSequentialTasks {

    public static void main(String[] args) {

        long end = System.nanoTime();

        CompletableFuture<Long> completableFutureA = CompletableFuture.supplyAsync(
                ()->{
                    long start =System.nanoTime();
                    System.out.println("ComleteableFuture A - st");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ComleteableFuture A - ended");
                    return System.nanoTime() - start;
                }
        );

        CompletableFuture completableFutureB = CompletableFuture.supplyAsync(()-> {
            System.out.println("WHAT HO B" + System.nanoTime()); return "All done ";} );

        //completableFutureA.join();  //Returns  result when completed.


        CompletableFuture.allOf(completableFutureA,completableFutureB).thenRun(()-> System.out.println("Done"));

        System.out.println("END");


    }
}
