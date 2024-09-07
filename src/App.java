import java.util.Random;

public class App {
	public static void main(String[] args) throws Exception {
		Random random = new Random();

		// Prices for amounts of seven. 1 = 3, 2 = 5 etc.
		int[] winPrices = { 0, 3, 5, 7 };
		int[] rolls = new int[3];
		int winCount;
		int currency = 5;

		while (currency > 0) {
			currency--;
			winCount = 0;

			// Roll numbers
			for (int i = 0; i < rolls.length; i++) {
				int value = random.nextInt(10);
				rolls[i] = value;
				if (value == 7)
					winCount++;
			}

			// Add price to currency
			currency += winPrices[winCount];

			System.out.printf("\no-- Lucky 7 --o\n| [%d] [%d] [%d] |\no-------------o\n", rolls[0], rolls[1], rolls[2]);

			if (winCount > 0) {
				System.out.printf("|  Voitit %d$  |\no-------------o\n", winPrices[winCount]);
			} else {
				System.out.printf("|   Hävisit!  |\no-------------o\n");
			}
		}
	}
}
