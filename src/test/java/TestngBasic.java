import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngBasic {
    @Test
    public void test1() {
        String testExpected = "cao";
        //dohvatanje podatka...
        //izvrsavanje neke akcije
        String testActual = "ca";

        Assert.assertEquals(testActual, testExpected, "Poruke treba da budu jedanke");
    }

    @Test
    public void test2() {
        String testExpected = "cao";
        //dohvatanje podatka...
        //izvrsavanje neke akcije
        String testActual = "cao";

        Assert.assertEquals(testActual, testExpected, "Poruke treba da budu jedanke");
    }

    @Test
    public void test3() {
        int x = 10;
        int y = 5;

        Assert.assertTrue(x - y == 5, "rezultat bi trebalo da bude 5");
    }

    @Test
    public void test4() {
        Assert.assertFalse(true, "...should be false");
    }
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Cedric", 45},
                { "Anne",26},
        };
    }
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }



}