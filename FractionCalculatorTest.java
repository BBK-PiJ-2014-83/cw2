/**
 * Created by John Spear for the second coursework assignment.
 */
public class FractionCalculatorTest {
    public static void main(String[] args) {
		//Create a new calculator
		FractionCalculator calc = new FractionCalculator();
		Fraction currentValue = calc.getStored();
		printResult("Just initialised. Value of calculator should currently be 0. It is now : " + currentValue.toString());
		currentValue = calc.evaluate(currentValue, "2/5");
		printResult("Evaluating an input string. Should set value to 2/5. Current value is " + currentValue.toString());
		currentValue = calc.evaluate(currentValue, "* 1/2");
		printResult("Now multiplying current value by 1/2. Should set value to 1/5. Current value is " + currentValue.toString());
		currentValue = calc.evaluate(currentValue, "/ 1/2");
		printResult("Now dividing current value by 1/2. Should go back to 2/5. Current value is " + currentValue.toString());
		currentValue = calc.evaluate(currentValue, "- 1/12");
		printResult("Now minus 1/12 from current value. Should now be set to 19/60. Current value is " + currentValue.toString());
        currentValue = calc.evaluate(currentValue, "neg");
		printResult("Now use the neg function. Should now be set to 19/-60. Current value is " + currentValue.toString());
        currentValue = calc.evaluate(currentValue, "abs");
		printResult("Now testing the abs. Should now be set back to 19/60. Current value is " + currentValue.toString());
        currentValue = calc.evaluate(currentValue, "C");
		printResult("Now testing the abs. Should now be set back to 0. Current value is " + currentValue.toString());
        currentValue = calc.evaluate(currentValue, "1/3 * 1/2 / 1/7 - 5 abs");
		printResult("Now testing the a line of calculation. Answer should be 23/6. Current value is " + currentValue.toString());
        currentValue = calc.evaluate(currentValue, "-4/11 n * 2/3 + 2/11 - 3 abs * 1/4");
		printResult("Now testing the a line of calculation. Answer should be 85/132. Current value is " + currentValue.toString());

		
		printResult("We've now tested all the core functionality. Let's try to enter an error");
	    currentValue = calc.evaluate(currentValue, "4/7 + r");	
		
	}
	
	public static void printResult(String message) {
		System.out.println(message + ".");
		System.out.println("");
	}
	
}
