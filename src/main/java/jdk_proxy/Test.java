package jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by jnkmhbl on 16/8/23.
 */
public class Test {
    public static void main(String args[]) {
        OperatorInvocationHandler handler = new OperatorInvocationHandler(new OperatorImpl());
        Operator operator =(Operator) Proxy.newProxyInstance(Operator.class.getClassLoader(),new Class[]{Operator.class},handler);
        operator.operate();
    }


}
