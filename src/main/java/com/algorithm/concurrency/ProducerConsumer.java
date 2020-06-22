package com.algorithm.concurrency;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

  //  static ArrayBlockingQueue<Member> members = new ArrayBlockingQueue<>(10);


    static List<Member> members = new ArrayList<>();



    // Producer adds  to  shared resource
    //Consumer  removes  from shared  resource;


    public static void main(String[] args) {
        Member memberA = new Member("Able", 45, MemberType.FULL);
        Member memberB = new Member("Barns", 45, MemberType.FAMILY);
        Member memberC = new Member("Chris", 21, MemberType.JUNIOR);
        Member memberD = new Member("Don", 17, MemberType.JUNIOR);
        Member memberE = new Member("Evan", 27, MemberType.COUNTRY);
        Member memberF = new Member("Fran", 37, MemberType.COUNTRY);

        Member[] mems = {memberA , memberB, memberC , memberD , memberE ,memberF};
        members.addAll(Arrays.asList(mems));

        Thread threadB = new Thread(new  Runnable() {
            @Override
            public void run() {
                Accounts.payAll(members);
            }
        });

        threadB.start();

        synchronized (members) {
            try {
                members.wait();
            }catch(Exception e){
                System.out.println("Continues");
            }
            for (Member mem : members
            ) {
                if (mem.paid) {
                    System.out.println(mem.name);
                }
            }
        }

    }


    static class  Accounts{
        public static  void pay(Member member){
            member.paid =true;
        }

        public static  void reject(Member member){
            member.paid =false;
        }

        public static void payAll(List<Member> members) {
            synchronized (members) {
                for (Member mem :
                        members) {
                    mem.paid = true;
                }
                members.notify();
            }
        }
    }


    enum MemberType{
        FULL,
        COUNTRY,
        FAMILY,
        JUNIOR,
        SOCIAL;
    }

    static class Member{
        String name ;
        int age;

        MemberType memberType ;

        boolean paid;

        public Member(String name, int age, MemberType memberType) {
            this.name = name;
            this.age = age;
            this.memberType = memberType;
        }
    }


}
