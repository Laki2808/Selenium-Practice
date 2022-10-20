import org.testng.annotations.*;

public class Annotations {
    @BeforeClass
    public void setUp() {
        System.out.println("**************");
        System.out.println("Before class se izvrsava samo jednom pre svih metoda");
        System.out.println("**************");
    }

    @BeforeMethod
    public void setUpPage() {
        System.out.println("----------");
        System.out.println("Before method se izvrsava pre SVAKE test anotacija, koliko god da ima test anotacija");
        System.out.println("----------");
    }

    @AfterMethod
    public void cleanUpPage() {
        System.out.println("==========");
        System.out.println("After method se izvrsava posle SVAKE test anotacije, koliko god da ima test anotacija");
        System.out.println("==========");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("...............");
        System.out.println("After class se izvrsava samo jednom posle svih metoda");
        System.out.println("...............");
    }

    @Test(priority = 10)
    public void test1() {
        System.out.println("TEST1");
    }

    @Test(priority = 20)
    public void test2() {
        System.out.println("TEST2");
    }

    @Test(priority = 30)
    public void test3() {
        System.out.println("TEST3");
    }

    @Test(priority = 5)
    public void test0() {
        System.out.println("Prvi test naknadno ubacen");
    }

    @Test(priority = 25)
    public void test25() {
        System.out.println("Test koji mora biti izmedju testa 2 i 3");
    }


}

