
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloSecureResponseHelloSecureResult_QNAME = new QName("http://tempuri.org/", "HelloSecureResult");
    private final static QName _HelloSecureStringSecure_QNAME = new QName("http://tempuri.org/", "stringSecure");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloSecure }
     * 
     */
    public HelloSecure createHelloSecure() {
        return new HelloSecure();
    }

    /**
     * Create an instance of {@link HelloSecureResponse }
     * 
     */
    public HelloSecureResponse createHelloSecureResponse() {
        return new HelloSecureResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "HelloSecureResult", scope = HelloSecureResponse.class)
    public JAXBElement<String> createHelloSecureResponseHelloSecureResult(String value) {
        return new JAXBElement<String>(_HelloSecureResponseHelloSecureResult_QNAME, String.class, HelloSecureResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "stringSecure", scope = HelloSecure.class)
    public JAXBElement<String> createHelloSecureStringSecure(String value) {
        return new JAXBElement<String>(_HelloSecureStringSecure_QNAME, String.class, HelloSecure.class, value);
    }

}
