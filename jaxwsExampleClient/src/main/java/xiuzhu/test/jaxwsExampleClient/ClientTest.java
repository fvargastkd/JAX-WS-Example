package xiuzhu.test.jaxwsExampleClient;

import xiuzhu.test.jaxwsExampleClient.generated.*;

public class ClientTest {

	public static void main(String[] args) {
		HelloWsService service = new HelloWsService();
		HelloWs helloWs = service.getPort(HelloWs.class);
		
		String rest = helloWs.sayHello("xiuwei");
		System.out.println(rest);
	}

}
