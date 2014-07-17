import java.util.Random;

public class LinkedStringBag {
	private String value;
	private StringBagNode sbNode;

	public LinkedStringBag() {
		value = null;
		sbNode = null;
	}

	public String LinkedStringBag() {
		String stringBag = null;
		int count = 0;
		while (sbNode != null) {
			count++;
			stringBag += sbNode.getInfo() + "\n";
			sbNode = sbNode.getLink();
		}
		return stringBag;
	}

	public String output(int order) {
		StringBagNode node = sbNode;
		int count = 0;
		while (count != order) {
			count++;
			node = node.getLink();
		}
		return node.getInfo();
	}

	public void insert(String element) {
		//
		StringBagNode newNode = new StringBagNode(element);
		newNode.setLink(sbNode);
		sbNode = newNode;
	}

	public boolean isFull() {
		//
		return false;
	}

	public int size() {
		int count = 0;
		StringBagNode node = sbNode;
		while (node != null) {
			count++;
			node = node.getLink();
		}
		return count;
	}

	public String remove() {
		//
		int totalNodes = 1;
		StringBagNode node = sbNode;
		// count will return total number of nodes
		while (node != null) {
			totalNodes++;
			node = node.getLink();
		}
		Random rand = new Random();
		return remove(rand.nextInt(totalNodes) - 1);
	}

	
	public String remove(int kickedout) {
		StringBagNode node = sbNode;
		StringBagNode old_node = sbNode;
		String logString = null;
		int count = 0;
		if (node != null) {
			while (node != null) {
				logString = node.getInfo();
				if (kickedout == 0) {
					node = null;
					if (node.getLink() != null)
						sbNode = node.getLink();
					return logString;
				}
				if (count > 1)
					old_node = old_node.getLink();// will always be one node
													// behind node

				if (count == kickedout && count != 0) {
					// set the link to the node before to the
					if (node.getLink() != null) {
						old_node.setLink(node.getLink());
						node = null;// clear the current node
						sbNode = old_node;
						return logString;
					} else {
						node = null;
						sbNode = old_node;
						return logString;
					}
				}
				count++;
				node = node.getLink();
			}
		} else {
			throw new ArrayIndexOutOfBoundsException(
					"Cannot remove from a location that doesn't exist.");
		}
		return logString;

	}

	public void clear() {
		sbNode = null;
	}

}
