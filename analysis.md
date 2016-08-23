##Jdk Proxy 解析

首先明确一点jdkProxy是面向接口的


//首先讲如何使用
实现一个InvocationHandler接口 ，这个类持有真正实例的引用，invoke方法内做代理行为
通过Proxy.newInstance() 创建代理对象
so easy







//这里讲解动态代理的核心步骤
1.Proxy.newProxyInstance(ClassLoader ,Class[] , Handler)
三个参数ClassLoader ,Class [] ,Handler
何为动态代理，在运行期产生 class文件 ，所以需要Class[] (这里是所有的interface) ,handler来动态生成 class文件，
    Why ClassLoader ? 因为只有同一个类加载器加载的同一个路径的类才会被认为是相同的
    Handler 是包含了目标方法的代理类
    handler 内部通过invoke方法来调用真正实例的方法 >>>参见java 反射 Method. invoke

2.ProxyGenerator是代理类生成的真正场所
        核心属性
        List<FiledInfo> fields
        List<MethodInfo> methods

        generateClassFile()
        //里面添加了通用的方法，默认构造函数，
        //完成的任务大体就是fields 和 methods的赋值