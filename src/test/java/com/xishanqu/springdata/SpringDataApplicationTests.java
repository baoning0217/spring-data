package com.xishanqu.springdata;

import com.xishanqu.springdata.common.dto.ProductDto;
import com.xishanqu.springdata.mongodb.service.ProductMongoService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	@Autowired
	private ProductMongoService productMongoService;

	//引入 ContiPerf 进行性能测试
	@Rule
	public ContiPerfRule contiPerfRule = new ContiPerfRule();


	private String productId = "5ccb94bca4ece010f9c58b93";
	private ProductDto productDto = new ProductDto();


	@Test
	@PerfTest(threads = 100)
	public void testProductStock() throws Exception{

		productDto.setProductId(productId);
		boolean result = productMongoService.orderProduct(productDto);
		Assert.assertEquals(productId, result);
		//System.out.println("productMongoService==="+ result);

	}


}
