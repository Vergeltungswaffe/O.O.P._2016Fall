package OOPQuiz2;

import java.util.ArrayList;
import java.util.Calendar;

public class Quiz2
{
    static void problem1() throws InterruptedException
    {
        A.greeting();
        Thread.sleep(500); //0.5초간 실행 정지
        A a = new A();
        Thread.sleep(1700); //1.7초간 실행정지
        A b = new A();
        System.out.println(a.getSeconds());
        System.out.println(b.getSeconds());
    }

    static void problem2()
    {
        // ArrayList에 Tank, Marine, Vuture 클래스의 객체 삽입
        ArrayList<Unit> queue = new ArrayList<>();
        queue.add(new Tank());
        queue.add(new Marine());
        queue.add(new Vulture());

        System.out.println("------------------"); //구분선

        // 각 객체의 HP를 변화시킨다

        for (Unit u : queue)
        //여기에 코드 작성
        {
            u.attacked((int)(Math.random() * 100));
        }
        System.out.println("------------------"); //구분선

        //scv객체를 하나 생성하고 queue의 모든 객체 수리
        SCV scv = new SCV();
        for(Unit u : queue)
        {
            scv.repairUnit(u);
        }
    }

    //main 메소드. interruptedException은 신경쓰지 않습니다.
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("*** Problem 1 ***");
        problem1();
        System.out.println("*** Problem 2 ***");
        problem2();
    }
}

//A 클래스를 완성하세요
class A
{
    static void greeting()
    {
        System.out.println("Greeting! Class A is loaded");
    }

    public static double startTime = Calendar.getInstance().getTimeInMillis();
    private double endTime;

    public A()
    {
        endTime = Calendar.getInstance().getTimeInMillis();
    }

    public double getSeconds()
    {
        double output = endTime - startTime;
        return output * 0.001;
    }
}

//아래에 2번 문제에 필요한 클래스 및 인터페이스를 정의하세요
class Unit
{
    public final int HP_SCV = 10;
    public final int HP_Marine = 30;
    public final int HP_Vulture = 70;
    public final int HP_Tank = 100;

    protected int max_hp;
    protected int curr_hp;
    protected String name;

    protected Unit(int unit)
    {
        int initialHP=0;
        switch (unit)
        {
            case 0:
                initialHP = HP_SCV;
                break;
            case 1:
                initialHP = HP_Marine;
                break;
            case 2:
                initialHP = HP_Vulture;
                break;
            case 3:
                initialHP = HP_Tank;
                break;
        }
        max_hp = initialHP;
        curr_hp = initialHP;
    }

    public void attacked(int dam)
    {
        int output = dam;
        if (dam < 1)
        {
            output = 1;
        }
        if (dam > max_hp)
        {
            output = max_hp;
        }
        curr_hp = output;
        System.out.println("Attacked! " + name + " HP becomes " + curr_hp);
    }
}

interface Repairable
{
    void repair();
}

class SCV extends Unit
{
    public SCV()
    {
        super(0);
        name = "SCV";
        System.out.println(name + " is created. Current HP is " + curr_hp);
    }

    public void repairUnit(Unit u)
    {
        if (u instanceof Repairable)
        {
            ((Repairable) u).repair();
        }
        else
        {
            System.out.println("SCV can't repair "+u.name);
        }
    }
}

class Marine extends Unit
{

    public Marine()
    {
        super(1);
        name = "Marine";
        System.out.println(name + " is created. Current HP is " + curr_hp);
    }

}

class Vulture extends Unit implements Repairable
{

    public Vulture()
    {
        super(2);
        name = "Vulture";
        System.out.println(name + " is created. Current HP is " + curr_hp);
    }

    public void repair()
    {
        curr_hp = max_hp;
        System.out.println("Repaired: "+name+" HP becomes "+max_hp);
    }

}

class Tank extends Unit implements Repairable
{

    public Tank()
    {
        super(3);
        name = "Tank";
        System.out.println(name + " is created. Current HP is " + curr_hp);
    }

    public void repair()
    {
        curr_hp = max_hp;
        System.out.println("Repaired: "+name+" HP becomes "+max_hp);
    }

}