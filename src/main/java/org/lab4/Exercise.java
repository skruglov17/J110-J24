package src.main.java.org.lab4;

public class Exercise {

    public static void startEx() throws Exception {

        LogicInterface logic = new IntegerLogic();

        logic.setTrue(5);
        logic.setTrue(10);
        logic.setTrue(20);
        logic.setTrue(25);
        logic.setTrue(30);

        System.out.println(logic.countTrue());
        System.out.println(logic);

        logic.reverse(15);

        System.out.println(logic.countTrue());
        System.out.println(logic);

        logic.reverse(10);
        logic.reverse(15);

        System.out.println(logic.countTrue());
        System.out.println(logic);

        logic.setIndex(0,true);
        System.out.println(logic);
        logic.setIndex(0, true);
        System.out.println(logic);
        logic.setIndex(0, false);
        System.out.println(logic);
        logic.setIndex(0, false);
        System.out.println(logic);
        logic.setFalse(6);
        logic.setFalse(6);
        System.out.println(logic);
    }
}
