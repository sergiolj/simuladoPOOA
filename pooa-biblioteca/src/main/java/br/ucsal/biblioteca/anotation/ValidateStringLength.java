package br.ucsal.biblioteca.anotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateStringLength {
    int min () default 3;
}
