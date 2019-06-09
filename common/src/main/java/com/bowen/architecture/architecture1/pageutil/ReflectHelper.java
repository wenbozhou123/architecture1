package com.bowen.architecture.architecture1.pageutil;

import java.lang.reflect.Field;

public class ReflectHelper {

    /**
     * 获取obj对象fieldName的Field
     * @param obj
     * @param fieldName
     * @return
     */
    public static Field getFieldByFieldName(Object obj, String fieldName){
        for(Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()){
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {

            }
        }
        return null;
    }

    /**
     * 获取obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if(field != null){
            if (field.isAccessible()){
                value = field.get(obj);
            }else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    public static void setValueByFieldName(Object obj, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {

        try{
            Field  field = obj.getClass().getDeclaredField(fieldName);
            if(field.isAccessible()){
                field.set(obj, value);
            }else {
                field.setAccessible(true);
                field.set(obj, value);
                field.setAccessible(false);
            }
        }catch (Exception e){

        }

    }


}
