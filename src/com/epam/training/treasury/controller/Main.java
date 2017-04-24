package com.epam.training.treasury.controller;

import com.epam.training.treasury.view.Menu;

public class Main {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.welcomScreen();
		menu.inputNumberMenu();
	}
}