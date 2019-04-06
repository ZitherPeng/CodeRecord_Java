package hogwarts.basics.grammar;


import org.junit.Test;

public class BasicType {

    boolean aBoolean;
    byte aByte;
    char aChar;
    short aShort;
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;

    @Test
    public void defaultValue() {
        System.out.println(aBoolean);
        System.out.println(aByte);
        System.out.println(aChar);
        System.out.println(aShort);
        System.out.println(anInt);
        System.out.println(aLong);
        System.out.println(aFloat);
        System.out.println(aDouble);
    }

    @Test
    public  void valuation(){
        aBoolean = true;
        aByte = 3;
        aChar = 's';
        aShort = 3;
        anInt = 2;
        aLong = 3l;
        aFloat = 3.2f;
        aDouble = 3.2;
        defaultValue();
    }



}
