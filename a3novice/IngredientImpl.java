package a3novice;

public class IngredientImpl implements Ingredient {
	
	
	private String name;
	private boolean is_vegetarian;
	private double price;
	private int calories;
	
	
	public IngredientImpl (String name, double price, boolean is_vegetarian, int calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
		if (name == null) {
			throw new RuntimeException("Name parameter is null!");
		}
		if (price < 0.0) {
			throw new RuntimeException("Price parameter is negative!");
		}
		if(calories < 0.0) {
			throw new RuntimeException("Calories parameter is negative!");
		}
		
	}
	
public String getName() {
	return name;
}

public boolean getIsVegetarian() {
	return is_vegetarian;
}
public double getPricePerOunce() {
	return price;
}
public int getCaloriesPerOunce() {
	return calories;
}
public double getPricePerDollar() {
	return calories/price;
}
}
