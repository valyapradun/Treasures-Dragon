package com.epam.training.treasury.view;

import java.util.Scanner;

import com.epam.training.treasury.controller.Controller;

public class Menu {
	private static final int EXIT = 5;

	public void welcomScreen() {
		System.out.println("You can do it: ");
		System.out.println("1 - To find the most expensive treasure");
		System.out.println("2 - To find all helmets");
		System.out.println("3 - To find treasures with price 100 ... 300 BYN");
		System.out.println("4 - To find the treasures made of steel");
		System.out.println("5 - Exit");
		System.out.print("Yours choise: ");
	}

	public void inputNumberMenu() {
		Scanner sc = new Scanner(System.in);
		int numberOperation = sc.nextInt();
		if (numberOperation == EXIT) {
			System.out.println("Good bye!");
		} else {
			System.out.println(new Controller().executeTask(numberOperation));
			welcomScreen();
			inputNumberMenu();
		}
		if (sc != null) {
			sc.close();
		}
	}

}
