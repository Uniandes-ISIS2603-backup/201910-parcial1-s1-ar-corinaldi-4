/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.dtos;

import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CesarF
 */
public class RecipeDetailDTO extends RecipeDTO {
    
    public RecipeDetailDTO(){
    
    }
    
    private List<IngredientDTO> ingredients;
    
    /**
     *
     * @param recipeEntity
     */
    public RecipeDetailDTO(RecipeEntity recipeEntity) {
        super(recipeEntity);
        if (recipeEntity != null) {
            ingredients = new ArrayList<>();
            for (IngredientEntity ing : recipeEntity.getIngredients()) {
                ingredients.add(new IngredientDTO(ing));
            }
        }
    }

    /**
     * @return the ingredients
     */
    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
    
}
