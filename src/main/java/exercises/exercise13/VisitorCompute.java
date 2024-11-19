package exercises.exercise13;

import java.util.ArrayDeque;
import java.util.Deque;

public class VisitorCompute implements VisitorTree {
    final Deque<Double> values = new ArrayDeque<>();

    @Override
    public void visitTree(Tree tree) {
        values.clear();
        tree.root.accept(this);
        System.out.println("calcul :" + values.pop());
    }

    @Override
    public void visitPlusNode(PlusNode n) {
        n.leftNode.accept(this);
        n.rightNode.accept(this);
        values.push(values.pop() + values.pop());
    }

    @Override
    public void visitSubNode(SubNode n) {
        n.leftNode.accept(this);
        n.rightNode.accept(this);
        double val1 = values.pop();
        double val2 = values.pop();
        values.push(val2 - val1);
    }

    @Override
    public void visitValueNode(ValueNode n) {
        values.push((double)n.val);
    }
}
