package com.luckycoding.serialize.demo;

import java.io.*;

public class SerializableTest {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/built-in-demo/src/main/java/com/luckycoding/serialize/demo/zither.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeFlyPig();
        FlyPig flyPig = deserializeFlyPig();
        System.out.println(flyPig.toString());
    }


    private static void serializeFlyPig() throws IOException {
        FlyPig flyPig = new FlyPig();
        flyPig.setName("zither");
        flyPig.setColor("red");
        flyPig.setCar("BWM");
        // ObjectOutputStream 对象输出流，将 flyPig 对象存储 zither 文件中，完成对 flyPig 对象的序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH)));
        oos.writeObject(flyPig);
        System.out.println("FlyPig 对象序列化成功！");
        oos.close();
    }

    private static FlyPig deserializeFlyPig() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FILE_PATH)));
        FlyPig person = (FlyPig) ois.readObject();
        System.out.println("FlyPig 反序列化成功！");
        return person;
    }

}
