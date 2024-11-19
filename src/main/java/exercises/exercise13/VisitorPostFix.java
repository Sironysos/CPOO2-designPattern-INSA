package exercises.exercise13;
//Implémentez en Java un visiteur permettant d’afficher dans la console et en notation post-fixée la formule arithmétique que représente l’arbre
public class VisitorPostFix implements VisitorTree {
	@Override
	public void visitTree(final Tree tree) {
		System.out.println("Visit arbre " + tree.name);
		tree.root.accept(this);
	}

	@Override
	public void visitPlusNode(final PlusNode n) {
		n.leftNode.accept(this);
		n.rightNode.accept(this);
		System.out.print(" +");
	}

	@Override
	public void visitSubNode(final SubNode n) {
		n.leftNode.accept(this);
		n.rightNode.accept(this);
		System.out.print(" -");
	}

	@Override
	public void visitValueNode(final ValueNode n) {
		System.out.print(" "+n.val);
	}
}
