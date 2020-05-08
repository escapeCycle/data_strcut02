package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import com.google.common.annotations.VisibleForTesting;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 18:20
 */
public class BeansFactory {

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            beanDefinitionMap.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined : " + beanId);
        }
        return createBean(beanDefinition);
    }

    @VisibleForTesting
    protected Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.containsKey(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;
        try {
            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getArgs();
            if (args.isEmpty()) {
                return beanClass.newInstance();
            } else {
                Class[] argsClass = new Class[args.size()];
                Object[] argsObj = new Object[args.size()];
                for (int i = 0; i < args.size(); ++i) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if (!arg.isRef()) {
                        argsClass[i] = arg.getType();
                        argsObj[i] = arg.getArg();
                    } else {
                        BeanDefinition refBeanDefinition = beanDefinitionMap.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argsClass[i] = Class.forName(refBeanDefinition.getClassName());
                        argsObj[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argsClass).newInstance(argsObj);
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeanCreationFailureException("bean create fail !",e);
        }
        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }

}
