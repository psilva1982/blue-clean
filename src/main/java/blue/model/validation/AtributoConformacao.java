package blue.model.validation;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import blue.model.validation.validator.AtributoConfirmacaoValidator;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { AtributoConfirmacaoValidator.class })
public @interface AtributoConformacao {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "Atributos não conferem";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String atributo(); 
	
	String atributoConfirmacao();
}
