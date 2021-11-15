import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        //case1
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maksim.Subach\\IdeaProjects\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement sigIn = driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]"));
        sigIn.click();
        WebElement email = driver.findElement(By.xpath("//input[@id = 'email']"));
        email.sendKeys("m2.suboch@gmail.com");
        WebElement pw = driver.findElement(By.xpath("//input[@id = 'passwd']"));
        pw.sendKeys("2407251");
        WebElement sigInBtn = driver.findElement(By.xpath("//button[@name= 'SubmitLogin']"));
        sigInBtn.click();
        WebElement userName = driver.findElement(By.xpath("//*[@class= 'account']/span"));
        System.out.println(userName.getText().equalsIgnoreCase("Max Max"));

        //case2
        WebElement searchField = driver.findElement(By.xpath("//*[@id= 'search_query_top']"));
        searchField.sendKeys("Dress");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@name= 'submit_search']"));
        searchBtn.click();
        WebElement sortByAz = driver.findElement(By.xpath("//select/option[@value= 'name:asc']"));
        sortByAz.click();
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//ul[@class='product_list grid row']//div[@class='right-block']//h5//a"));
        List<String> products = new ArrayList<>();

        for (WebElement element : listOfProducts) {
            products.add(element.getText());
        }
        List<String> sortedProducts = new ArrayList<String>(products);
        sortedProducts.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(products.equals(sortedProducts));
        Thread.sleep(1000);


        //case3
        WebElement dressTab = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        dressTab.click();
                List<String> dressName = new ArrayList<String>();
        List<String> dressPrice = new ArrayList<>();
        for (int i = 1; i < 6; i = i + 2) {
            WebElement cartBtn = driver.findElement(By.xpath("//ul[@class='product_list grid row']//li[" + i + "]//a[@class='button ajax_add_to_cart_button btn btn-default']"));
            cartBtn.click();
            Thread.sleep(1000);
            WebElement name = driver.findElement(By.xpath("//span[@id='layer_cart_product_title']"));
            dressName.add(name.getText());
            WebElement price = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
            dressPrice.add(price.getText());

            WebElement continueBtn = driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']"));
            continueBtn.click();
            Thread.sleep(1000);
        }
        System.out.println(dressName);
        System.out.println(dressPrice);
        WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        cart.click();
        List<WebElement> dressNamesCart = driver.findElements(By.xpath("//td//p[@class='product-name']"));
        List<String> dressNameCart = new ArrayList<String>();
        for (WebElement element : dressNamesCart) {
            dressNameCart.add(element.getText());


        }
        System.out.println(dressNameCart);
        System.out.println(dressName.equals(dressNameCart));
        List<WebElement> dressPricesCart = driver.findElements(By.xpath("//td[@class='cart_total']//span[@class='price']"));
        List<String> dressPriceCart = new ArrayList<>();
        for (WebElement element : dressPricesCart) {
            dressPriceCart.add(element.getText());

        }
        System.out.println(dressPriceCart);
        System.out.println(dressPrice.equals(dressPricesCart));

        driver.close();


    }
}

