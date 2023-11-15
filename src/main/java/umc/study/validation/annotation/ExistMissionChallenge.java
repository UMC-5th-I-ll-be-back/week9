package umc.study.validation.annotation;

import umc.study.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMissionChallenge {
    String message() default "이 미션은 이미 도전중인 미션입니다. ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
