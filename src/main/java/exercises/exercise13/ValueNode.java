package exercises.exercise13;

public class ValueNode implements Node {
	public final Integer val;

	public ValueNode(final int valNode) {
		super();
		val = valNode;
	}

	@Override
	public void accept(final VisitorTree t) {
		t.visitValueNode(this);
	}
}
