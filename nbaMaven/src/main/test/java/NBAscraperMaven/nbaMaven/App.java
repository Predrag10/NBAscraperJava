package NBAscraperMaven.nbaMaven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	public static void findStats(WebDriver driver, String playerName) {
		WebElement table = driver.findElement(By.xpath("//div[@class='table_outer_container']//div[@id='div_per_minute']//table[@id='per_minute']/tbody"));
		
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		List<WebElement> seasons = new ArrayList<WebElement>();
		List<WebElement> allPointAvg = new ArrayList<WebElement>();
		
		System.out.println(playerName);
		for (int i = 0; i < allRows.size(); i++) {			
			seasons.addAll(allRows.get(i).findElements(By.xpath(
				("//div[@class='table_outer_container']//div[@id='div_per_minute']//table[@id='per_minute']/tbody/tr/th"))));
		allPointAvg.addAll(allRows.get(i).findElements(By.xpath(
				("//div[@class='table_outer_container']//div[@id='div_per_minute']//table[@id='per_minute']/tbody/tr/td[@data-stat='fg3a_per_mp']"))));
			System.out.println(seasons.get(i).getText() + " " + allPointAvg.get(i).getText());
		}
	}

	public static void main(String[] args) {
		if (args.length >= 2) {
			String playerName = args[0];
			for (int i = 1; i < args.length; i++) {
				playerName += " " + args[i];
			}
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.basketball-reference.com/leagues/NBA_2020_per_game.html");

			WebElement search = driver.findElement(By.name("search"));
			search.sendKeys(playerName);
			search.sendKeys(Keys.RETURN);

			try {
				driver.findElement(By.partialLinkText(playerName)).click();
				findStats(driver, playerName);
			} catch (Exception e) {
				findStats(driver, playerName);
			}
			driver.quit();
		} else {
			System.out.println("Enter name and surname of a player");
		}
	}
}
