import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyMoneyTest {
    static MyMoney s1;

    @BeforeAll
    static void setup() {
        int[] size = new int[]{8,8};
        s1 = new MyMoney("values.txt","values2.txt", size);
    }

    @Test
    void firstConstructorTest() {
        MyMoney testInstance;
        int[] size = new int[]{8,1};
        testInstance = new MyMoney("values.txt", size);
        assertNotEquals(testInstance.getCashValues().length,0);

        int[] sizeB = new int[]{8,2};
        testInstance = new MyMoney("values2.txt", sizeB);
        assertNotEquals(testInstance.getInterestValues().length,0);
    }
    @Test
    void secondConstructorTest() {
        MyMoney testInstance;
        int[] size = new int[]{8,8};
        testInstance = new MyMoney("values.txt","values2.txt", size);

        assertNotEquals(testInstance.getCashValues().length,0);
        assertNotEquals(testInstance.getInterestValues().length,0);
    }

    @Test
    void firstConstructorTestTwo() {
        MyMoney testInstance;
        int[] size = new int[]{8,2};
        testInstance = new MyMoney("values2.txt", size);
        assertNotEquals(testInstance.getInterestValues().length,0);
    }
    @Test
    void firstConstructorTestThree() {
        MyMoney testInstance;
        int[] size2 = new int[]{8,1};
        testInstance = new MyMoney("values.txt", size2);
        assertNotEquals(testInstance.getCashValues().length,0);
    }
    @Test
    void lumpSumConstantTest() {
        //Testing for the future value of $5,000 over 10 years at 5%
        assertEquals(8144,Math.round(s1.lumpSum_ConstantRate(5000, .05, 10)), "Value not equal!");
    }
    @Test
    void lumpSumConstantTestTwo() {
        //Testing for the future value of $168,000 over 5 years at 4%
        assertEquals(204398,Math.round(s1.lumpSum_ConstantRate(168000, .04, 5)), "Value not equal!");
    }
    @Test
    void variableRateTest() {
        //Testing for the future value of $5,000 using rates from the file
        assertEquals(8027,Math.round(s1.lumpSum_VariableRate(5000)), "Value not equal!");
    }
    @Test
    void variableRateTestTwo() {
        //Testing for the future value of $15,000 using rates from the file
        assertEquals(24082,Math.round(s1.lumpSum_VariableRate(15000)), "Value not equal!");
    }
    @Test
    void sameContributionTest() {
        //If we were saving $30,000 yearly at 5% for 20 years
        assertEquals(991979,Math.round(s1.compoundSavings_sameContribution(30000, .05, 20)), "Value not equal!");
    }

    @Test
    void sameContributionTestTwo() {

        //If we were saving $2500 yearly at 11% for 19 years
        assertEquals(142349,Math.round(s1.compoundSavings_sameContribution(2500, .11, 19)), "Value not equal!");
    }
    @Test
    void variableContributionTest() {
        //Testing with the cash file with a rate of 9%
        assertEquals(130788,Math.round(s1.compoundSavings_variableContribution(.09)), "Value not equal!");
    }
    @Test
    void variableContributionTestTwo() {
        //Testing with the cash file with a rate of 10%
        assertEquals(134984,Math.round(s1.compoundSavings_variableContribution(.1)), "Value not equal!");
    }


    @ParameterizedTest
    @ValueSource(doubles = {4000.0,5500.0,15000.0,18000.0,24000.0,9000.0,11000.0,12000.0})
    void getCashTest(double testVals) {
        MyMoney testInstance;
        int passed = 0;
        int[] size = new int[]{8,8};
        testInstance = new MyMoney("values.txt","values2.txt", size);
        for(int i = 0; i < testInstance.getCashValues().length; i++) {
            if(testInstance.getCashValues()[i]==testVals) {
                passed = 1;
            }
        }
        assertEquals(passed,1);
    }
    @ParameterizedTest
    @ValueSource(doubles = {4000.0,5500.0,15000.0,18000.0,24000.0,9000.0,11000.0,12000.0})
    void getCashPTestTwo(double testVals) {
        MyMoney testInstance;
        int passed = 0;
        int[] size = new int[]{8,1};
        testInstance = new MyMoney("values.txt", size);
        for(int i = 0; i < testInstance.getCashValues().length; i++) {
            if(testInstance.getCashValues()[i]==testVals) {
                passed = 1;
            }
        }
        assertEquals(passed,1);
    }
    @Test
    void getInterestTest() {
        MyMoney testInstance;
        int[] size = new int[]{8,8};
        testInstance = new MyMoney("values.txt","values2.txt", size);
        double[] passed = new double[]{.055,.075,.045,.09,.10,.065,.035,.025};
        assertArrayEquals(testInstance.getInterestValues(),passed);
    }
    @Test
    void getInterestTestTwo() {
        MyMoney testInstance;
        int[] size = new int[]{8,2};
        testInstance = new MyMoney("values2.txt", size);
        double[] passed = new double[]{.055,.075,.045,.09,.10,.065,.035,.025};
        assertArrayEquals(testInstance.getInterestValues(),passed);
    }
}
