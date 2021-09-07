package reflection;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {

    private final Object object;

    private Proxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("get")){
            return method.invoke(object, args);
        }
        throw new OperationNotSupportedException();
    }

    public static Object newProxyInstance(Object o){
        return java.lang.reflect.Proxy.newProxyInstance(
                o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                new Proxy(o)
        );
    }

}
