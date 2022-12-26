package SuleymanCan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_SeleniumPractise {


        public static void main(String[] args) throws InterruptedException {
            //      1. Launch browser
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //  2. Navigate to url 'http://automationexercise.com'
            driver.navigate().to("http://automationexercise.com");

            //              3. Click on 'Products' button
            driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //  4. Verify user is navigated to ALL PRODUCTS page successfully
            WebElement allProducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
            if (allProducts.isDisplayed()){
                System.out.println("All products test PASSED");
            }else {
                System.out.println("All products test FAILED");
            }

        //  5. Enter product name in search input and click search button
            driver.findElement(By.id("search_product")).sendKeys("jeans");
            driver.findElement(By.id("submit_search")).click();

        //  6. Verify 'SEARCHED PRODUCTS' is visible
            WebElement searchedProd = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
            if (searchedProd.isDisplayed()){
                System.out.println("Search Products visible test PASSED");
            }else {
                    System.out.println("Search Products visible test FAILED");
            }
            Thread.sleep(1000);

        //  8. Add those products to cart
            driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

            driver.findElement(By.xpath("(//a[text()='Add to cart'])[3]")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

            driver.findElement(By.xpath("(//a[text()='Add to cart'])[5]")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //  9. Click 'Cart' button and verify that products are visible in cart
            driver.findElement(By.xpath("//a[text()=' Cart']")).click();
            WebElement urun1 = driver.findElement(By.xpath("//a[text()='Soft Stretch Jeans']"));
            WebElement urun2 = driver.findElement(By.xpath("//a[text()='Regular Fit Straight Jeans']"));
            WebElement urun3 = driver.findElement(By.xpath("//a[text()='Grunt Blue Slim Fit Jeans']"));
            if (urun1.isDisplayed() && urun2.isDisplayed() && urun3.isDisplayed()){
                System.out.println("Urunler sepete eklenmis, test PASSED");
            }else {
                System.out.println("Urunler sepete eklenmis, test FAILED");
            }


        //  10. Click 'Signup / Login' button and submit login details

            driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
            WebElement loginEmail = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
            loginEmail.sendKeys("suleymancan157@hotmail.com");
            WebElement loginPassword = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
            loginPassword.sendKeys("Aysel.turg30" + Keys.ENTER);


        //  11. Again, go to Cart page

            driver.findElement(By.xpath("//a[text()=' Cart']")).click();



        //  12. Verify that those products are visible in cart after login as well
            WebElement sonurun1 = driver.findElement(By.xpath("//a[text()='Soft Stretch Jeans']"));
            WebElement sonurun2 = driver.findElement(By.xpath("//a[text()='Regular Fit Straight Jeans']"));
            WebElement sonurun3 = driver.findElement(By.xpath("//a[text()='Grunt Blue Slim Fit Jeans']"));
            if (sonurun1.isDisplayed() && sonurun2.isDisplayed() && sonurun3.isDisplayed()){
                System.out.println("Login'den sonra urunler sepete eklenmis, test PASSED");
            }else {
                System.out.println("Login'den sonra Urunler sepete eklenmemis, test FAILED");
            }

            Thread.sleep(2000);
            driver.close();


        }
}





