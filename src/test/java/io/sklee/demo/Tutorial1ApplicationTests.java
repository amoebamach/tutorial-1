package io.sklee.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Tutorial1ApplicationTests {

	@Value("${noKey:default test Value}")
	private String defaultValue;
	
	@Value("${propertyTest}")
	private String propertyTest;
	
	@Value("${propertyTestList}")
	private String[] propertyTestArray;
	
	@Value("#{'${propertyTestList}'.split(',')}")
	private List<String> propertyTestList;
	
	@Value("${property.test.value}")
	private String propertyTestValue;
	
	@Test
	public void testValue() {
		assertThat(defaultValue, is("default test Value0"));
		
		assertThat(propertyTest, is("test"));

		assertThat(propertyTestArray[0], is("1"));
		assertThat(propertyTestArray[1], is("2"));
		assertThat(propertyTestArray[2], is("3"));

		assertThat(propertyTestList.get(0), is("1"));
		assertThat(propertyTestList.get(1), is("2"));
		assertThat(propertyTestList.get(2), is("3"));
		
		assertThat(propertyTestValue, is("property call test"));
	}
	
	@Test
	void contextLoads() {
	}

}
