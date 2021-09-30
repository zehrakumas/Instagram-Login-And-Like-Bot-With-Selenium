package InstagramLoginAndLikeBot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
        protected static ChromeDriver driver;
        private ExpectedConditions ExceptedConditions;
        String BASE_URL="https://www.instagram.com/";
        //bu method instagram sayfamizi acmamizi sagliyor
        public App(){
            System.setProperty("webdriver.chrome.driver","C:/Users/Zehra/Desktop/chromedriver.exe");
            driver=new ChromeDriver();
            driver.get(BASE_URL);
            driver.manage().window().maximize();
        }
        By usernameLocator=new By.ByCssSelector("input[type='text']");
        By passwordLocator=new By.ByCssSelector("input[name='password']");
        By loginLocator=new By.ByCssSelector("button[type='submit']");
        By logoLocator=new By.ByCssSelector("img[alt='Instagram']");
        By kullaniciadiLocator=By.xpath("//div/h1");
        By firstimgLocator=By.className("_9AhH0");
        By likeLocator=By.className("fr66n");
        By htmlTag=By.tagName("html");
        By gonderisayisiLocator=By.className("g47SY");

        public void Login(String username,String password){
            //sayfa acildiktan sonra veri girisi alanlarini gorebilmesi icin 5 saniye bekliyoruz
            waitLocator(usernameLocator);
            driver.findElement(usernameLocator).sendKeys(username);
            driver.findElement(passwordLocator).sendKeys(password);
            driver.findElement(loginLocator).click();

        }

        //sectigimiz kisi profiline gitmek
        public void navigateToProfile(String profileName){
            waitLocator(logoLocator);
            driver.navigate().to(BASE_URL.concat(profileName));
        }
        //ilk posta tiklama methodu
        public void firstimgClick(){
            waitLocator(kullaniciadiLocator);
            driver.findElements(firstimgLocator).get(0).click();
        }
        //begendik ve sonraki gonderiye ulastik
        public void likeClick(){
            int count=getCount();
            while(count>0){
                waitLocator(likeLocator);
                driver.findElement(likeLocator).click();
                waitLocator(likeLocator);
                driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
                count--;
            }
        }
        private int getCount(){
            String count=driver.findElement(gonderisayisiLocator).getText();
            return Integer.parseInt(count);
        }



        //bekleme methodu yaptik
        public void waitLocator(By locator){
            WebDriverWait wait=new WebDriverWait(driver,5);
            wait.until(ExceptedConditions.visibilityOfElementLocated(locator));
        }

    }


