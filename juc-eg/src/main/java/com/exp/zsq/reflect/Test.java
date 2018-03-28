package com.exp.zsq.reflect;


import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by zhaoshengqi on 2017/12/21.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        DxsDailyStatistics from = new DxsDailyStatistics();
        DxsDailyStatistics to = new DxsDailyStatistics();

        from.setPreferentialTotal(new BigDecimal(20.1));
        from.setRecieveTotal(new BigDecimal(100.3));
        from.setNeedTotal(new BigDecimal(20));
        from.setChargeNum(50000);

        to.setPreferentialTotal(new BigDecimal(100));
        to.setRecieveTotal(new BigDecimal(10));
        to.setNeedTotal(new BigDecimal(20));
        to.setChargeNum(50000);

        addMathProperty(from,to);
        System.out.println(to.toString());
    }

    public static final <T> void addMathProperty(T from, T to) throws Exception {

        Class<T> fClazz = (Class<T>) from.getClass();
        Class<T> tClazz = (Class<T>) to.getClass();

        if (fClazz != tClazz){
            return;
        }
        Field[] toFields = tClazz.getDeclaredFields();

        //遍历目标对象Field
        for (int i = 0; i < toFields.length; i++) {
            Field toField = toFields[i];
            toField.setAccessible(true); //设置些属性是可以访问的

            //String toType = toField.getType().toString();//获取目标字段类型
            String toName = toField.getName();
            Field fromFild = fClazz.getDeclaredField(toName);//源对象Field
            fromFild.setAccessible(true);
            //目标方法
            Method toMethod = tClazz.getMethod("get" + getMethodName(toField.getName()));
            //源方法
            Method fromMethod = tClazz.getMethod("get" + getMethodName(fromFild.getName()));

            if (toField.getType() == BigDecimal.class){
                //String fromType = fromFild.getType().toString();
                //目标值
                BigDecimal toVal = (BigDecimal) toMethod.invoke(to);
                //源值
                BigDecimal fromVal = (BigDecimal) fromMethod.invoke(from);

                //计算
                BigDecimal value = fromVal.add(toVal);
                toField.set(to,value);
            }else if (toField.getType() == Integer.class){
                Integer toVal = (Integer) toMethod.invoke(to);
                Integer fromVal = (Integer) fromMethod.invoke(from);

                toField.set(to,toVal + fromVal);
            }

        }

    }

    // 把一个字符串的第一个字母大写
    private static String getMethodName(String fieldName) throws Exception{
        //Introspector
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }


}
