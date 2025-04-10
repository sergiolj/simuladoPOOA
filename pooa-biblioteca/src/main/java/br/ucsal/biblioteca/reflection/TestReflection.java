package br.ucsal.biblioteca.reflection;

import br.ucsal.biblioteca.model.Emprestimo;
import br.ucsal.biblioteca.model.Usuario;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflection {
    public static void main(String[] args) {
//        Class<Usuario> clazz = Usuario.class;
//        System.out.println("Atributos da classe : " + clazz.getSimpleName() + ": ");
//
//        Usuario user = new Usuario("Marcio");
//
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            String modifiersToString = Modifier.toString(field.getModifiers());
//            System.out.println(field.getName() + " : " + field.getType().getSimpleName() + " : " + modifiersToString );
//        }
//        Field.setAccessible(fields, true);
//        ClassInfo.getAttributes(Emprestimo.class);
//
//        System.out.println(user.getNome());
//
//        ClassInfo.forceSetName(user, "nome", "Carla");
//        System.out.println(user.getNome());
//
//        ClassInfo.executePrivateMethod(user);
//        ClassInfo.instantiateNObjects(Usuario.class, 3);
        ClassInfoComplete.getClassInfo(Usuario.class);

    }
}
