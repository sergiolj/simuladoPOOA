package br.ucsal.biblioteca.reflection;

import br.ucsal.biblioteca.controller.Biblioteca;

import java.lang.reflect.Field;
import java.util.List;

public class ListUsersConsole {

    public synchronized static void printObjectList(Biblioteca biblioteca, String fieldName) {
        Class<?> clazz = biblioteca.getClass();
        try{
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            //Cria uma lista que eu não sei o tipo e usa o método field.get(instância) para criar
            //os dados da lista usando um casting genérico de (List<?>)
            List<?> list = (List<?>) field.get(biblioteca);
            for (Object object : list) {
                Class<?> objectClass = object.getClass();
                Field[] fields = objectClass.getDeclaredFields();
                for (Field f : fields) {
                    f.setAccessible(true);
                    System.out.print(f.getName() + ": " + f.get(object));
                }
            }
        }catch (NoSuchFieldException e){
            System.out.println("Invalid field name." + e.getMessage());;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
