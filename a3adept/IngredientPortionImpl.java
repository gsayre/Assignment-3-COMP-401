package a3adept;

public class IngredientPortionImpl implements IngredientPortion{
	
	private Ingredient ing;
	private double amount;

	public IngredientPortionImpl(Ingredient ing, double amount) {
		if(ing.equals(null)) {
			throw new RuntimeException("Ingredient parameter is null!");
		}
		this.ing = ing;
		
		if(amount < 0) {
			throw new RuntimeException("Amount parameter is negative!");
		}
		this.amount = amount;
	}
	
	public Ingredient getIngredient() {
		return ing;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getName() {
		return ing.getName();
	}
	
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}
	
	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}
	
	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		return new IngredientPortionImpl(this.ing,this.amount + other.getAmount());
	}
}
