import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SavingsMethodTest {
    static MyMoney s1;
    static MyMoney s2;

    @BeforeAll
    static void setup() {
        int[] size = new int[]{8,8};
        s1 = new MyMoney("values.txt","values2.txt", size);
        int[] size2 = new int[]{8,2};
        s2 = new MyMoney("values2.txt", size2);
    }
    // futureValueLumpSum Tests
    @Test
    void futureValLumpSumTest() {
        //future value of $1,500 over 10 years at 7%
        assertEquals(2951,Math.round(SavingsFormulas.futureValueLumpSum(1500, .07, 10)), "wrong value");
    }
    @Test
    void futureValLumpSumTwoTest() {

        //future value of $100,000 over 5 years at 5%
        assertEquals(127628,Math.round(SavingsFormulas.futureValueLumpSum(100000, .05, 5)), "wrong value");
    }

    //futureValueLS_VariableInterest Tests
    @Test
    void futureValueVariableTest() {
        assertEquals(43348,Math.round(SavingsFormulas.futureValueLS_VariableInterest(27000, s2.getInterestValues())), "wrong value");
    }
    @Test
    void futureValueVariableTestTwo() {
        assertEquals(24082,Math.round(SavingsFormulas.futureValueLS_VariableInterest(15000, s2.getInterestValues())), "wrong value");
    }
    //compoundSavingsConstant Tests
    @Test
    void compoundSavingsConstantTest() {
        //$39,000 each year at 9% interest for 20 years
        assertEquals(1995245,Math.round(SavingsFormulas.compoundSavingsConstant(39000, .09, 20)), "wrong value");
    }

    @Test
    void compoundSavingsConstantTestTwo() {
        //$2700 each year with 10% interest for 10 years
        assertEquals(43031,Math.round(SavingsFormulas.compoundSavingsConstant(2700, .1, 10)), "wrong value");
    }
    //compoundSavingsVariable Tests
    @Test
    void compoundSavingsVariableTest() {
        //Using the cash text file with a rate of 8%
        assertEquals(126723,Math.round(SavingsFormulas.compoundSavingsVariable(s1.getCashValues(), .08)), "wrong value");
    }
    @Test
    void compoundSavingsVariableTestTwo() {
        //Using the cash text file with a rate of 10%
        assertEquals(134984,Math.round(SavingsFormulas.compoundSavingsVariable(s1.getCashValues(), .1)), "wrong value");
    }


}
