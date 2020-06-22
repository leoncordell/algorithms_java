package com.algorithm.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.logging.Logger;


public class TimingDynamicInvocationHandler implements InvocationHandler {
    private static Logger LOGGER = Logger.getLogger("TimingDynamicInvocationHandler.class");
//            LoggerFactory.getLogger(
//            TimingDynamicInvocationHandler.class);

    TimingDynamicInvocationHandler(Object target){
        this.target = target;
    }

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            LOGGER.info("Invoked method: {}" +  method.getName());
                method.invoke(target, args);

            return 42;
    }
}

interface User{
    void doStuff();
}


class Client implements User{
    private static final Logger LOGGER = Logger.getLogger("Client");



    @Override
    public void doStuff() {
        LOGGER.info("Stuff");
        System.out.println("Stuff");
    }


}
class Main{
    public static void main(String[] args) {
        Client client = new Client();

        User mapProxyInstance = (User)Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[] {User.class} ,new TimingDynamicInvocationHandler(client));
        mapProxyInstance.doStuff();
    }

}