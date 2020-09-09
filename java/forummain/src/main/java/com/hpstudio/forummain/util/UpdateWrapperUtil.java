package com.hpstudio.forummain.util;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author mawen
 * @date 2020/9/9 15:48
 * @email 455766076@qq.com
 */
@Component
public class UpdateWrapperUtil<T> {
    /**
     * 根据主键更新@Id
     * @param t 对象
     * @param skipNull true：对空值不更新 false：将空值覆盖原有值
     * @return
     * @throws IllegalAccessException
     */
    public UpdateWrapper<T> updateById(T t, boolean skipNull) throws IllegalAccessException {
        UpdateWrapper<T> wrapper = new UpdateWrapper<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            //获取字段原来权限
            boolean accessible = field.isAccessible();
            //设置字段权限可读写
            field.setAccessible(true);
            //获取字段名
            String name = field.getName();
            //获取字段值
            Object val = field.get(t);
            //
            if (null != field.getAnnotation(Id.class)) {
                wrapper.eq(name, val);
            } else {
                if (skipNull && null == val) {
                    continue;
                }
                wrapper.set(name, val);
            }
            field.setAccessible(accessible);
        }
        return wrapper;
    }

}
