package com.beng.webbe;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.beng.webbe.model.Address;
import com.beng.webbe.repository.AddressRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebBeApplicationTests {
	@Autowired
	private AddressRepo addressRepo;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testAPI()
	{
		AlipayClient alipayClient = new
				DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016091900545639","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9eF/0HNakuQBshAv9re/YEYlSei6zzDQ3BAQxbrtuIUW04fqrLF/y+krALR0FLTmpL9WdFoCuSkxAyZj/2qFFzK2mhaOohM8B0dsJXae8MQHSOQAC4TlyubMBJ8w+oDxOye7Zrd8T4IuMqBUrtkLLSjyfrqUGvhEUkfNw9Cs0NrcTsVZZY+hV8nOdisf/zb7fsC7b4f8HtiX2UxuqWK8W86OTmiFKZa9Lj7oien4IT9UcNKX6W/vGT6yKtAtdYLgcSDBFWsq68Wsi/eVaS2jeqh9SiUXIUFY2kEjDjPjg+wMVtL/JJnVh+csgTHiSdRrtE8rr7Iu5JEAB2qhhJxFBAgMBAAECggEBAIOKHbvBhbcohUXRSu3cowXz7s1m7COBYsLLNAoJoXBtAxL4TGooTZjH8buH1nzwj/aIshn0NHRMOrJEA8elRo/J8MkKQLvPMFRIGHRhJAGAWI5Vak+Vg6fFiqQDuEXGQvhEM2HG13faTafiTYhiae7u5DXMLuAGdp88ULGbop8FJxz/XVS4KFRsifqMML4W5oLMmL6MpRladwZd/WlxazB2d9BE3EWjx9hzhrg3TI4f/q0RkkTXH4/7+4GT+Z7WrwK+FPfK3yJ13vpphbkGQrielnu+Y23Pd50ZRU1VKGZeJ+QLkxebNsq9MG9HhqzqzhSEK0CzwW7CRoyVDGIJnZECgYEA6pxkHcy1HXNypdYYwhdIYuuGGGwjNP7J/H6NCkeIcAiSuyKEjCiyv7Z/39k2npZwY+g9QMgpoWn4v+k/9j8Igh6M0pR1RukrxV9K1EjP2ErNDMos5PC+8ufK2I2M8zW+f+tNh9gKnUtYPLtwoXPFFbwdu2JUfUuAt6pUjbMlKz0CgYEAzr5wvTdcHdJaF8AKPC4OIV3ivCck9nYxCKezO00LpbZXuVaS90tYk8SNl7nm4R5/DNfCCY4UsBRsmbiZIFD5yEFSjqXaRgnilQYmtoMqiIsrPDB7N1WS6+vnMH47ACbnVkVLlJTCZE0M+IBfXwaCAEzOKKv4yU3J8WUgFyPh7lUCgYBYUzJ56ZSSFuGlv3mosJ1G6IaecS+8BuRCU96DbTTXgNLE8xTVs4jAFlQEEUG36Mk9Q7Szy+eoZj4I+iZjbY2ldxzrNosEfEpHTz3bt+HP+zFBTGgkdOJejpdWecwD0Er827hfmR095Jy+mI6pqe0b5quG3VkTprY57z1P747hvQKBgDr1sK0llo2iqbLQP5r9/2WgosLJ3w6ykjVHriOhS0sM/2OJvwvrXu11RnQYvjFBQzZkaZ/T9y5oBLiqHnFK5pEnn+WygtcqhoW9ZVjzezPJjKDzqpATRX0mn54Cwcy/S4Yc6PsMmYuFNcfAxHITJwvy23BZ6u9t0cOX9VjkENCpAoGBAODLFsU1BQ0qC5vaWljzyjjwBBOmeAEzmvBzmLchQZqt7EGqts8N31/jc5t4wKLnwqhswjSz9RNdCu3/CMmbcBJxg6SkgwEfWyKITuzKWoOs9EvAAvI9PxTytGq8zWmPvmjUW6tYwP8neFZKclvd2lUW1gzgpK8nwNh48G34YSWV","json","utf-8",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvwL3FKI6twK33wIVEElvQ6MHnqbv5bFJTajdKh6fA1wVLOBsxKyUuPVdsxNBCiLjG+DzhH2irSyMTKd+3Bl9p+ui/jtB7Iw1A38/GCMSEju6BQ1TpdD7Ek+oDUqQLrQp35sy+YZegKnjDLuNXgExqPfwa+wf4chYynNetaeIjHzzA6M2xTEv7iEIvqXqH6QutBFFjY/UZO8xVY/iI36ZYIAs3ctUEZTUw7NPTJgR/90InBMcyrmURp4UTKR1DxgksWGEtGvdgICvUscxX0thqMD6XyPRxxDV3KUpEBATxR+37EKPFnwtYdewQvpKQBltxX0y/4jN7JF0aC7ylgbZuwIDAQAB","RSA2" );

		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("我是测试数据");
		model.setSubject("App支付测试Java");
		model.setOutTradeNo("11111");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("商户外网可以访问的异步地址");
		try {
			//这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
//		AlipayTradePayRequest request = new AlipayTradePayRequest();
//		AlipayTradePayModel model = new AlipayTradePayModel();
//		request.setBizModel(model);
//
//		model.setOutTradeNo(System.currentTimeMillis()+"");
//		model.setSubject("Iphone6 16G");
//		model.setTotalAmount("0.01");
//		model.setAuthCode("286943079189994381");//沙箱钱包中的付款码
//		model.setScene("bar_code");
//
//		AlipayTradePayResponse response = null;
//		try {
//			response = alipayClient.execute(request);
//			System.out.println(response.getBody());
//			System.out.println(response.getTradeNo());
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//		}

	}

//	@Test
//	public void mytest(){
//		Services services=new Services();
//		System.out.println(services.encodeMD5Hex
//				("DGFSWER145423dgfsaag2343dsDASF34dfaDFS3dsgfDFS32df423234543cvdsDFSDSFRQEW2fDS2fsdADSD21DSFFDSSDAF3222222224324234FSD"));
//	}
	@Test
	public void testadd()
	{
		Address a=new Address();
		a.addNew(2,"123");
		addressRepo.save(a);
	}
}
