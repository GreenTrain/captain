package com.captain.proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object o;

    public Object getProxy(Object o) {
        this.o = o;
        Object o1 = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
        return o1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before---->");
        method.invoke(o, args);
        System.out.println("after---->");
        return null;
    }
}
