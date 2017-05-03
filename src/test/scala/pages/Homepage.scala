package pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.scalatest.selenium.WebBrowser

/**
  * Created by Roger.Souke on 03/05/2017.
  */
class Homepage extends WebBrowser {

    @FindBy(xpath=".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")
    var outDateAssert: WebElement = _


    println("pages.Homepage!")



}
