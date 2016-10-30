package scene.nodes;

/**
 * The RootNode is the most upper node in the scene graph.
 */
public class RootNode extends ContainerNode {

	public RootNode() {
		this(null);
	}

	public RootNode(Node parent) {
		super(parent);
	}
}
