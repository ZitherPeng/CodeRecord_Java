package hogwarts.basics.grammar;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hello zither!");
        checkNumber();
    }

    /**
     * 0-100, 如果是大于40的数字，输入 xx 大于40，如果是小于40的数字，输出 xx 小于40
     */
    private static void checkNumber() {
        for (int i = 0; i < 101; i++) {
            if (i < 40) {
                System.out.println(i + "小于40");
            } else if (i > 40) {
                System.out.println(i + "大于40");
            } else {
                System.out.println(i + "等于40");
            }
        }
    }
}
