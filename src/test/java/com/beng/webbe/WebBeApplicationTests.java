package com.beng.webbe;

import com.beng.webbe.model.ShopSetting;
import com.beng.webbe.repository.ShopSettingRepo;
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
    private ShopSettingRepo shopSettingRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDate()
	{
		Date planUpdatedAt = new Date(200,1,1);
		Date today = new Date();
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(today);

		Calendar calendar2 = new GregorianCalendar();
		calendar2.setTime(planUpdatedAt);
		calendar2.add(calendar2.DATE,7); //把日期往后增加一天,整数  往后推,负数往前移动
//        System.out.println(calendar.getTime()); //这个时间就是日期往后推一天的结果

		System.out.println(calendar1.after(calendar2));
	}

	@Test
    public  void testCRUD()
    {
        ShopSetting shopSetting = new ShopSetting();
        shopSetting.setSettings(0,0,0,"123",0);
        shopSettingRepo.save(shopSetting);
    }

//	@Test
//	public void mytest(){
//		Services services=new Services();
//		System.out.println(services.encodeMD5Hex
//				("DGFSWER145423dgfsaag2343dsDASF34dfaDFS3dsgfDFS32df423234543cvdsDFSDSFRQEW2fDS2fsdADSD21DSFFDSSDAF3222222224324234FSD"));
//	}

}
