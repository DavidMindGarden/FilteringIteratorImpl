package com.pimco.codetest.iterator;

/**
 * Created by xiaodongcao on 2/21/17.
 */
public class SimpleIObjectTestImpl implements IObjectTest<Integer>{

    public boolean test(Integer m){
        if(m.intValue() >= 3 && m.intValue() <8){
            return true;
        }else{
            return false;
        }
    }
}
