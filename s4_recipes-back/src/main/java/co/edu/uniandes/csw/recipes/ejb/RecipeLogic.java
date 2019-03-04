/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.ejb;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author CesarF
 */
@Stateless
public class RecipeLogic {

    @Inject
    private RecipePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RecipeEntity getRecipe(Long id) {
        return persistence.find(id);
    }

    public RecipeEntity createRecipe(RecipeEntity recipe) throws BusinessLogicException {
        RecipeEntity re = persistence.create(recipe);
        if (re.getName().length() > 30 && re.getName().equals("") && re.getName() == null) {
            throw new BusinessLogicException("El nombre no es valido");
        }
        if (re.getDescription().length() > 150 && re.getDescription().equals("") && re.getDescription() == null) {
            throw new BusinessLogicException("La descripcion no es valida");
        }
        if (re.getIngredients() == null && re.getIngredients().size() == 0) {
            throw new BusinessLogicException("debe tener al menos un ingrediente");
        }
        return re;
    }

}
