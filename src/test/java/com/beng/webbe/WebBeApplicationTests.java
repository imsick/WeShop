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
				DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2018071960663535", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFymmhgHG+8Tk6\n" +
				"x8Q2fFw8CupvI+BEIPa4LsRZfH8xyGJhimU4f4useIipCZaRbozBGNAgd5QcohlC\n" +
				"IEEaiseR4Q/Y5Ezq2+wGwZ1Uth604YmGtLTXxXuATnp3F1Yr6bwFPgbvTGDe0fAR\n" +
				"8H/lrfkP6MZA45OHmeFJN4TM6p7bvi2bykN7RG3yz32ILkzi3LCn6AWlGXkZRX+i\n" +
				"qzJsx2yUCUpH/whFIPaw3h2659ZKqPGdD4YTrc6SP5QrC1V0ovIAVsxYM6ZVYr2t\n" +
				"bNzIyzx+ET/slMo2IaPpXHIuqzLukcVQ+Td3BU74iJQTdlVNxYENYrNduV5weqvi\n" +
				"qaYIGPslAgMBAAECggEAMHHndXs0YQRMdC1Bzeaf4MT7rsUmxQkd5PbveMuZi+P8\n" +
				"1M9FA5WZ7GCJeH20t2JQb2tYbttbF7hMX3nu+EVNpFlvvDwO6ud65BzAIGOLGdq0\n" +
				"CJ5yPPdNzJtsO4cnwBG7z7zlje8zOuBI4Nv7N5JpEpB9Hp+fHvN9zqUejeJZjpCT\n" +
				"225CW8h0mlM6is66N8khNZFzUc8MUAQ/avaHpfXGjOoBTqAr82XihPHXBfBOPwJd\n" +
				"9gAOrniV5cdg+uMQuvYekVbdKPVixonPNDizFWEY9xGxN3ZM6vOPle/mxYfkfPqo\n" +
				"npNE1UncYy+ze6R4dbR8JEwgntnLItcRSeQqTG9ncQKBgQDraY9IORI6yutE965F\n" +
				"M1v0AOAT4OWzAV2wzXJR1BrwjfoKDQ6vBQytBWRhZ7tlx2mA2c/dPVMufMJhDQmU\n" +
				"ACMp2Ehtqma07iIhpepq2Qj2VwqRDm+7R/UZP5H6YfzskekzA9wk/jcgK7k/dg44\n" +
				"h+Lgx53sZwWr7XkdoulPDhrKuwKBgQDXFpMM9drs4DDzICQWowKKBZfYtSxXC5Wm\n" +
				"6UkqpuB3pJNUgZj5shx8iABGYDKwME68OTuhNKa5XzaJhSis4aqwoCen2hiKonFR\n" +
				"vgWdJ6Nsvo4cQPehwtnjwfn7cdx+Cf8tK492PBh5fAwEwcTt2cYEenUFj4K8lLSO\n" +
				"TCrvLSCjnwKBgQDDNN0jPm/nYKyGm/teVqBBTRiCY1MVhGR0X2gUgpV0M8bK3tj2\n" +
				"OHGyZ249dw7l7t2FgxfilR+MxNdKMs1mdFa0NCybA1n3Xh/fVv1zbFUKMFMKxbXQ\n" +
				"znJnZVdfEDHy2WtOajz6T/LWMmuCPBq+ta9kRSKnDSae0mRENvrQGxoMUQKBgGz/\n" +
				"562dukBorOXI2AEQwuynQPh1d+700/YuKwIOZ5q6MF+W/assc/s4AMupXIalNIF2\n" +
				"j512TTeL5Nt0O9TA1/uCbhZGFEHNaJgAMGAgAlXNi78NvXCgikM9vi2K2i6Vale9\n" +
				"x4onkk+eaYjPmbjfr9X9KOiUfbCLu6SRPQDQYcYJAoGBAOfdkgqm3UFjg1q73312\n" +
				"zf4EkWuxCAw5u3Ckwe6gYISlSpzWDmPW7Xf4Ci45JCn9BXarc2wLLshIhbn3Mnk0\n" +
				"iyN1DScx9pcVzjyapWZPNPlhtRcwoO1SqV/fUhAA3q0BQ8ezrdRRB+pZQyRIx5Hi\n" +
				"WNaoYJr4okee0ej4X9Qm+Svt\n", "json", "utf-8",
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
