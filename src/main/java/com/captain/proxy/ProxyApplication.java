package com.captain.proxy;

import com.captain.proxy.CglibProxy.CglibProxy;
import com.captain.proxy.JDKProxy.JDKProxy;
import com.captain.proxy.JDKProxy.Service;
import com.captain.proxy.JDKProxy.ServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyApplication {

    public static void main(String[] args) {
        Service service= (Service) new CglibProxy().getInstance(new ServiceImpl());
        service.sayHello();
        SpringApplication.run(ProxyApplication.class, args);
    }
}
