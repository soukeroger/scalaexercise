package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.openqa.selenium.WebDriver
import pages.(Homepage, TimetablePage)

/**
  * Created by Roger.Souke on 08/05/2017.
  */
object TimetablePage {
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

    val actualDate = find (xpath(".//*[@id='tickets']/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.underlying.getText

    actualDate shouldBe expectedDay
  }


  }
def checkNoOfAdults(".//*[@id='timetable']/div/span [3]")).get.text shouldBe. Homepage.numberOfAdults {

}


}
