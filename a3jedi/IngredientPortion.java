package a3jedi;

public interface IngredientPortion {
	
	public Ingredient getIngredient();
	public double getAmount();
	public String getName();
	public boolean getIsVegetarian();
	public double getCalories();
	public double getCost();
	
	IngredientPortion combine(IngredientPortion other);

}
