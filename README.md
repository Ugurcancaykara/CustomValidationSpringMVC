# CustomValidation-SpringMVC
Custom Validation Message Usage

I use IntelliJ Idea and created my Spring MVC project with Maven.

Hints:

1)add to your servlet.xml (mine is HelloWeb-servlet.xml) (create a bean)
  in <bean></bean> tags
 id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
  and use this property 
  <property name="basenames" value="messages"/>
  (Important thing is that file must be under of resources directory, you will see it in next steps)


2)at src/main/java/com.example/ directory create a folder named validation  

3)Create an new java annotation file in (src/main/directory/validation) and give a name
and Fill inside it with below code. 

package com.example.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    String value() default "LUV";

    //define dafult error message
    String message() default "must start with LUV";

    //define default groups
    //Groups: can group related constraints
    Class<?>[] groups() default {};

    //define default payloads
    //provide custom details about validation failure
    //severity level, error code etc.
    Class<? extends Payload>[] payload() default {};

}

4)Create a ConstraintValidator => basically this file holds the logical side of your validation.

package com.example.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(s != null){
            result = s.startsWith(coursePrefix);
        }
        else{
            result = true;
        }
        return result;
    }
}

5) create messages.properties in src/main/resources and add following lines 
typeMismatch.customer.freePasses=Invalid number
6) Now you can use as like I did in Customer model class in src/main/java/com.example

Tip:
If you don't know your custom message's error type then you can use @BindingResult annotation like I did in CustomerController class


    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult){



        //when we are creating custom messages
        //we can make inputs break their rules then we can look at to error trace
        //and then we can use that error type to make use of our custom errors = in
        //in /resources/messages.properties (don't forget to create bean for messages)
        System.out.println("Binding result: "+theBindingResult);

        System.out.println("\n\n\n\n");
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }


    }


