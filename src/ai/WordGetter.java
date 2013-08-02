package ai;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordGetter {
	public static Set<int[][]> getPlays(char[][] letterBoard, Set<String> dict) {
		HashSet<int[][]> plays = new HashSet<int[][]>();
		for (String word : dict) {
			plays.addAll(canMake(letterBoard, word, 0,
					new int[word.length()][2]));
		}
		return plays;
	}

	private static Set<int[][]> canMake(char[][] letterBoard, String word,
			int index, int[][] play) {
		if (index == word.length()) {
			return new HashSet<int[][]>();
		}
		System.out.println(word);
		System.out.println(index);
		System.out.println(Arrays.toString(play));

		char[] wordarray = word.toCharArray();
		char next = wordarray[index];
		char[][] copyBoard;
		int[][] updatedPlay = play;
		Set<int[][]> plays = new HashSet<int[][]>();
		int ways = 1;

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (letterBoard[i][j] == next) {
					copyBoard = letterBoard;
					copyBoard[i][j] = ' ';
					updatedPlay[index][0] = i;
					updatedPlay[index][0] = j;
					plays.addAll(canMake(copyBoard, word, index + 1,
							updatedPlay));
					copyBoard[i][j] = letterBoard[i][j];
				}

			}
		}

		return plays;
	}
}
