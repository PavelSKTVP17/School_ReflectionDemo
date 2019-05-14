package com.mycompany.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Scanner scnr= new Scanner(System.in);
        String className=scnr.next();
        Class aClass=Class.forName(className); //com.mycompany.classes.Human
        
        Field[] flds=aClass.getFields();
        for( Field fld : flds)
        { System.out.println(fld.getType()+" - "+ fld.getName()); }
        
        Class types[]=new Class[flds.length];
        
        for (int i = 0; i < flds.length; i++) 
        {
            types[i]=flds[i].getType();
        }
        Constructor constr = aClass.getDeclaredConstructor(types);
        
        for (Class parameterType : constr.getParameterTypes())
        {    System.out.print(parameterType.getName()+" "); } System.out.println("");
        
        Integer intValue=0;
        String stringValue="";
        for (int i = 0; i < types.length; i++) 
        {
            if( types[i].getName().equals("int") )
            {
                intValue=scnr.nextInt();
            }
            else if(types[i].getName().equals("java.lang.String") )
            {
               stringValue=scnr.next();
            }
        }
        Object arguments[] = {intValue,stringValue};
        Object obj = constr.newInstance(arguments);
        System.out.println(obj);
    }
}
