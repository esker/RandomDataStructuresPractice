
public class ArrayStringLog implements StringLogInterface {

	protected String [] log;
	protected int lastIndex = -1;
	private String name;
	
	public ArrayStringLog(String name){
		this(name, 100);
	}
	
	public ArrayStringLog(String name, int maxSize){
		log = new String[maxSize];
		this.name = name;	
	}
	
	@Override
	public void insert(String element) {
		//need to add some check in here to make sure log isn't full
		lastIndex++;
		log[lastIndex] = element;		
	}

	@Override
	public boolean isFull() {
		// checks for size of 
		if (lastIndex == (log.length - 1))
			return true;
		return false;
	}

	@Override
	public int size() {
		// 
		return lastIndex + 1;
	}

	@Override
	public boolean contains(String element) {
		int location = 0;
		while (location <= lastIndex){
			if (element.equalsIgnoreCase(log[location]))
				return true;
			else
				location++;
		}
		return false;
	}

	@Override
	public void clear() {
		// 
		for (int i = 0; i <= lastIndex; i++){
			log[i] = null;
		}
		lastIndex = -1;
	}

	@Override
	public String getName() {
		// 
		return name;
	}
	
	public String toString(){
		String logString = "Log: " + name + "\n\n";
		 
		for (int i = 0; i <= lastIndex; i++)
			logString += ((i+1) + ". " + log[i] + "\n");
		 
		return logString;
	}

}
