package com.eco.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 * date:   2018年5月7日 下午9:41:10
 * author: Shixiaodong
 */
public class ReflectUtils {
	
	@SuppressWarnings("rawtypes")
	public static Class getClass(Class clazz) {
		Type type = clazz.getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            return (Class) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            return null; 
        }  
	}
}
