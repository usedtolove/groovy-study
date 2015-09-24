package com.tz.javafx.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by hjl on 2015/9/23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface IsAge {

    /**
     * message
     */
//    String message() default "invalid.age";
    String message() default "无效的年龄";

    /**
     * groups
     */
    Class<?>[] groups() default {};

    /**
     * payload
     */
    Class<? extends Payload>[] payload() default {};

}
