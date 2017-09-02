package com.techiekunal.codepractice.dzone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Singleton singleton = Singleton.INSTANCE;
        
		Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        
        Singleton singleton2 = (Singleton) constructor.newInstance();
        
        if (singleton.equals(singleton2)) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        singleton.setValue(1);
        singleton2.setValue(2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
	}

}
