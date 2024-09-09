import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		// Prices for amounts of seven. 1 = 3, 2 = 5 etc.
		int[] winPrices = { 0, 3, 4, 6 };
		
		int[] rolls = new int[3];
		int sevenCount = 0;
		int currency = 0;
		boolean wantToContinue = true;
		String userAnswer;

		// Get starting currency amount from user
		System.out.printf("\nLucky 7\nSyötä rahamäärä: ");
		try {
			currency = in.nextInt();
			in.nextLine(); // Clear line break from Scanner
		} catch (Exception e) {
			System.out.printf("Määrä ei ole kelvollinen. Poistutaan.\n");
			in.close();
			return;
		}

		while (currency > 0 && wantToContinue) {
			currency--;
			sevenCount = 0;

			// Roll numbers
			for (int i = 0; i < rolls.length; i++) {
				int value = random.nextInt(10);
				rolls[i] = value;
				if (value == 7)
					sevenCount++;
			}

			// Add price to currency
			currency += winPrices[sevenCount];

			// Print rolled numbers, did player win & remaining currency
			System.out.printf("\n[%d] [%d] [%d]", rolls[0], rolls[1], rolls[2]);
			if (sevenCount > 0) {
				System.out.printf(" Voitit %d$", winPrices[sevenCount]);
			}
			System.out.printf("\nRahaa jäljellä: %d$\n", currency);

			// Ask if user wants to continue playing
			if (currency > 0) {
				System.out.printf("Paina Enter jatkaaksesi pelaamista ");
				userAnswer = in.nextLine();
				wantToContinue = userAnswer.equals("");
			}
		}

		System.out.printf("Kiitos pelaamisesta!\n");
		in.close();
	}
}
