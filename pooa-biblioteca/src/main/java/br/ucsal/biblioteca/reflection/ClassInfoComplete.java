package br.ucsal.biblioteca.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInfoComplete {

    public static void getClassInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Class Name: " + clazz.getSimpleName());
        System.out.println("\nFields:");
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName() + " : " + Modifier.toString(field.getModifiers()));
        }
        System.out.print("\nMethods:");
        getMethodParameter(clazz);

        System.out.print("\nConstructors:");
        getConstructorParameter(clazz);
    }

    public static void getMethodParameter(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            sb.append("\n").append(modifier).append(" ");
            sb.append(method.getName()).append(" ");
            Class<?>[] classes = method.getParameterTypes();
            sb.append("(");
            for (Class<?> classParameter : classes) {
                sb.append(classParameter.getSimpleName());
            }
            sb.append(")");
        }
        System.out.println(sb.toString());
    }

    public static void getConstructorParameter(Class<?> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        StringBuilder sb = new StringBuilder();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());
            sb.append("\n").append(modifier).append(" ");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            sb.append("(");
            for (Class<?> paramType : paramTypes) {
                sb.append(paramType.getSimpleName());
            }
            sb.append(")");
        }
        System.out.println(sb.toString());
    }
}
