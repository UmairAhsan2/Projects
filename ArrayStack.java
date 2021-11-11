package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.LIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See cse332/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {

    private int default_capacity = 10; // default capacity of the array
    private E[] array; // the array to be constructed
    private int size = 0; // the initial size of the ArrayStack

    //construct the array of the default capacity
    public ArrayStack() {

        this.array = (E[])new Object[default_capacity];
    }

    @Override
    public void add(E work) {
        // if the array isn't full, add work at size and increment size
        if(size != array.length) {
            array[size] = work;
            size++;
        }
        // otherwise if array is full
        // copy elements of old array into new, double sized array and set old array equal to new
        // then make the next element the 'work' parameter and increment size.
        else {
            int old_length = size; // store the old size
            E[] new_array = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                new_array[i] = array[i];
            }
            array = new_array; // make the old array = the new array
            array[old_length] = work; // add work to the next element
            size++; // increment the size
        }
    }
    @Override
    // returns lastly added element
    public E peek() {
        // if array is empty, throw exception
        if (!hasWork()){
            throw new NoSuchElementException();
        }
        // otherwise return the lastly added element.
        return array[size - 1];
    }
    @Override
    // returns and removes the element lastly added.
    public E next() {
        // if array is empty, throw exception
        if (!hasWork()){
            throw new NoSuchElementException();
        }
        E var = array[size - 1]; // store the lastly added element
        size--; // decrement the size and remove the element lastly added.
        return var; // return the recently removed element
    }
    @Override
    // return the current size of the ArrayStack
    public int size() {
        return size;
    }

    @Override
    // make the array to how it was when constructed
    // reset size to 0
    public void clear() {
        this.array = (E[])new Object[default_capacity];
        size = 0;
    }
}
