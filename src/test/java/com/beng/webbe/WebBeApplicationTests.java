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
import com.beng.webbe.model.ShopHistory;
import com.beng.webbe.repository.AddressRepo;
import com.beng.webbe.repository.ShopHistoryRepo;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebBeApplicationTests {
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ShopHistoryRepo shopHistoryRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAPI()
	{
		AlipayClient alipayClient = new
				DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091900545639", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9eF/0HNakuQBshAv9re/YEYlSei6zzDQ3BAQxbrtuIUW04fqrLF/y+krALR0FLTmpL9WdFoCuSkxAyZj/2qFFzK2mhaOohM8B0dsJXae8MQHSOQAC4TlyubMBJ8w+oDxOye7Zrd8T4IuMqBUrtkLLSjyfrqUGvhEUkfNw9Cs0NrcTsVZZY+hV8nOdisf/zb7fsC7b4f8HtiX2UxuqWK8W86OTmiFKZa9Lj7oien4IT9UcNKX6W/vGT6yKtAtdYLgcSDBFWsq68Wsi/eVaS2jeqh9SiUXIUFY2kEjDjPjg+wMVtL/JJnVh+csgTHiSdRrtE8rr7Iu5JEAB2qhhJxFBAgMBAAECggEBAIOKHbvBhbcohUXRSu3cowXz7s1m7COBYsLLNAoJoXBtAxL4TGooTZjH8buH1nzwj/aIshn0NHRMOrJEA8elRo/J8MkKQLvPMFRIGHRhJAGAWI5Vak+Vg6fFiqQDuEXGQvhEM2HG13faTafiTYhiae7u5DXMLuAGdp88ULGbop8FJxz/XVS4KFRsifqMML4W5oLMmL6MpRladwZd/WlxazB2d9BE3EWjx9hzhrg3TI4f/q0RkkTXH4/7+4GT+Z7WrwK+FPfK3yJ13vpphbkGQrielnu+Y23Pd50ZRU1VKGZeJ+QLkxebNsq9MG9HhqzqzhSEK0CzwW7CRoyVDGIJnZECgYEA6pxkHcy1HXNypdYYwhdIYuuGGGwjNP7J/H6NCkeIcAiSuyKEjCiyv7Z/39k2npZwY+g9QMgpoWn4v+k/9j8Igh6M0pR1RukrxV9K1EjP2ErNDMos5PC+8ufK2I2M8zW+f+tNh9gKnUtYPLtwoXPFFbwdu2JUfUuAt6pUjbMlKz0CgYEAzr5wvTdcHdJaF8AKPC4OIV3ivCck9nYxCKezO00LpbZXuVaS90tYk8SNl7nm4R5/DNfCCY4UsBRsmbiZIFD5yEFSjqXaRgnilQYmtoMqiIsrPDB7N1WS6+vnMH47ACbnVkVLlJTCZE0M+IBfXwaCAEzOKKv4yU3J8WUgFyPh7lUCgYBYUzJ56ZSSFuGlv3mosJ1G6IaecS+8BuRCU96DbTTXgNLE8xTVs4jAFlQEEUG36Mk9Q7Szy+eoZj4I+iZjbY2ldxzrNosEfEpHTz3bt+HP+zFBTGgkdOJejpdWecwD0Er827hfmR095Jy+mI6pqe0b5quG3VkTprY57z1P747hvQKBgDr1sK0llo2iqbLQP5r9/2WgosLJ3w6ykjVHriOhS0sM/2OJvwvrXu11RnQYvjFBQzZkaZ/T9y5oBLiqHnFK5pEnn+WygtcqhoW9ZVjzezPJjKDzqpATRX0mn54Cwcy/S4Yc6PsMmYuFNcfAxHITJwvy23BZ6u9t0cOX9VjkENCpAoGBAODLFsU1BQ0qC5vaWljzyjjwBBOmeAEzmvBzmLchQZqt7EGqts8N31/jc5t4wKLnwqhswjSz9RNdCu3/CMmbcBJxg6SkgwEfWyKITuzKWoOs9EvAAvI9PxTytGq8zWmPvmjUW6tYwP8neFZKclvd2lUW1gzgpK8nwNh48G34YSWV", "json", "utf-8",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr9b6adnev/MJfFZaVcNQo9HSZfEnYVXdhqPI24xFaz1F1gVgYjTQbwFLBnxe1AGiUSfjqxhol7GUk8X+4f4EfceLrzDh2vwd/3XYKIHSNv1iNgm+HyymHjc6v8F563Ku8UibE6cUrUSlwpoSR8PaIvsih5k7+Z1vZ/bAVOQYMEFCBwzd5nHadfquz6pZfDsAaMR6qOJ6T8XMaITGk001P/Aat0Y9ksHq6Gx1NBg05D9miHRySFGz3WC+zJicsygX0AR5DpfwGeOT1FdgnLM6gxveBipXwz3xBaBMmp2e2p+N6CMSzh4rSK4pZaDTR9sHNkHJQ2oe+md2rlfpBFpSswIDAQAB", "RSA2");

		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("test");
		model.setSubject("test");
		model.setOutTradeNo("31415926");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("http://114.115.143.130:8080/rechargeAlipay");
		try {
			//这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。

		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
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
	@Test
	public void test1()
	{
//		Date currentTime = new Date();
////		ShopHistory s=shopHistoryRepo.getOne(2);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = formatter.format(currentTime);
//		System.out.println(dateString);
////		try {
////			Thread.sleep(1000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//		Date newTime = new Date();
//		dateString = formatter.format(newTime);
//		System.out.println(dateString);
//		Date newTime1 = new Date(currentTime.getTime()+1000*2);
//		dateString = formatter.format(newTime1);
//		System.out.println(dateString);
//		System.out.println(newTime1.after(newTime));
//
//
////		System.out.println(s.getInfo());
//		ShopHistory s=new ShopHistory();
//		s.addNew(3,"test",newTime1);
//		shopHistoryRepo.save(s);

//		List<Address> l =addressRepo.findByUserId(2);
//		List<String> ss=new ArrayList<>();
//		for(Address a:l)
//		{
//			ss.add(a.getAddress());
//		}
//		System.out.println(ss.size());
//
//		System.out.println(ss.get(0));
//		System.out.println(ss.get(1));
	}
}
