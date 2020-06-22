package com.algorithm.concurrency.basics.latch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/*
    a. Using CountDownLatch
    Say n tasks ; Latch initialised with n;
    Latch  passed to each  task -  latch  counted down as
    each  task  ends.
    Next task waiting for latch - latch.await();
    b. Using completeable Future
    e.g
    CompletableFuture.allOf(f1, f2).thenRun(() -> {
    System.out.println("Both completed");
});


 */


public class CountDownLatchTest {

    static  Double calculatePrice(int a) throws InterruptedException {
        Thread.sleep(2000);
        return Math.random();
    }



    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.await();  //current thread  waits till countdown  to zero.
        countDownLatch.countDown(); //If latch > 0 , decrement
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //String[]  products = {String.valueOf(1)};

        int[] products ={1,2};

        CompletableFuture.supplyAsync(()->  "Fred");

        CompletableFuture.supplyAsync(()-> {
            double x = Math.random();
            try{
                Thread.sleep(2000);}
            catch(InterruptedException e){
                return Double.valueOf(0);
            }
            return x;
        });




        List<CompletableFuture<Double>> completableFutures =
             Arrays.stream(products)
                     .boxed()
                     .map(a ->
                             CompletableFuture.supplyAsync( ()->  {
                                 Double price =0.0;
                                 try {
                                     price = calculatePrice(a);
                                 }catch(InterruptedException e){

                                 }
                                 return price;
                             }
                             )
                     )
                     .collect(toList());

        completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());




    }





}
