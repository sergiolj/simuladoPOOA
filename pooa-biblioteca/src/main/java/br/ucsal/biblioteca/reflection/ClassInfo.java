package br.ucsal.biblioteca.reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {

    public static void getAttributes(Class<?> clazz) {
        Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int modifiersFlag = field.getModifiers();
            String modifiers = Modifier.toString(modifiersFlag);
            System.out.println(field.getName() + " : " + field.getType().getSimpleName() + " : " + modifiers);
        }
    }

    public static void forceSetName(Object obj, String stringField, String name) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean found = false;
        try {
            for (Field current : fields) {
                if (current.getType() == String.class) {
                    if (current.getName().equals(stringField)) {
                        Field field = clazz.getDeclaredField(stringField);
                        field.setAccessible(true);
                        field.set(obj, name);
                        found = true;
                        break;
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        if (!found) {
            throw new IllegalArgumentException("Field name " + stringField + " not found");
        }
    }

    public static void listPrivateMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Private methods : ");
        for (Method method : methods) {
            if(method.getModifiers()==Modifier.PRIVATE){
                System.out.println(method.getName());
            }
        }
    }
    public static void executePrivateMethod(Object obj) {
        listPrivateMethods(obj);
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a method to execute");
        String chooseMethod = sc.nextLine();
        Class<?> clazz = obj.getClass();
        try {
            Method method = clazz.getDeclaredMethod(chooseMethod);
            method.setAccessible(true);
            method.invoke(obj);
        } catch (NoSuchMethodException e){
            System.out.println(chooseMethod + " method not found.");
        }catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void instantiateNObjects(Class<?> clazz, int numberOfObjects) {
        try {
            Constructor<?> constructor = clazz.getConstructor(String.class);
            for(int i = 0; i < numberOfObjects; i++){
                try {
                    String name = "Object " + (i+1);
                    Object obj = constructor.newInstance(name);
                    System.out.println(obj.getClass().getSimpleName() + " : " + name);

                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
