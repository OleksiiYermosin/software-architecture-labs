package reflection.proxy;

public class ProxyCreator {

    public static Object newProxyInstance(Object o){
        return java.lang.reflect.Proxy.newProxyInstance(
                o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                new CustomInvocationHandler(o)
        );
    }

}
