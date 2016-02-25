
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

    private final static QName _HelloS_QNAME = new QName("http://tempuri.org/", "s");
    private final static QName _Hello2ResponseHello2Result_QNAME = new QName("http://tempuri.org/", "Hello2Result");
    private final static QName _HelloIndigoResponseHelloIndigoResult_QNAME = new QName("http://tempuri.org/", "HelloIndigoResult");
    private final static QName _HelloResponseHelloResult_QNAME = new QName("http://tempuri.org/", "HelloResult");
    private final static QName _Hello2String_QNAME = new QName("http://tempuri.org/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloIndigoResponse }
     * 
     */
    public HelloIndigoResponse createHelloIndigoResponse() {
        return new HelloIndigoResponse();
    }

    /**
     * Create an instance of {@link HelloIndigo }
     * 
     */
    public HelloIndigo createHelloIndigo() {
        return new HelloIndigo();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello2 }
     * 
     */
    public Hello2 createHello2() {
        return new Hello2();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Hello2Response }
     * 
     */
    public Hello2Response createHello2Response() {
        return new Hello2Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "s", scope = Hello.class)
    public JAXBElement<String> createHelloS(String value) {
        return new JAXBElement<String>(_HelloS_QNAME, String.class, Hello.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Hello2Result", scope = Hello2Response.class)
    public JAXBElement<String> createHello2ResponseHello2Result(String value) {
        return new JAXBElement<String>(_Hello2ResponseHello2Result_QNAME, String.class, Hello2Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "HelloIndigoResult", scope = HelloIndigoResponse.class)
    public JAXBElement<String> createHelloIndigoResponseHelloIndigoResult(String value) {
        return new JAXBElement<String>(_HelloIndigoResponseHelloIndigoResult_QNAME, String.class, HelloIndigoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "HelloResult", scope = HelloResponse.class)
    public JAXBElement<String> createHelloResponseHelloResult(String value) {
        return new JAXBElement<String>(_HelloResponseHelloResult_QNAME, String.class, HelloResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "string", scope = Hello2 .class)
    public JAXBElement<String> createHello2String(String value) {
        return new JAXBElement<String>(_Hello2String_QNAME, String.class, Hello2 .class, value);
    }

}
