package com.xiaoyu.common;

import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.service.transform.TypeHandler;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.vo.transform.PlanTransform;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 实体类型转换
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 9:14
 */
public class Transform<T, S> {

    public static final String method_set = "set";
    public static final String method_get = "get";

    @Autowired
    private List<TypeHandler> typeHandlerList;

    /**
     * 将实体相关字段转成String
     *
     * @param typeEntity   不同类型字段实体
     * @param stringEntity String字段实体
     * @return String字段实体
     */
    public S transformEntityTypeToString(T typeEntity, S stringEntity) {
        Class<?> stringClass = stringEntity.getClass();
        Class<?> typeClass = typeEntity.getClass();
        Field[] typeFields = typeClass.getDeclaredFields();
        for (Field field : typeFields) {
            String setMethodName = method_set + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            String getMethodName = method_get + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            try {
                Method setMethod = stringClass.getDeclaredMethod(setMethodName, String.class);
                Method getMethod = typeClass.getDeclaredMethod(getMethodName);
                Object typeValue = stringTransform(getMethod.invoke(typeEntity), field.getType().getSimpleName());
                if (typeValue == null) continue;
                setMethod.invoke(stringEntity, String.valueOf(typeValue));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return stringEntity;
    }

    /**
     * 将实体String字段转成对应类型
     *
     * @param stringEntity String字段实体
     * @param typeEntity   不同类型字段实体
     * @return 不同类型字段实体
     */
    public T transformEntityStringToType(S stringEntity, T typeEntity) {
        Class<?> stringClass = stringEntity.getClass();
        Class<?> typeClass = typeEntity.getClass();
        Field[] typeFields = typeClass.getDeclaredFields();
        for (Field field : typeFields) {
            String setMethodName = method_set + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            String getMethodName = method_get + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            try {
                Method setMethod = typeClass.getDeclaredMethod(setMethodName, field.getType());
                Method getMethod = stringClass.getDeclaredMethod(getMethodName);

                Object typeTransform = typeTransform(getMethod.invoke(stringEntity), field.getType().getSimpleName());
                if (typeTransform == null) continue;
                setMethod.invoke(typeEntity, typeTransform);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return typeEntity;
    }

    /**
     * 类型转换
     *
     * @param str       String字符串
     * @param typeClass 要转换的类型
     * @return 返回转换后的类型结果
     */
    public Object typeTransform(Object str, String typeClass) {
        if (StringUtils.isBlank((String) str)) return null;
        switch (typeClass.toLowerCase()) {
            case "string":
                return str;
            case "int":
                return Integer.parseInt(str.toString());
            case "date":
                return DateUtil.stringToDate(str.toString());
            case "long":
                return Long.parseLong(str.toString());
            case "bigdecimal":
                return new BigDecimal(str.toString());
            default:
                return null;
        }
    }

    /**
     * 类型转换
     *
     * @param str       String字符串
     * @param typeClass 要转换的类型
     * @return 返回转换后的类型结果
     */
    public Object stringTransform(Object str, String typeClass) {
        if (str == null) return null;
        switch (typeClass.toLowerCase()) {
            case "date":
                return DateUtil.dateToString((Date) str);
            default:
                return str;
        }
    }

    // main测试
    public static void main(String[] args) {
        PlanBean planBean = new PlanBean();
        PlanTransform planTransform = new PlanTransform();
        planTransform.setPlanId("1");
        planTransform.setPlanContent("测试一把");
        planTransform.setStatus("2");
        planTransform.setPlanCatId("1");
        planTransform.setPlanStartDt("2021-08-23 14:12:10");
        new Transform<PlanBean, PlanTransform>().transformEntityStringToType(planTransform, planBean);
        System.out.println(planBean);

        PlanTransform planTransform2 = new PlanTransform();
        new Transform<PlanBean, PlanTransform>().transformEntityTypeToString(planBean, planTransform2);
        System.out.println(planTransform2);

        // PlanBean planBean = new PlanBean();
        // Class<? extends PlanBean> aClass = planBean.getClass();
        // Field[] declaredFields = aClass.getDeclaredFields();
        // for (Field field : declaredFields) {
        //     String setMethodName = method_set + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        //     String getMethodName = method_get + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        //     try {
        //         Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
        //         Method getMethod = aClass.getDeclaredMethod(getMethodName);
        //         if (field.getType().getSimpleName().equalsIgnoreCase("String")) {
        //             setMethod.invoke(planBean, "aa");
        //         }
        //         System.out.println(getMethod.invoke(planBean));
        //     } catch (NoSuchMethodException e) {
        //         e.printStackTrace();
        //     } catch (IllegalAccessException e) {
        //         e.printStackTrace();
        //     } catch (InvocationTargetException e) {
        //         e.printStackTrace();
        //     }
        //
        //     // if (field.getName() instanceof String) {
        //     //     System.out.println(field.getName() + " <==> " + field.getType() + " ==> " + field.getType().getName());
        //     // }
        // }

        // Method[] methods = aClass.getMethods();
        // for (Method method : methods) {
        //     // System.out.println(method.getName());
        //
        // }
    }

}
