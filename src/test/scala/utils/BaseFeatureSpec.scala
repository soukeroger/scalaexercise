package utils

import org.scalatest.selenium.WebBrowser
import org.scalatest._


trait BaseFeatureSpec extends FeatureSpec with GivenWhenThen with DriverInitialisation with Matchers with WebBrowser {
   override def beforeEach() = {
     driver.manage().deleteAllCookies()
     driver.manage().window().maximize()
   }
}
