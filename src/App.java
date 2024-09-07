import java.util.Random;

public class App {
	public static void main(String[] args) throws Exception {
		Random random = new Random();

		int[] rolls = new int[3];
		boolean win = false;

		for (int i = 0; i < rolls.length; i++) {
			int value = random.nextInt(10);
			rolls[i] = value;
			if (value == 7)
				win = true;
		}

		System.out.printf("\no-- Lucky 7 --o\n| [%d] [%d] [%d] |\no-------------o\n", rolls[0], rolls[1], rolls[2]);

		if (win) {
			System.out.printf("|   Voitit!   |\no-------------o\n");
		} else {
			System.out.printf("|   Hävisit!  |\no-------------o\n");
		}
	}
}
