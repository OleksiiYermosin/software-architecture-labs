package reflection.proxy;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private final Object object;

    CustomInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("get")){
            return method.invoke(object, args);
        }
        throw new OperationNotSupportedException();
    }

}
