import com.sun.net.httpserver.HttpExchange;
import myAnnotationPackage.WebRoute;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler {


    @WebRoute(method="GET", path="/test/one")
    public void pageOneGetResponse(HttpExchange httpExchange) throws IOException {
        String response = "<html><body>" +
                "<form method=\"POST\">\n" +
                "  <input type=\"submit\" value=\"Post Button ;-)\">\n" +
                "</form> " +
                "</body></html>" +
                "This is page one GET RESPONSE";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(method="POST", path="/test/one")
    public void pageOnePostResponse(HttpExchange httpExchange) throws IOException {
        String response = "This is page one POST RESPONSE";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(method="GET", path="/test/two")
    public void pageTwoGetResponse(HttpExchange httpExchange) throws IOException {
        String response = "<html><body>" +
                "<form method=\"POST\">\n" +
                "  <input type=\"submit\" value=\"Post Button ;-)\">\n" +
                "</form> " +
                "</body></html>" +
                "This is page two GET RESPONSE";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(method="POST", path="/test/two")
    public void pageTwoPostResponse(HttpExchange httpExchange) throws IOException {
        String response = "This is page two POST RESPONSE";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
