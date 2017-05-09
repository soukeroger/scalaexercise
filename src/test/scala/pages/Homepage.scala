package pages

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.openqa.selenium.WebDriver

import utils.BaseFeatureSpec
import scala.util.Random



//import org.openqa.selenium.{WebDriver, WebElement}
//import org.openqa.selenium.support.FindBy
//import org.scalatest.Matchers
//import org.scalatest.selenium.WebBrowser

//import scala.reflect.internal.util.Origins.OriginId

/**
  * Created by Roger.Souke on 03/05/2017.
  */
object Homepage extends BaseFeatureSpec {
  var numberOfAdults: String = ""


  //  @FindBy(xpath = ".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")
  //  var outDateAssert: WebElement = _
  //@FindBy(xpath = "..//*[@id='extendedSearchForm']/div[3]/div[1]/div/div[1]/button[2]")
  //var tommorrowButton: WebElement = _
  //  @FindBy(xpath = ".//*[@id='extendedSearchForm']/div[3]/div[2]/div/div[1]/button[2]")
  //  var nextDayButton: WebElement = _

  def outDateAssertText(implicit driver: WebDriver): Unit = {

    import scala.util._

    val findOutDate = find(xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.text
    findOutDate should include("Sun 7th May 2017")
  }

  def goToWebsite(implicit driver: WebDriver): Unit = {
    go to "https://www.trainline.com"
  }

  def assertpageTitle(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='master']/header/div/div/div[1]/a/i")
  }

  def returnButton(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='extendedSearchForm']/div[2]/label[2]")
  }

  def tommorrowButton(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='extendedSearchForm']/div[3]/div[1]/div/div[1]/button[2]")
  }

  def nextDayButton(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='extendedSearchForm']/div[3]/div[2]/div/div[1]/button[2]")
  }

  def enterLocation(implicit driver: WebDriver, originId: String, destination: String): Unit = {
    searchField("originStation").value = "London"
    searchField("DestinationStation").value = "Brighton"
  }

  def SelectNoOfPeople() = {
    val random = Random.nextInt(9)
    val exactNumber = (random + 1).toString
    numberOfAdults = exactNumber + " adults"
    click on xpath(".//*[@id='extendedSearchForm']/div[4]/div[1]/div/button")
    click on xpath(".//*[@id='adults']")
    singleSel("adults").value = exactNumber
    click on xpath(".//*[@id='extendedSearchForm']/div[4]/div[1]/div/div/button")

  }


  def submitButton(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='submitButton']")
  }

  def outDateAssert(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")
  }

  def matchTest(day: String): String = day match {
    case "1" | "21" | "31" => "st"
    case "2" | "22" => "nd"
    case "2" | "23" => "rd"
    case _ => "th"
  }

  def outDateassert(implicit driver: WebDriver): Unit = {
    val weekFormat = DateTimeFormatter.ofPattern("E")
    val week = LocalDate.now().plusDays(1).format(weekFormat)
    val dayFormat = DateTimeFormatter.ofPattern("d")
    val day: String = LocalDate.now().plusDays(1).format(dayFormat)
    val dateValue = matchTest(day)
    val monthFormat = DateTimeFormatter.ofPattern("MMM")
    val month = LocalDate.now().plusDays(1).format(monthFormat)
    val yearFormat = DateTimeFormatter.ofPattern("y")
    val year = LocalDate.now().plusDays(1).format(yearFormat)

    val expectedDay = week + " " + day + dateValue + " " + month + " " + year

    val actualDate = find(xpath(".//*[@id='tickets']/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.underlying.getText

    actualDate shouldBe expectedDay
  }

  def TimetablePage(implicit driver: WebDriver): Unit = {
    click on xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[2]/th[2]/div")

  }

}