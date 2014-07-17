
public class LinkedStringLog implements StringLogInterface {
	private LLStringNode log;
	private String name;
	
	public LinkedStringLog(String name){
		log = null;
		this.name = name;
		
	}
		
	@Override
	public void insert(String element) {
		// 
		LLStringNode newNode = new LLStringNode(element);
		newNode.setLink(log);
		log = newNode;		
	}

	@Override
	public boolean isFull() {
		// always false never full
		return false;
	}

	@Override
	public int size() {
		// 
		int count = 0;
		LLStringNode node = log;
		while (node != null){
			count++;
			node = node.getLink();
		}
		return count;
	}

	@Override
	public boolean contains(String element) {
		// 
		LLStringNode node = log;
		while(node != null){
			if(element.equalsIgnoreCase(node.getInfo())){
				return true;
			}else{
				node = node.getLink();
			}
		}
		
		return false;
	}

	@Override
	public void clear() {
		// clear the linked list
		log = null;
	}

	@Override
	public String getName() {
		// return the name
		return name;
	}
	
	@Override
	public String toString() {
		// 
		String logString = "Log: " + name + "\n\n";
		LLStringNode node = log;
		int count = 0;
		while (node != null){
			count++;
			logString += count + ". " + node.getInfo() + "\n";
			node = node.getLink();
		}
		return logString;
	}
	
}
