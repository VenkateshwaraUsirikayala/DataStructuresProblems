package org.perfios.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeAmountUsingCoins {

	public int numberOfWays(int total, int array[]) {

		int temp[] = new int[total + 1];

		temp[0] = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= array[i]) {
					temp[j] += temp[j - array[i]];
				}
			}
		}
		return temp[total];
	}

	public void waysOfChanging(int total, int coins[]) {
		List<Integer> result = new ArrayList<>();
		wayOfChanges(result, total, coins, 0);
	}

	private void wayOfChanges(List<Integer> result, int total, int coins[], int pos) {
		if (total == 0) {
			for (int r : result) {
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for (int i = pos; i < coins.length; i++) {
			if (total >= coins[i]) {
				result.add(coins[i]);
				wayOfChanges(result, total - coins[i], coins, i);
				result.remove(result.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		ChangeAmountUsingCoins cc = new ChangeAmountUsingCoins();
		System.out.println("Enter the total");
		int total = input.nextInt();
		System.out.println("Enter the number of coins(not the coin values, but the total count of coins(like 3 coins, 5 coins etc.,)");
		int numberOfCoins = input.nextInt();
		int[] coins = new int[numberOfCoins];
		System.out.println("Enter the " + numberOfCoins + " coin values");
		for (int i = 0; i < numberOfCoins; i++) {
			coins[i] = input.nextInt();
		}
		System.out.println(cc.numberOfWays(total, coins));
		System.out.println("The Ways are : ");
		cc.waysOfChanging(total, coins);
	}
}
