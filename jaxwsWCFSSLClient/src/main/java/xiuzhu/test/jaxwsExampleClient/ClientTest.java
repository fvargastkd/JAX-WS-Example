package xiuzhu.test.jaxwsExampleClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Properties;

import org.tempuri.HelloIndigoService;
import org.tempuri.IHelloIndigoService;
import org.tempuri.IService2;
import org.tempuri.Service2;

import com.gen.ssl.ISecureService;
import com.gen.ssl.SecureService;

@SuppressWarnings("restriction")
public class ClientTest {

	//call HTTP WCF Routing service. 160224
	public static void callHttpRouting(){
		String helloServiceUrl = "http://WIN-C088QGABQ4R:2345/RoutingService/HelloIndigoRouter";
		String service2Url = "http://WIN-C088QGABQ4R:2345/RoutingService/Service2Router";
		
		HelloIndigoService hs = new HelloIndigoService();
		IHelloIndigoService helloWs = hs.getPort(IHelloIndigoService.class);
		javax.xml.ws.BindingProvider bindingProvider = (javax.xml.ws.BindingProvider) helloWs;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, helloServiceUrl);
		String rest = helloWs.helloIndigo();
		System.out.println(rest);
		
		Service2 s2 = new Service2();
		IService2 service2 = s2.getPort(IService2.class);
		bindingProvider = (javax.xml.ws.BindingProvider) helloWs;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, service2Url);
		rest = service2.hello("test hello");
		System.out.println(rest);
		rest = service2.hello2("test hello 2");
		System.out.println(rest);
	}
	
	//call HTTPS WCF Routing service. 160224,160225
	public static void callHttpsRotuing(){
		
		//set store
		Properties systemProps = System.getProperties();  
		systemProps.put( "javax.net.ssl.keyStore", "D:/certs/clientKeyStore.certs");  
		systemProps.put( "javax.net.ssl.keyStorePassword", "cc800cc800"); 
		systemProps.put( "javax.net.ssl.trustStore", "D:/certs/trustedstore.certs");  
		systemProps.put( "javax.net.ssl.trustStorePassword", "cc800cc800");  
		systemProps.setProperty("javax.net.debug", "ssl"); 
		
		//https://github.com/OfficeDev/ews-java-api/issues/373
		systemProps.put( "https.protocols", "TLSv1");
		systemProps.put( "jdk.tls.client.protocols", "TLSv1"); 

		System.setProperties(systemProps); 
		
		String helloServiceUrl = "https://WIN-C088QGABQ4R:8123/RoutingSecureService/HelloIndigoRouter";
		String service2Url = "https://WIN-C088QGABQ4R:8123/RoutingSecureService/Service2Router";
		
		HelloIndigoService hs = new HelloIndigoService();
		IHelloIndigoService helloWs = hs.getPort(IHelloIndigoService.class);
		javax.xml.ws.BindingProvider bindingProvider = (javax.xml.ws.BindingProvider) helloWs;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, helloServiceUrl);
		String rest = helloWs.helloIndigo();
		System.out.println(rest);
		
		Service2 s2 = new Service2();
		IService2 service2 = s2.getPort(IService2.class);
		bindingProvider = (javax.xml.ws.BindingProvider) helloWs;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, service2Url);
		rest = service2.hello("test hello");
		System.out.println(rest);
		rest = service2.hello2("test hello 2");
		System.out.println(rest);
	}
	
	//call HTTPS WCF service. 160226
	public static void callHttpsService(){
		
		//set store
		Properties systemProps = System.getProperties();  
		
        try {
        	KeyStore keyStore = KeyStore.getInstance("JKS");
        	String keystoreURL = "D:/certs/clientKeyStore.certs";  
        	InputStream is = new FileInputStream(keystoreURL);  
			keyStore.load(is, "cc800cc800".toCharArray());
		}  catch (KeyStoreException e) {
			e.printStackTrace();
		}  catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		
		
//		systemProps.put( "javax.net.ssl.keyStore", "D:/certs/clientKeyStore.certs");  
//		systemProps.put( "javax.net.ssl.keyStorePassword", "cc800cc800"); 
		systemProps.put( "javax.net.ssl.trustStore", "D:/certs/trustedstore.certs");  
		systemProps.put( "javax.net.ssl.trustStorePassword", "cc800cc800");  
		systemProps.setProperty("javax.net.debug", "ssl"); 
		
		//https://github.com/OfficeDev/ews-java-api/issues/373
		systemProps.put( "https.protocols", "TLSv1");
		systemProps.put( "jdk.tls.client.protocols", "TLSv1"); 

		
		System.setProperties(systemProps); 
		
		String secureServiceUrl = "https://win-c088qgabq4r:8123/SSLService";
		
		SecureService ss = new SecureService();
		ISecureService secureService = ss.getPort(ISecureService.class);
		javax.xml.ws.BindingProvider bindingProvider = (javax.xml.ws.BindingProvider) secureService;

		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.SOAPACTION_USE_PROPERTY, true);
		
		String rest = secureService.helloSecure("secure param");
		System.out.println(rest);
	}
	
	public static void main(String[] args) {
//		System.out.println("------------test HTTP routing------------");
		//callHttp();
//		System.out.println("\r\n------------test HTTPS Routing------------");
//		callHttpsRotuing();
		System.out.println("\r\n------------test HTTPS Service------------");
		callHttpsService();
	}

}
