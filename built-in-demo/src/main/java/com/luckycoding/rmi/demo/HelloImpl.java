package com.luckycoding.rmi.demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常
     * 因此这里默认的构造方法必须写，必须声明抛出RemoteException异常 * @throws RemoteException
     */
    public HelloImpl() throws RemoteException {
    }

    public String helloWorld() throws RemoteException {
        return "Hello World";
    }

    public String helloTo(String name) throws RemoteException {
        return "Hello " + name;
    }
}
