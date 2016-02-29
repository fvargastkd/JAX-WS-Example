package xiuzhu.test.jaxwsExampleClient;

/**
 * https://sites.google.com/site/ddmwsst/create-your-own-certificate-and-ca
 * https://sites.google.com/site/ddmwsst/create-your-own-certificate-and-ca/ssl-socket-communication 
 * @author xiuzhu 160229
 */import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class EchoClient {

	public static final boolean DEBUG = true;
	public static final int HTTPS_PORT = 8282;
	public static final String HTTPS_HOST = "win-c088qgabq4r";
	public static final String TRUSTTORE_LOCATION = "D:\\certs\\sampleInNetwork\\ClientKeyStore.jks";

	public static void main(String[] args) {

		System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);

		if (DEBUG)
			System.setProperty("javax.net.debug", "ssl:record");

		SSLSocketFactory f = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try {
			SSLSocket c = (SSLSocket) f.createSocket(HTTPS_HOST, HTTPS_PORT);

			c.startHandshake();
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
			BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String msg = "Hey, here is client, how are you?";
			w.write(msg, 0, msg.length());
			w.newLine();
			w.flush();

			// now read the socket
			String m = null;
			while ((m = r.readLine()) != null) {
				System.out.println(m);
			}

		} catch (IOException e) {
			System.err.println(e.toString());
		}

	}
}