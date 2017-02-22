package com.pimco.codetest.iterator;

import java.util.Iterator;

/**
 * Created by xiaodongcao on 2/20/17.
 */
public class FilteringIterator {

    private Iterator innerIterator;
    private IObjectTest innerTest;

    public FilteringIterator(Iterator myIterator, IObjectTest myTest){
        this.innerIterator = myIterator;
        this.innerTest = myTest;
    }

    public void next(){

    }

    public boolean hasNext(){

        return true;
    }

    public void remove(){

    }
}
