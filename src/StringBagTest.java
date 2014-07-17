//---------------------------------------------------------------------
// StringBagTest.java
//
// Tests StringBag implemenation for project #1.
// Written by Tom Billings, 16 September 2012 
//
//---------------------------------------------------------------------

public class StringBagTest {
	// driver for Project 01, it tests the ArrayStringBag class
	public static void main(String[] args) {
		StringBag sb = new StringBag(10);
		String output = "";
		boolean[] tests = new boolean[5];

		// Insert a bunch of Strings (in this case five)
		sb.insert("One fish, two fish");
		sb.insert("I would not eat them here or there.");
		sb.insert("heethreetreebee");
		sb.insert("The king of a house and a cow and a mule...");
		sb.insert("There rang out the noisiest ear-splitting squeaks. From the egg that he’d sat on for fifty-one weeks!");

		// Display the contents of the StringBag
		System.out.println(sb);

		// How big is the StringBag?
		output = Integer.toString(sb.size());
		if (output.equals("5")) {
			System.out.println("***** Pass Test #01 - Your StringBag has "
					+ output + " Strings.");
			tests[0] = true;
		} else
			System.out.println("***** Fail Test #01 - Your StringBag has "
					+ output + " Strings instead of 5 Strings");

		// Is the StringBag full?
		output = Boolean.toString(sb.isFull());
		if (output.equals("false")) {
			System.out
					.println("***** Pass Test #02 - Your StringBag is not full.");
			tests[1] = true;
		} else
			System.out
					.println("***** Fail Test #02 - Your StringBag was full when it shouldn't have been.");

		// Check functionality of remove(k)
		System.out.println("Now I'll remove the third string:");
		output = sb.remove(2);
		if (output.equals("heethreetreebee")) {
			System.out
					.println("***** Pass test #03 - Your code correctly removed: ");
			tests[2] = true;
		} else
			System.out
					.println("***** Fail test #03 - Your code incorrectly removed: ");
		System.out.println("" + output);

		// Clear the StringBag
		sb.clear();
		if (sb.size() == 0) {
			System.out.println("***** Pass test #04 - The StringBag is empty!");
			tests[3] = true;
		} else
			System.out
					.println("***** Fail test #04 - The StringBag is not empty!");

		// Reinsert everything to check random removes.
		sb.insert("One fish, two fish");
		sb.insert("I would not eat them here or there.");
		sb.insert("heethreetreebee");
		sb.insert("The king of a house and a cow and a mule...");
		sb.insert("There rang out the noisiest ear-splitting squeaks. From the egg that he’d sat on for fifty-one weeks!");

		// Display the contents of the StringBag
		System.out.println(sb);

		// Remove a random string.
		System.out.println("Now I'll remove a random string: ");
		output = sb.remove();
		System.out.println(output);

		System.out.println("Here are the contents afterwards...");
		System.out.println(sb);

		// Let's remove the remaining four Strings to empty it out.
		for (int j = 0; j < 4; j++) {
			output = sb.remove();
			System.out.println("The following string was randomly removed: "
					+ output);
		}

		// Check to make sure it's empty
		if (sb.size() == 0) {
			System.out
					.println("***** Pass test #05 - The StringBag is empty after 5 random removes!");
			tests[4] = true;
		} else
			System.out
					.println("***** Fail test #05 - The StringBag is not empty after 5 random removes!");

		// Test results calculations
		int test = 0;
		for (int j = 0; j < 5; j++)
			if (tests[j] == true)
				test += 1;

		System.out.println("You passed " + test + " of 5 tests.");
	}
}