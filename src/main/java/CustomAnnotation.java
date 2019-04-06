import myAnnotationPackage.WebRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAnnotation implements HttpHandler {

    public void handle(HttpExchange httpExchange) {

        MyHttpHandler myHttpHandler = new MyHttpHandler();
        try {
            Class<MyHttpHandler> mH = MyHttpHandler.class;
            Method[] methods = mH.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(WebRoute.class)) {
                    if (method.getAnnotation(WebRoute.class).toString().contains(httpExchange.getRequestURI().toString())) {

                        if (method.getAnnotation(WebRoute.class).toString().contains("method=POST") && httpExchange.getRequestMethod().equals("POST")) {
                            System.out.println(method.getAnnotation(WebRoute.class).toString());
                            method.invoke(myHttpHandler, httpExchange);
                        } else if (method.getAnnotation(WebRoute.class).toString().contains("method=GET") && httpExchange.getRequestMethod().equals("GET")) {
                            System.out.println(method.getAnnotation(WebRoute.class).toString());
                            method.invoke(myHttpHandler, httpExchange);
                        }
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
