package com.pimco.codetest.iterator;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by xiaodongcao on 2/21/17.
 */
public class SimpleFilteringIteratorTest {

    private IObjectTest myTest;
    private Collection testList;
    private Iterator myIterator;
    private Iterator testIterator;

    @Before
    public void setup(){
        testList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        myTest = new SimpleIObjectTestImpl();
        myIterator = testList.iterator();
        testIterator = new FilteringIterator(myIterator, myTest);
    }


    @Test
    public void testHasNext(){
        // 3
        Assert.assertTrue(testIterator.hasNext());
        testIterator.next();

        // 4
        Assert.assertTrue(testIterator.hasNext());
        testIterator.next();

        // 5
        Assert.assertTrue(testIterator.hasNext());
        testIterator.next();

        // 6
        Assert.assertTrue(testIterator.hasNext());
        testIterator.next();

        // 7
        Assert.assertTrue(testIterator.hasNext());
        testIterator.next();

        // null
        Assert.assertFalse(testIterator.hasNext());
    }

    @Test
    public void testNext(){
        Assert.assertEquals(3, testIterator.next());
        Assert.assertEquals(4, testIterator.next());
        Assert.assertEquals(5, testIterator.next());
        Assert.assertEquals(6, testIterator.next());
        Assert.assertEquals(7, testIterator.next());
        Assert.assertNull(testIterator.next());
    }

    @Test
    public void testEmpty(){

    }
}
