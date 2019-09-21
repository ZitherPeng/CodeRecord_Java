package com.luckycoding.rmi.demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Hello rhello = (Hello) Naming.lookup("rmi://localhost:8899/Hello");
            System.out.println(rhello.helloWorld());
            System.out.println(rhello.helloTo("LuckyCoding"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


