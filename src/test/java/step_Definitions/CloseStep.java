package step_Definitions;

import java.time.Duration;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass {
	
	@Then("close the browser")
	public void close_the_browser()
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.quit();
	   
	   log.info("browser closed");
	}

}
