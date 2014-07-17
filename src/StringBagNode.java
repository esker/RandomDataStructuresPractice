
public class StringBagNode {
	private String info;
	private StringBagNode link;
	
	public StringBagNode(String info){
		this.setInfo(info);
		setLink(null);
	}

	public StringBagNode getLink() {
		return link;
	}

	public void setLink(StringBagNode link) {
		this.link = link;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
