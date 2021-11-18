import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        String login = "m2.suboch@gmail.com";
        String password = "2407251";
        String searchParameter = "Dress";
        String userNameValid = "Max Max";
        //case1
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maksim.Subach\\IdeaProjects\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement sigIn = driver.findElement(By.className("login"));
        sigIn.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(login);
        WebElement pw = driver.findElement(By.id("passwd"));
        pw.sendKeys(password);
        WebElement sigInBtn = driver.findElement(By.xpath("//button[@name= 'SubmitLogin']"));
        sigInBtn.click();
        WebElement userName = driver.findElement(By.xpath("//*[@class= 'account']/span"));
        Assert.assertEquals(userName.getText(), userNameValid);


        //case2
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(searchParameter);
        WebElement searchBtn = driver.findElement(By.name("submit_search"));
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
        Assert.assertEquals(products, sortedProducts);
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
            WebElement name = driver.findElement(By.id("layer_cart_product_title"));
            dressName.add(name.getText());
            WebElement price = driver.findElement(By.id("layer_cart_product_price"));
            dressPrice.add(price.getText());

            WebElement continueBtn = driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']"));
            continueBtn.click();
            Thread.sleep(1000);
        }

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

        Assert.assertEquals(dressPrice, dressPriceCart);

        driver.close();


    }
}

