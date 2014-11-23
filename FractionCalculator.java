import java.util.Scanner;

public class FractionCalculator{
	private Fraction storedValue;
	private String operator;
	private int errorCount;
	private static final String[] exits = new String[] {"Q","q","Quit","quit"};
	private final String[] abs = new String[] {"A","a","abs"};
	private final String[] negs = new String[] {"N","n","neg"};
	private final String[] clears = new String[] {"C","c","clear"};
	
	public FractionCalculator() {
		// Set the value to 0 upon initialisation
		this.setStored(makeFraction("0/1"));
		//Set errors to 0 but don't print a message;
		this.setErrors(0,"");
		
	}

    public static void main(String[] args) {
			//Create a new fraction calculator
			FractionCalculator calc = new FractionCalculator();
			//Create a new input
			Scanner sc = new Scanner(System.in);
			String input = "";
			System.out.println("Welcome to John Spear's Fraction Calculator!");

			//Keep going until they quit or there is an error.
			while((calc.getErrors() == 0)&&(findInArray(exits,input = sc.nextLine()) == false)){
				// Now evaluate the line that they have put in
				calc.setStored(calc.evaluate(calc.getStored(), input));
				//Print out the current value if there are no errors.
				if (calc.getErrors() == 0) {
					System.out.println(calc.storedValue.toString());
				} else {
					//Otherwise exit the loop
					break;
				}
			}
			//They are finished now. Thank them for using the calculator.
			System.out.println("Goodbye. Thanks for using John's calculator.");	
	}
	
	public Fraction evaluate(Fraction fraction, String input) {
			//Create an array of the input string, breaking it by space.
			//Remove any spaces from the beggining and end and then explode into an array - then loop through it.
			String[] in = input.trim().split(" ");
			// Set the operator to nothing upon each new input (seems to be what the example suggests)
			this.setOperator("0");
			for(int i = 0; i < in.length; i++) {
				if (this.isOperator(in[i])) {
					//This is an operator. Set the operator.
					this.setOperator(in[i]);
				} else if ((isFraction(in[i])) && (getOperator().equals("0"))) {
					//This is a fraction but there is no operator so we are setting the current value to this
					fraction = this.makeFraction(in[i]);									
				} else if (isFraction(in[i])) {
					//This is a fraction and there is an operator.
					Fraction tempFraction = makeFraction(in[i]);
					switch(this.getOperator()) {
						case "+":
							fraction = fraction.add(tempFraction);
							break;
						case "-":
							fraction = fraction.minus(tempFraction);
							break;
						case "*":
							fraction = fraction.multiply(tempFraction);
							break;
						case "/":
							fraction = fraction.divide(tempFraction);
							break;
					}
					// The calculation has been done. Set the operator back to nothing.
					this.setOperator("0");
				} else if (findInArray(abs,in[i])) {
					// Set it to the absolute value
					fraction = fraction.absValue();					
				} else if (findInArray(negs,in[i])) {
					// Negate it's value
					fraction = fraction.negate();
				} else if (findInArray(clears,in[i])) {
					//Clear the current value and set the operator to nothing
				    fraction = new Fraction(0,1);
					this.setOperator("0");
				} else {
					//this is not a recognised input. We're going to halt the whole thing.
					this.setErrors(this.getErrors() + 1,"Your input string contained an unrecognised input : " + in[i] + ".");
					//Set i to the length of the loop so we can exit this
					i = in.length - 1;
				}
			}
			return fraction;
	}
	
	//Start of accessors/mutators
	private void setStored(Fraction value) {
		this.storedValue = value;
	}
	
	public Fraction getStored() {
		return this.storedValue;
	}
	
	private void setOperator(String value) {
		this.operator = value;
	}
	
	private String getOperator() {
		return this.operator;
	}

	private int getErrors() {
		return this.errorCount;
	}
	
	private void setErrors(int errors, String value) {
		this.errorCount = errors;
		if (!(value.equals(""))) {
			System.out.println(value + " Your operator at the time of the error was :" + this.getOperator());
		}
	}
	//End of accessors/mutators
	
	// Start of type checking methods
	public static Boolean isFraction(String value) {
		Boolean result = false;
		if(value.contains("/"))  {
			result = true;
		} else if (isNumeric(value)) {
			result = true;
		}
		return result;
	}
	
	public static Boolean isOperator(String value) {
		Boolean result = false;
		if ((value.equals("+")) || (value.equals("/")) || (value.equals("*")) || (value.equals("-"))) {
			result = true;
		}
		return result;
	}

	public static boolean isNumeric(String value) {  
		try  {  
			int test = Integer.parseInt(value);  
		} catch(NumberFormatException nfe)  {  
			return false;  
		}  
		return true;  
	}

	private static Boolean findInArray(String[] checks, String input) {
		for(int i = 0; i < checks.length; i++) {
			if (checks[i].equals(input)) {
				return true;
			}
		}
		return false;
	}	
	// End of type checking methods
	
	public static void printArray(String[] val) {
		for(int i = 0; i < val.length; i++) {
			System.out.println(val[i]);
		}
	}
	//A method that turns a string into a fraction and returns it.
	private static Fraction makeFraction(String value) {
		if (!(value.contains("/"))) {
			//This is just a normal number. We need to make it a fraction.
			value += "/1";
		}
		//Now split it on the slash and create a new fraction.
		String[] fract = value.split("/");
		Fraction createdFraction = new Fraction(Integer.parseInt(fract[0]),Integer.parseInt(fract[1]));
		return createdFraction;
	}
}