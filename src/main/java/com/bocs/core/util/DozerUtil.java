package com.bocs.core.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.classmap.MappingFileData;
import org.dozer.loader.DozerBuilder;
import org.dozer.loader.api.BeanMappingBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 简单封装Dozer, 实现深度转换Bean<->Bean的Mapper.实现:
 * 1. 持有Mapper的单例.
 * 2. 返回值类型转换.
 * 3. 批量转换Collection中的所有对象.
 * 4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数.
 * 
 * @author calvin
 */
public class DozerUtil {

    /**
     * 自定义Dozer的全局配置参数
     */
    static class CustomBeanMappingBuilder extends BeanMappingBuilder {
        private DozerBuilder dozerBuilder;

        @Override
        public MappingFileData build() {
            dozerBuilder = new DozerBuilder();
            // 设置映射策略
            DozerBuilder.ConfigurationBuilder config = dozerBuilder.configuration();
            config.mapNull(false); // 不映射空值

            return dozerBuilder.build();
        }

        @Override
        protected void configure() {
        }
    }

    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static DozerBeanMapper dozer = new DozerBeanMapper();
    static {
        dozer.addMapping(new CustomBeanMappingBuilder());
    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozer.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList(@SuppressWarnings("rawtypes") Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer转换Linkedlist中对象的类型.
     */
    public static <T> LinkedList<T> mapLinkedList(@SuppressWarnings("rawtypes") Collection sourceLinkedList, Class<T> destinationClass) {
        LinkedList<T> destinationLinkedList = new LinkedList<T>();
        for (Object sourceObject : sourceLinkedList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationLinkedList.add(destinationObject);
        }
        return destinationLinkedList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void map(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }

}