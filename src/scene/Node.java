package scene;

import java.util.List;

public class Node {
	private Node parentNode;
	
	private List<Node> childNodes;
	
	private boolean visibility = true;
	
	public Node(Node parent) {
		this.parentNode = parent;
	}
	
	public void addChildNode(Node child) {
		childNodes.add(child);
	}
	
	public void removeChildNode(Node child) {
		childNodes.remove(child);
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	public void cascadingPaint() {
		
	}
	
}
