package exercises.exercise2;

import java.util.Arrays;
import java.util.Optional;

public enum ColourCard {
	SPADE, CLUB, HEART, DIAMOND;
	
	// regardez la belle méthode de fabrique
	public static ColourCard createCard(String colour) {
		for (ColourCard c : ColourCard.values()) {
			if (c.name().equals(colour)) {
				//Le if est mieux dans ce sens que color.equals(c.name()) 
				//car colour peut être null
				//ce qui appelle equals ne peut pas être null
				return c;
			}
		}
		return null;
	}
}
public enum ColourCard2 {
	SPADE, CLUB, HEART, DIAMOND;
	
	public static Optional<ColourCard2> getColourCard(String colour) {
		return Arrays
			.stream(ColourCard2.values())
			.filter(c -> c.name().equals(colour))
			.findFirst();
	}
}
