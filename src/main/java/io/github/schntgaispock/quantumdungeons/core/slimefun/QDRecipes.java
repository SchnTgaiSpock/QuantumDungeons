package io.github.schntgaispock.quantumdungeons.core.slimefun;

import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDRecipes {

    private static class QDRecipeType extends RecipeType {

        public QDRecipeType(String key, ItemStack item) {
            super(QuantumDungeons.newNamespacedKey(key), item);
        }
    
    }

    public static final RecipeType KILLING = new QDRecipeType("killing", QDStacks.RECIPE_KILLING);
    public static final RecipeType REFLECTING = new QDRecipeType("reflecting", QDStacks.RECIPE_REFLECTING);
    public static final RecipeType MOULDING = new QDRecipeType("moulding", QDStacks.RECIPE_MOULDING);
    public static final RecipeType LOOTING = new QDRecipeType("looting", QDStacks.RECIPE_LOOTING);
    public static final RecipeType MENDING = new QDRecipeType("mending", QDStacks.RECIPE_MENDING);
    public static final RecipeType BOOSTING = new QDRecipeType("boosting", QDStacks.RECIPE_BOOSTING);

    public static ItemStack[] single(ItemStack item) {
        ItemStack[] recipe = new ItemStack[9];
        recipe[5] = item;
        return recipe;
    }
    
    public static ItemStack[] catalyst(ItemStack catalyst, ItemStack... items) {
        ItemStack[] recipe = QDRecipes.collection(items, 6);
        
        recipe[7] = catalyst;
        return recipe;
    }
    
    public static ItemStack[] collection(ItemStack... items) {
        return QDRecipes.collection(items, 9);
    }
    
    private static ItemStack[] collection(ItemStack[] items, int maxLength) {
        ItemStack[] recipe = new ItemStack[9];

        int l = Math.min(items.length, maxLength);
        for (int i = 0; i < l; i++) {
            recipe[i] = items[i];
        }
        return recipe;
    }
    
}
