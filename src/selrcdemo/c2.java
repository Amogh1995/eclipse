

	package selrcdemo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





	public class c2
	{

	    public static void main(String[] args) {
	        // declaration and instantiation of objects/variables
	    	/*;System.setProperty("webdriver.gecko.driver", "D:/Amog java/geckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        */
	        
	        System.setProperty("webdriver.chrome.driver", "D:/Amog java/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();     


	
	        
	        String baseUrl = "http://google.com";
	        String expectedTitle = "Google";
	        String actualTitle = "";

	        // launch Firefox and direct it to the Base URL
	        driver.get(baseUrl);

	        // get the actual value of the title
	        actualTitle = driver.getTitle();
	        driver.findElement(By.name("q")).sendKeys("Automation");
	        driver.findElement(By.xpath(".//*[@id='_fZl']")).click();
	        /*
	         * compare the actual title of the page witht the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	       
	        /*close Firefox
	        driver.close();
	       
	        // exit the program explicitly
	        System.exit(0);*/
	    }

	}


