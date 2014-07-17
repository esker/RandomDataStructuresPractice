
//---------------------------------------------------------------------
//StringBag.java
//
//Implements a StringBag using an array to hold the strings.
//Tom Billings, 18 Sept 2012
//edited by DAMB, 25 Sept 2012
//---------------------------------------------------------------------

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class StringBag
{
	protected String[] bag;						// array that holds the strings
	protected int lastIndex = -1;			// index of the last string in the array/bag
	private Random generator;					// random number generator for remove method			

	public StringBag()
	// Instantiates and returns a reference to an empty StringBag object
	// that has room for a default of 100 strings.
	{
		bag = new String[100];
		generator = new Random();
	}

	public StringBag(int maxSize)
	// Precondition: maxSize > 0
	//
	// Instantiates and returns a reference to an empty StringBag object
	// that has room for maxSize strings.
	{
		bag = new String[maxSize];
		generator = new Random();
	}

	public void insert(String element)
	// Precondition: The StringBag is not full.
	//
	// Places an element into the StringBag
	{
		lastIndex++;
		bag[lastIndex] = element;
	}

	public String remove()
	// Precondition: The StringBag is not empty.
	//
	// Removes a random string from this StringBag; then fills in the hole
	// with the last element in the bag.
	{
		// compute random string to be removed
		int k = generator.nextInt(size()); //Math.abs(generator.nextInt()) % size();
		// grab kth element and move last element into k's spot
		String removed = bag[k];

		bag[k] = bag[lastIndex];
		bag[lastIndex] = null;
		lastIndex--;

		return removed;
	}

	public String remove(int k)
	// Precondition: The StringBag is not empty.
	//
	// Removes the kth string from this StringBag; then fills in the hole
	// with the last element in the bag.
	{
		// grab kth element and move last element into k's spot
		String removed;
		if (k >= 0 && k < this.size())
		{
			removed = bag[k];
			bag[k] = bag[lastIndex];
			bag[lastIndex] = null;
			lastIndex--;
		}
		else
			throw new ArrayIndexOutOfBoundsException("Cannot remove from a location that doesn't exist.");

		return removed;
	}

	public boolean isFull()
	// Returns true if this StringBag is full; otherwise, returns false.
	{
		if (lastIndex == (bag.length - 1))
			return true;
		else
			return false;
	}

	public int size()
	// Returns the number of strings in this StringBag.
	{
		return lastIndex + 1;
	}

	public void clear()
	// Makes this StringBag empty.
	{
		for (int j = 0; j <= lastIndex; j++)
			bag[j] = null;
		lastIndex = -1;
	}

	public String toString()
	// Returns a nicely formatted string representing this StringBag.
	{
		String bagString = "This StringBag contains the following strings:\n\n";

		for (int j = 0; j <= lastIndex; j++)
			bagString = bagString + "  - " + bag[j] + "\n";

		return bagString;
	}
	
	public void loadFromFile (String filename) {
		// inserts each line of given file into calling StringBag
		try{
			FileReader fin = new FileReader (filename);
			Scanner reader = new Scanner (fin);
			while (reader.hasNextLine( )) 
				this.insert(reader.nextLine( ));
			}
		catch (IOException e) {
			System.out.println ("File IO error in loadFromFile");
		}
	}
	
	public static void main (String [ ] args) {
		// load source file of this class into bag, print its toString
		StringBag sb = new StringBag(500);
		sb.loadFromFile ("StringBag.java");
		System.out.println (sb);
	}
}