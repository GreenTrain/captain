package com.captain.proxy.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object o;

    public Object getInstance(Object o) {
        this.o = o;
        Enhancer e = new Enhancer();
        e.setSuperclass(o.getClass());
        e.setCallback(this);
        Object o1 = e.create();
        return o1;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-->before");
        Object invoke = method.invoke(this.o, objects);
        System.out.println("-->after");
        return invoke;
    }
}
