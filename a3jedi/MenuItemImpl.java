package a3jedi;

public class MenuItemImpl implements MenuItem{

	private String name;
	private IngredientPortion[] ingredients;
	
	public MenuItemImpl(String name,IngredientPortion[] ingredients) {
		if (name.equals(null)) {
			throw new RuntimeException("Name parameter is null!");
		}
		this.name = name;
		
		if (ingredients.equals(null)) {
			throw new RuntimeException("Ingredients parameter is null!");
		}
		if (ingredients.length == 0) {
			throw new RuntimeException("Ingredients parameter length is zero!");
		}
		this.ingredients = ingredients;
	}
	
	
	public String getName() {
		return name;
	}
	
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}
	
	public int getCalories() {
		double calories = 0;
		for (int i = 0; i < ingredients.length; i++) {
			calories += ingredients[i].getCalories();
		}
		return (int) (calories + 0.5);
	}
	
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < ingredients.length; i++) {
			cost += ingredients[i].getCost();
		}
		return ((int) ((cost * 100.0) + 0.5))/100.0;
	}
	
	public boolean getVegetarian() {
		for (int i = 0; i < ingredients.length; i++) {
			if (!ingredients[i].getIsVegetarian()) {
				return false;
			} 
		}
		return true;
	}
}
