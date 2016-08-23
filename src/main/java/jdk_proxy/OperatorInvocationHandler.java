package jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jnkmhbl on 16/8/23.
 */
public class OperatorInvocationHandler implements InvocationHandler {
    private Object target ; // operator实例

    public OperatorInvocationHandler(Object target){
        this.target = target ;
    }

    public Object invoke(Object proxy ,Method method ,Object[] params){
        try {
            System.out.println("before");
            Object obj =  method.invoke(target, params);
            System.out.println("after");
            return obj ;
        }catch (Exception e){
            System.out.println("error");
            return null ;
        }
    }
}
