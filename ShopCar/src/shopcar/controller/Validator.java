/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.controller;

import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;


/**
 *
 * @author info1
 * @param <T>
 */
public class Validator<T>
{   
   private static javax.validation.Validator validator;

    public Validator()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    public String Validate(T entity)
    {
        StringBuilder sBuilder = new StringBuilder();
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) 
        {
            
            for (ConstraintViolation violation : violations) 
            {
                sBuilder.append(violation.getMessage()).append("\n");
            }
            return sBuilder.toString();
        }
        else
            return null;
    }
    
    public String Validate(T entity, String property)
    {
        StringBuilder sBuilder = new StringBuilder();
        Set<ConstraintViolation<T>> violations = validator.validateProperty(entity, property);
        if(!violations.isEmpty())
        {
            for (ConstraintViolation violation : violations) 
            {
                sBuilder.append(violation.getMessage());
            }
            return sBuilder.toString();
        }
        else
            return null;
    }
}
