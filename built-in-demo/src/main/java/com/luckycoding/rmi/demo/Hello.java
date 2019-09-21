package com.luckycoding.rmi.demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI的开发步骤:
 1)先创建远程接口及声明远程方法，注意这是实现双方通讯的接口，需要继承Remote。
 2)开发一个类来实现远程接口及远程方法，值得注意的是实现类需要继承 UnicastRemoteObject。
 3)发布服务端，启动远程对象，Naming.bind("rmi://localhost:8888/RHello",rhello);。
 4)最后客户端查找远程对象，并调用远程方法，Naming.lookup("rmi://localhost:8888/RHello");
 */
public interface Hello extends Remote {

    public String helloWorld() throws RemoteException;

    public String helloTo(String name) throws RemoteException;
}


