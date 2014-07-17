
public class LLStringNode{
	private String info;
	private LLStringNode link;
	
	public LLStringNode(String info){
		this.setInfo(info);
		setLink(null);
	}

	public String getInfo() {
		return info;
	}

	public LLStringNode getLink() {
		return link;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setLink(LLStringNode link) {
		this.link = link;
	}
}
