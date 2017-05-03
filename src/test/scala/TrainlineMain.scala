import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.PageFactory
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import pages.Homepage

/**
  * Created by Roger.Souke on 28/04/2017.
  */
class TrainlineMain extends FeatureSpec with GivenWhenThen with WebBrowser with Matchers{
  System.setProperty("webdriver.chrome.driver",
  "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe")
  implicit val driver: WebDriver = new ChromeDriver()
  val homepage = PageFactory.initElements(driver, classOf[Homepage])

  feature("To test the train line website") {
    scenario("Exercise One") {

      Given("I am on the trainline website")
      go to "https://www.thetrainline.com"

      When("I enter in the two stations and click submit")

      searchField("originStation").value = "London"
      searchField("DestinationStation").value = "Brighton"

      And("I click submit")

      click on cssSelector("span.glyphicon.glyphicon-remove.is-alone")
      click on "submitButton"

      Then("The timetable page and prices will be visible")
    }
    scenario("Exercise Two") {

      Given("I am on the trainline website")
      go to "https://www.thetrainline.com"

      pageTitle should include("Trainline")

      When("I enter in the two stations and click submit")

      searchField("originStation").value = "London"

      searchField("DestinationStation").value = "Brighton"

      And("I click submit")

      click on cssSelector("span.glyphicon.glyphicon-remove.is-alone")
      click on "submitButton"

      Then("The timetable page and prices will be visible")
    }

  }

  scenario("Exercise Three") {
    Given("I am on the trainline website")
    go to "https://www.thetrainline.com"

    pageTitle should include("Trainline")

    When("I enter in the two stations")

    searchField("originStation").value = "London"

    searchField("DestinationStation").value = "Brighton"

    And("I click click return")

    click on "journey-type-return"
    click on cssSelector("span.glyphicon.glyphicon-remove.is-alone")

    click on cssSelector(".btn.btn-link.btn-xs.tomorrow.pull-right")
    click on cssSelector(".btn.btn-link.btn-xs.same-day.pull-left")
    click on "submitButton"
    Then("The timetable page and prices will be visible")

    Then("The timetable will show tomorrow's date")
    val dayFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("E d")
    val day: String = LocalDate.now().plusDays(1).format(dayFormat)
    val monthFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM")
    val month: String = LocalDate.now().plusDays(1).format(monthFormat)
    val yearFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("YYYY")
    val year: String = LocalDate.now().plusDays(1).format(yearFormat)

    val expectedDate: String = day + "th " + month + " " + year


    val actualDate = find(xpath(".//*[@id='tickets']/div/div[2]/table/thead/tr[1]/th[2]/div/h3")).get.underlying.getText

    println(expectedDate)
    actualDate shouldBe expectedDate
  }
}

feature("To automate the trainline website"){
  scenario("Exercise Four") {

  }

}