package playbook95
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

import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import org.openqa.selenium.Keys as Keys

class login {

	def test() {
		println('login from Keywords')
		WebUI.verifyElementPresent(findTestObject('Object Repository/sharedObjects/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46'),
				0, FailureHandling.STOP_ON_FAILURE)

		WebUI.setText(findTestObject('Object Repository/sharedObjects/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46'),
				GlobalVariable.username)

		WebUI.verifyElementPresent(findTestObject('Object Repository/sharedObjects/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46_1'),
				0, FailureHandling.STOP_ON_FAILURE)

		WebUI.setEncryptedText(findTestObject('Object Repository/sharedObjects/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46_1'),
				GlobalVariable.password)

		WebUI.click(findTestObject('Object Repository/playbook9.5/loginPage/playbook9.5-button_Login'))

		println('login button clicked')

		//		def playbookVerify=

		//WebUI.verifyElementText(findTestObject(playbookVerify), 'Playbook', FailureHandling.STOP_ON_FAILURE)

		//WebUI.takeScreenshot(GlobalVariable.screenshotPath)

		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_AP Storytelling/span_Playbook'), 1000, FailureHandling.STOP_ON_FAILURE)) {

			//Get current date time
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-dd-yyyy_HH-mm-ss");
			String formatDateTime = now.format(formatter)
			String screenshotPath= GlobalVariable.screenshotPath +File.separator + GlobalVariable.profileName+ File.separator+ 'Login-Success-'+ formatDateTime+'(CST).png'

			println(screenshotPath)

			WebUI.takeScreenshot(screenshotPath)

			println('\n-- LOGGED IN SUCCESSFULLY --\n')
		} else {
			println('xxxxxxxxxxxxxxxxxx LOGIN FAILED  xxxxxxxxxxxxxxxxx')
		}
	}
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}