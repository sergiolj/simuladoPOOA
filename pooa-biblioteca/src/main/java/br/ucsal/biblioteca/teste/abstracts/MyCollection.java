package br.ucsal.biblioteca.teste.abstracts;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection <E> extends AbstractCollection<E> {
    private Object[] elements;
    private int size;
    private final Class<E> elementClass;

    public MyCollection(Class<E> elementClass) {
        this.elementClass = elementClass;
        elements = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if(!isValid(element)) return false;
        ensureSpace();
        elements[size++] = element;
        return true;
    }

    public boolean isValid(E element) {
        if(!elementClass.isInstance(element)){
            throw new IllegalArgumentException("Tipo inválido para a lista" + elementClass.getName());
        }
        return true;
    }

    private void ensureSpace() {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /*
    O Método iterator() faz parte da super interface de Collection, ou seja, AbstractCollecion é uma classe abstrata que
    implementa Collection e Collection, por sua vez, extends Iterable que é outra interface, Collecion é subclasse de
    Iterable.
    A interface Iterable define três métodos, entre eles o iterator() que retorna um objeto Iterator<E>, que é uma outra
    interface que define alguns métodos como hasNext() next() e remove()
     */
    @Override
    public Iterator<E> iterator() {
        //Instancia uma classe anônima new Iterator<E>() que implementa uma interface {boolean hasNext(){} E next(){}};.
            return new Iterator<E>() {
                private int cursor = 0;

                @Override
                public boolean hasNext() {
                    return cursor < size;
                }
                //O compilador está avisando que ele não tem como garantir que o objeto retornado será um E, ele só pode
                //garantir que será um Object. O usuário tem que assegurar o tipo certo.
                @Override
                public E next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    return (E) elements[cursor++];
                }
            };
        }

    @Override
    public int size() {
        return this.size;
    }
}
