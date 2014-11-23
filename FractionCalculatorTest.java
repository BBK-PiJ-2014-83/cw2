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
    }
	
	public static void printResult(String message) {
		System.out.println(message + ".");
		System.out.println("");
	}
	
}
