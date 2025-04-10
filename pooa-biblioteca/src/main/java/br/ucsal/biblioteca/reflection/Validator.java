package br.ucsal.biblioteca.reflection;

import br.ucsal.biblioteca.anotation.ValidateStringLength;

import java.lang.reflect.Field;

public class Validator {

    public static boolean validateFields(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidateStringLength.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(object);
                    if (value instanceof String str) {
                        int min = field.getAnnotation(ValidateStringLength.class).min();
                        if (str.length() < min) {
                            return false;
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }
}
