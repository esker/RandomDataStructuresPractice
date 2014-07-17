public class LLNode<T> {
	private LLNode link;
	private T info;

	public LLNode(T info) {
		this.setInfo(info);
	}
	// two getters, two setters

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public LLNode getLink() {
		return link;
	}

	public void setLink(LLNode link) {
		this.link = link;
	}
}