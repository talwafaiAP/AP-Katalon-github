import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl('http://lonenpsdevqa53/apstorytelling/#/login')
//
//WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46 (7) (1)'), 
//    'administrator')
//
//WebUI.setEncryptedText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_26a78b (5) (1)'), 
//    'xSsKH/5z2FOPt3ox77z3yw==')
//
//WebUI.sendKeys(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_26a78b (5) (1)'), 
//    Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/mat-icon_more_horiz'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Copy to Clipboard (1)'))

not_run: WebUI.waitForElementPresent(findTestObject('Object Repository/Page_AP Storytelling Playbook/h4_Error'), 0)

not_run: WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

