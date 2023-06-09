package sharedKeywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.interactions.Action

import org.openqa.selenium.interactions.Actions

import org.openqa.selenium.WebDriver

import java.time.Duration

public class DragDrop {

	@Keyword

	def dragdrop(TestObject to,TestObject destination,Integer intX,Integer intY) {

		println('dragdrop function;')

		def eleto = WebUiCommonHelper.findWebElement(to, 30)

		def eledest = WebUiCommonHelper.findWebElement(destination, 30)

		WebDriver driver = DriverFactory.getWebDriver()

		Actions build = new Actions(driver)

				.moveToElement(eleto)

				.pause(Duration.ofSeconds(3))

				.clickAndHold(eleto)

				.moveByOffset(1, 0)

				.moveToElement(eledest,intX,intY)

				//.moveByOffset(40, 0)

				.pause(Duration.ofSeconds(5))

				.release().perform()

	}
}