package insa.proxy.lazyexample;

public class AImpl implements A {
	private B b;

	public AImpl() {
		super();
		b = new B();
	}

	@Override
	public B getB() {
		return b;
	}
}