
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IHelloIndigoService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IHelloIndigoService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "HelloIndigo", action = "http://tempuri.org/IHelloIndigoService/HelloIndigo")
    @WebResult(name = "HelloIndigoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "HelloIndigo", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HelloIndigo")
    @ResponseWrapper(localName = "HelloIndigoResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HelloIndigoResponse")
    @Action(input = "http://tempuri.org/IHelloIndigoService/HelloIndigo", output = "http://tempuri.org/IHelloIndigoService/HelloIndigoResponse")
    public String helloIndigo();

}
