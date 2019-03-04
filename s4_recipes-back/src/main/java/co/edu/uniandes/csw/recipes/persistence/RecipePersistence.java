/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.persistence;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author CesarF
 */

@Stateless
public class RecipePersistence {
    private static final Logger LOGGER = Logger.getLogger(RecipePersistence.class.getName());
    
    @PersistenceContext(unitName = "recipesPU")
    protected EntityManager em;
    
  
    public RecipeEntity find(Long id) {
        return em.find(RecipeEntity.class, id);
    }
    
    //TODO método crear de recipe
    public RecipeEntity create(RecipeEntity re) throws BusinessLogicException {
       if (re.getName().length() > 30 && re.getName().equals("") && re.getName() == null) {
            throw new BusinessLogicException("El nombre no es valido");
        }
        if (re.getDescription().length() > 150 && re.getDescription().equals("") && re.getDescription() == null) {
            throw new BusinessLogicException("La descripcion no es valida");
        }
        if (re.getIngredients() == null && re.getIngredients().size() == 0) {
            throw new BusinessLogicException("debe tener al menos un ingrediente");
        }
        
        em.persist(re);
        
        return re;
    }

}
