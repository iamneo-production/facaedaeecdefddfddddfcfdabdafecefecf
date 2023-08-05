package com.examly.springapp;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



// @SpringBootTest(classes = SpringappApplication.class)
// @AutoConfigureMockMvc
// @RunWith(SpringRunner.class)
public class SpringApplicationTests {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception
	 {
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	    driver.manage().window().maximize();
	}

	@Test
//Checking the title of iamNeo (Home - iamneo)
	public void iamNeo() throws InterruptedException 
	{
        driver.navigate().to("http://iamneo.ai");
		 String title =driver.getTitle();
		Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");
	}
	@Test
//Moving to FACEBOOK
	public void nextPage() throws InterruptedException 
	{
	    driver.navigate().to("https://www.facebook.com");
		 String title =driver.getTitle();
		// Assert.assertEquals(title, "Facebook â€“ log in or sign up");

	}
	@Test
//Back to iamNeo
	public void backPage() throws InterruptedException 
	{
		driver.navigate().back();
		String title =driver.getTitle();
		// Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");

	}
	@Test
//Current URL
public void currentURL() throws InterruptedException 
{
		 String title =driver.getCurrentUrl();
		 System.out.println(title);
		// Assert.assertEquals(title, "");
		driver.navigate().forward();
		driver.navigate().refresh();

}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}


	// @Autowired
    // private MockMvc mockMvc;	

	// //Add A New Task
	// @Test
    // public void test_case1() throws Exception {
		
	// 	String dataOne = "{\"taskId\":\"12211\",\"taskHolderName\":\"Gowthaman M\",\"taskDate\":\"4/15/2021\",\"taskName\":\"Spring Projects\",\"taskStatus\":\"In Progress\"}";
	//  	mockMvc.perform(MockMvcRequestBuilders.post("/saveTask")
	//  			.contentType(MediaType.APPLICATION_JSON)
	//  			.content(dataOne)
	//  			.accept(MediaType.APPLICATION_JSON))
	//         	.andExpect(status().isOk())
	//         	.andReturn();
	 	
    // }
	
	
	// //Get All Task
	// @Test
    // public void test_case2() throws Exception {
		
	//  	mockMvc.perform(MockMvcRequestBuilders.get("/alltasks")
	//  			.contentType(MediaType.APPLICATION_JSON)
	//  			.accept(MediaType.APPLICATION_JSON))
	//         	.andExpect(status().isOk())
	// 	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].houseNo").exists())
	// 	        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	//         	.andReturn();
	 	
    // }
	
	// //Get A Task By ID
	// @Test
	// public void test_case3() throws Exception {
		
	// 	mockMvc.perform(MockMvcRequestBuilders.get("/getTask")
	// 			.param("taskId","12211")
	// 			.contentType(MediaType.APPLICATION_JSON)
	// 	 		.accept(MediaType.APPLICATION_JSON))
	// 	        .andExpect(status().isOk())
	// 	        .andExpect(jsonPath("$.taskHolderName").value("Gowthaman M"))
	// 	        .andExpect(jsonPath("$.taskDate").value("4/15/2021"))
	// 	        .andExpect(jsonPath("$.taskName").value("Spring Projects"))
	// 			.andExpect(jsonPath("$.taskStatus").value("In Progress"))
	// 	        .andReturn();
			
	// }
	
	// //Delete A Task
	// @Test
	// public void test_case4() throws Exception {
		
	// 	mockMvc.perform(MockMvcRequestBuilders.get("/deleteTask")
	// 			.param("taskId","12211")
	// 			.contentType(MediaType.APPLICATION_JSON)
	// 	 		.accept(MediaType.APPLICATION_JSON))
	// 	        .andExpect(status().isOk())
	// 	        .andReturn();
			
	// }


}
