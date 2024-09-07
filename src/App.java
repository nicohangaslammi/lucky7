import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		// Prices for amounts of seven. 1 = 3, 2 = 5 etc.
		int[] winPrices = { 0, 3, 5, 7 };
		int[] rolls = new int[3];
		int winCount;
		int currency;
		boolean wantToContinue = true;
		String answer;

		System.out.printf("\nLucky 7\nSyötä rahamäärä: ");
		currency = in.nextInt();
		in.nextLine(); // clear line break from Scanner

		while (currency > 0 && wantToContinue) {
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

			System.out.printf("\n[%d] [%d] [%d]", rolls[0], rolls[1], rolls[2]);

			if (winCount > 0) {
				System.out.printf(" Voitit %d$", winPrices[winCount]);
			}

			System.out.printf("\nRahaa jäljellä: %d$\n", currency);

			if (currency > 0) {
				System.out.printf("Paina Enter jatkaaksesi pelaamista ");
				answer = in.nextLine();
				wantToContinue = answer.equals("");
			}
		}

		System.out.printf("Kiitos pelaamisesta!\n");
	}
}
