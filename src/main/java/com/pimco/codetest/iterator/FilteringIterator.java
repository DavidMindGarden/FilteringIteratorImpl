package com.pimco.codetest.iterator;

import java.util.Iterator;

/**
 * Created by xiaodongcao on 2/20/17.
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
    private boolean hasNextElement = true;

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
        while(innerIterator.hasNext()){
            if(innerTest.test(nextElement)){
                nextElement = innerIterator.next();
                return;
            }
        }

        nextElement = null;
        hasNextElement = false;
    }

    @Override
    public E next(){
        return nextElement;
    }

    @Override
    public boolean hasNext(){
        return this.hasNextElement;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
