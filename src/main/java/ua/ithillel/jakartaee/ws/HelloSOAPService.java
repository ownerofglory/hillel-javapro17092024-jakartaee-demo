package ua.ithillel.jakartaee.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://ws.jakartaee.ithillel.ua")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloSOAPService {
    @WebMethod // endpoint
    public String sayHello(@WebParam(name = "name") String name) {
        return "Hello " + name;
    }
}
