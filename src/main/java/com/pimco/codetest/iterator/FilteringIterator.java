package com.pimco.codetest.iterator;

import java.util.Iterator;

/**
 * Created by xiaodongcao on 2/21/17.
 *
 * Decorator design pattern
 * To override iterator methods using wrapped iterator
 * 1. next()
 * 2. hasNext()
 * 3. remove()
 */

public class FilteringIterator<E> implements Iterator<E> {

    private Iterator<E> innerIterator;
    private IObjectTest<E> innerTest;
    private E nextElement;

    /**
     * Create a new FilteringIterator with another Iterator and IObjectTest
     *
     * @param myIterator
     *      iterator instance
     *
     * @param myTest
     *     IObjectTest instance
     */
    public FilteringIterator(Iterator<E> myIterator, IObjectTest<E> myTest){
        this.innerIterator = myIterator;
        this.innerTest = myTest;

        initFilteringIterator();
    }

    /**
     * Find the header that pass the object test
     */
    private void initFilteringIterator(){
        findNextElement();
    }

    /**
     * Find the next qualified elements
     */
    private void findNextElement(){
        while(innerIterator.hasNext()){
            nextElement = innerIterator.next();
            if(innerTest.test(nextElement)){
                return;
            }
        }

        nextElement = null;
    }

    @Override
    public E next(){
        E currentValue = nextElement;
        findNextElement();
        return currentValue;
    }

    @Override
    public boolean hasNext(){
        return this.nextElement != null;
    }

    /**
     * Always throws UnsupportedOperationException as this class does look-ahead with its internal iterator.
     */
    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
