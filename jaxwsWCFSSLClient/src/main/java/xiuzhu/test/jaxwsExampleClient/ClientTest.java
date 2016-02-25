package xiuzhu.test.jaxwsExampleClient;

import org.tempuri.*;

@SuppressWarnings("restriction")
public class ClientTest {

	//call HTTP WCF Routing service. 160224
	public static void callHttp(){
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
	
	public static void callHttps(){
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
	
	public static void main(String[] args) {
		System.out.println("------------test HTTP------------");
		callHttp();
		System.out.println("\r\n------------test HTTPS------------");
		callHttps();
	}

}
