package a3jedi;

import java.util.Scanner;

public class A3Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int noIng = s.nextInt();
		Ingredient[] ing = new IngredientImpl[noIng];
		for (int i = 0; i < ing.length; i++) {
			ing[i] = new IngredientImpl(s.next(),s.nextDouble(),s.nextBoolean(),s.nextInt());
		}

		int noRecipes = s.nextInt();
		MenuItem[] recipes = new MenuItemImpl[noRecipes];
		for (int i = 0; i < noRecipes; i++) {
			String recipe_name = s.next();
			int no_ing = s.nextInt();
			IngredientPortion[] portion = new IngredientPortion[no_ing];
			for (int j = 0; j < no_ing; j++) {
				portion[j] = new IngredientPortionImpl(ing[isEqual(ing, s.next())], s.nextDouble());
			}
			recipes[i] = new MenuItemImpl(recipe_name, portion);
		}

		IngredientPortion[] answerKey = new IngredientPortionImpl[noIng];
		for (int i = 0; i < noIng; i++) {
			answerKey[i] = new IngredientPortionImpl(ing[i], 0);
		}

		String order = s.next();
		while (!order.equals("EndOrder")) {
			for (int i = 0; i < noRecipes; i++) {
				if (order.equals(recipes[i].getName())) {
					for (int j = 0; j < recipes[i].getIngredients().length; j++) {
						int index = isEqual(ing, recipes[i].getIngredients()[j].getName());
						answerKey[index] = answerKey[index].combine(recipes[i].getIngredients()[j]);
					}
				}
			}
			order = s.next();
		}
		System.out.println("The order will require:");
		for (int i = 0; i < answerKey.length; i++) {
			System.out.println(((int) ((answerKey[i].getAmount() * 100.0) + 0.5))/100.0 + " ounces of " + answerKey[i].getName());
		}
	}


		
	public static int isEqual(Ingredient[] ing , String name) {
		int isEquals = 0;
		for (int i = 0; i < ing.length; i++) {
			if (ing[i].getName().equals(name)) {
				isEquals = i;
			} 
		}
		return isEquals;
	}
}
