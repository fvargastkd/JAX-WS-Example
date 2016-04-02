package xiuzhu.test.jaxwsExampleClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Properties;

import org.tempuri.ISecureServiceBasicHttp;
import org.tempuri.SecureServiceBasicHttp;
/**
 * Java Client call WCF C# SSL Service with basicHttpBinding
 * @author xiuzhu
 * 160402
 */
public class JavaClient {
	public static void callHttpsService() {
		String password = "123456";

		// set store
		Properties systemProps = System.getProperties();
		try {
			KeyStore keyStore = KeyStore.getInstance("JKS");
			String keystoreURL = "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\clientKeyStore.certs";
			InputStream is = new FileInputStream(keystoreURL);
			keyStore.load(is, password.toCharArray());
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		systemProps.put("javax.net.ssl.keyStore", "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\clientKeyStore.certs");
		systemProps.put("javax.net.ssl.keyStorePassword", password);
		systemProps.put("javax.net.ssl.trustStore", "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\trustedstore.certs");
		systemProps.put("javax.net.ssl.trustStorePassword", password);
		
		//set debug info
		systemProps.setProperty("javax.net.debug", "ssl,keymanager ");

		// https://github.com/OfficeDev/ews-java-api/issues/373
		// systemProps.put( "https.protocols", "TLSv1");
		// systemProps.put( "jdk.tls.client.protocols", "TLSv1");
		System.setProperties(systemProps);
		
		SecureServiceBasicHttp ss = new SecureServiceBasicHttp();
		ISecureServiceBasicHttp secureService = ss.getPort(ISecureServiceBasicHttp.class);
		javax.xml.ws.BindingProvider bindingProvider = (javax.xml.ws.BindingProvider) secureService;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.SOAPACTION_USE_PROPERTY, true);
		
		String rest = secureService.helloSecure("secure param");
		System.out.println(rest);
	}

	public static void main(String[] args) {
		JavaClient.callHttpsService();
	}

}
