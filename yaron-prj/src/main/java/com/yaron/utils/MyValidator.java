package com.yaron.utils;




import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MyValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException
    {
        if("bad".equals(value)){
            throw new ValidatorException(new FacesMessage("bad is no good"));

        }

        System.out.println("MyValidator validate: " + value);
    }

}