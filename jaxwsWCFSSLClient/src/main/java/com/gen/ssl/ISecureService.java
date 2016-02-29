
package com.gen.ssl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ISecureService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ISecureService {


    /**
     * 
     * @param stringSecure
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "HelloSecure", action = "http://tempuri.org/ISecureService/HelloSecure")
    @WebResult(name = "HelloSecureResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "HelloSecure", targetNamespace = "http://tempuri.org/", className = "com.gen.ssl.HelloSecure")
    @ResponseWrapper(localName = "HelloSecureResponse", targetNamespace = "http://tempuri.org/", className = "com.gen.ssl.HelloSecureResponse")
    public String helloSecure(
        @WebParam(name = "stringSecure", targetNamespace = "http://tempuri.org/")
        String stringSecure);

}
