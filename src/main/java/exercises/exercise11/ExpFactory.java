package exercises.exercise11;

import java.util.Optional;

public class ExpFactory {
	public Optional<ArithmExp> createExp(final String exp) {
		if("mult".equals(exp)) {
			return Optional.of(new Mult());
		}
		if("plus".equals(exp)) {
			return Optional.of(new Plus());
		}
		if("min".equals(exp)) {
			return Optional.of(new Min());
		}
		if("mod".equals(exp)) {
			return Optional.of(new Mod());
		}
		return Optional.empty();
	}
}

public class ExpFactory {
	private final Map<String, CmdExp> map = new HashMap<>();
	public ExpFactory() {
		map= Map.of(
			"mult", new Mult(),
			"plus", new Plus(),
			"min", new Min(),
			"mod", new Mod()
		);
	}
	public Optional<ArithmExp> createExp(final String exp) {
		return Optional.ofNullable(map.getOrDefault(exp, () -> null).get());
	}
}

interface ArithmExp {}
class Mult implements ArithmExp {}
class Plus implements ArithmExp {}
class Min implements ArithmExp {}
class Mod implements ArithmExp {}
