package com.mycompany.demo;

import java.lang.reflect.Field;

public class Main 
{
    public static void main(String[] args) throws Exception {
        SomeClass someObj = new SomeClass();
        Class<SomeClass> someClassAsClass= (Class<SomeClass>)someObj.getClass();
        Field[] fields = someClassAsClass.getFields();
        
        for( Field fld : fields)
        { System.out.println(fld.getType()+" - "+ fld.getName()); }
        
        //
        Field someField=someClassAsClass.getField("someField");
        System.out.println(someObj.someField);
        someField.setInt(someObj, 105);
        System.out.println(someObj.someField); System.out.println("");
        //
        //
        //
        Field privateField=someClassAsClass.getDeclaredField("somePrivate");
        System.out.println(privateField.getName());
        privateField.setAccessible(true);
        privateField.set(someObj, "Alexei");
        System.out.println( someObj.getSomePrivate() );
    }
}
