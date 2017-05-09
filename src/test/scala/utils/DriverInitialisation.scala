package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

/**
  * Created by Roger.Souke on 08/05/2017.
  */

object SingletonDriver {

  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe")
  val driver: WebDriver = new ChromeDriver()
}

trait DriverInitialisation {
  implicit lazy val driver = SingletonDriver.driver
}
