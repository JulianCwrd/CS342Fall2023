public class SavingsFormulas {
    /* futureValueLumpSum
    This method takes a lump sum of money and figures out how much it will be worth in a
    certain number of years at a constant interest rate. The formula is
    FV = PV(1+i)^N
    PV (double cash)
    i (double interest)
    N ( int years)
    */
    public static double futureValueLumpSum(double cash, double interest, int years){
        double result = cash * Math.pow((1+interest),years);
        return result;
    }

    /* futureValueLS_VariableInterest
    This method takes a lump sum of money and figures out how much it will be worth in a
    certain number of years at a varying interest rate per year. The values Array is loaded
    with interest rates from values2.txt. Each index in the array corresponds to the rate for a
    specific year.
     */
    public static double futureValueLS_VariableInterest(double cash, double values[]) {
        for (int i = 0; i < values.length; i++) {
            cash = cash * (1 + values[i]);
        }
        return cash;
    }

    public static double compoundSavingsConstant(double cash, double interest, double years){
        double value = cash * (((Math.pow(1+interest,years))-1)/interest);
        return value;
    }

    public static double compoundSavingsVariable(double values[], double interest){
        double value = values[0];
        for(int i = 1; i < values.length; i++){
            value += (value * interest) + values[i];
        }
        return value;
    }
}
