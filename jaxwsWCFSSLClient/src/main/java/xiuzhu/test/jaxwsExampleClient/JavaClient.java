package xiuzhu.test.jaxwsExampleClient;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.tempuri.ISecureServiceBasicHttp;
import org.tempuri.SecureServiceBasicHttp;

/**
 * Java Client call WCF C# SSL Service with basicHttpBinding
 * 
 * @author xiuzhu 160402
 */
public class JavaClient {
	static String password = "123456";
	
	public static void callHttpsService() {

		// set store
		Properties systemProps = System.getProperties();

//		try {
//			KeyStore keyStore = KeyStore.getInstance("JKS");
//			String keystoreURL = "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\clientKeyStore.certs";
//			InputStream is = new FileInputStream(keystoreURL);
//			keyStore.load(is, password.toCharArray());
//		} catch (KeyStoreException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (CertificateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		systemProps.put("javax.net.ssl.keyStore", "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\clientKeyStore.certs");
		systemProps.put("javax.net.ssl.keyStorePassword", password);
		systemProps.put("javax.net.ssl.trustStore", "C:\\Users\\xiuzhu\\Desktop\\certbasicHttp\\fuw\\trustedstore_rootCert.certs");
		systemProps.put("javax.net.ssl.trustStorePassword", password);
		
		//set debug info
		systemProps.setProperty("javax.net.debug", "ssl,keymanager");

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
	
	public static void callHttpsService_LoadCertFromJar() {
		InputStream keystoreInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("clientKeyStore.certs");
		InputStream truststoreInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("trustedstore_rootCert.certs");
		try {
			setSSLFactories(keystoreInput, password, truststoreInput);
			keystoreInput.close();
			truststoreInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Properties systemProps = System.getProperties();
		systemProps.setProperty("javax.net.debug", "ssl,keymanager");
		System.setProperties(systemProps);

		SecureServiceBasicHttp ss = new SecureServiceBasicHttp();
		ISecureServiceBasicHttp secureService = ss.getPort(ISecureServiceBasicHttp.class);
		javax.xml.ws.BindingProvider bindingProvider = (javax.xml.ws.BindingProvider) secureService;
		bindingProvider.getRequestContext().put(javax.xml.ws.BindingProvider.SOAPACTION_USE_PROPERTY, true);

		String rest = secureService.helloSecure("secure param");
		System.out.println(rest);
	}

	/**
	 * Load keyStore & trustStore from with the jar.
	 * refer to http://stackoverflow.com/questions/344748/how-to-use-a-file-in-a-jar-as-javax-net-ssl-keystore
	 * @param keyStream
	 * @param keyStorePassword
	 * @param trustStream
	 * @throws Exception
	 */
	private static void setSSLFactories(InputStream keyStream, String keyStorePassword, InputStream trustStream)
			throws Exception {
		// Get keyStore
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

		// if your store is password protected then declare it (it can be null
		// however)
		char[] keyPassword = keyStorePassword.toCharArray();

		// load the stream to your store
		keyStore.load(keyStream, keyPassword);

		// initialize a trust manager factory with the trusted store
		KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		keyFactory.init(keyStore, keyPassword);

		// get the trust managers from the factory
		KeyManager[] keyManagers = keyFactory.getKeyManagers();

		// Now get trustStore
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

		// if your store is password protected then declare it (it can be null
		// however)
		// char[] trustPassword = password.toCharArray();

		// load the stream to your store
		trustStore.load(trustStream, null);

		// initialize a trust manager factory with the trusted store
		TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustFactory.init(trustStore);

		// get the trust managers from the factory
		TrustManager[] trustManagers = trustFactory.getTrustManagers();

		// initialize an ssl context to use these managers and set as default
		SSLContext sslContext = SSLContext.getInstance("SSL");
		sslContext.init(keyManagers, trustManagers, null);
		SSLContext.setDefault(sslContext);
	}

	public static void main(String[] args) throws Exception {
		// JavaClient.callHttpsService();
		JavaClient.callHttpsService_LoadCertFromJar();	//note: to test this, put cert to src/main/resources folder first.
	}

}
