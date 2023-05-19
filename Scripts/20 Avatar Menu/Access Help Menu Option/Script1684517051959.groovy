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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://lonenpsdevqa53/apstorytelling/#/login')

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46 (1)'), 
    'administrator')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_26a78b'), 
    'xSsKH/5z2FOPt3ox77z3yw==')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling/button_Login (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/img_Playbook_avatar (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/a_Help'))

WebUI.switchToWindowTitle('404 - File or directory not found.')

WebUI.verifyElementText(findTestObject('Object Repository/Page_404 - File or directory not found/h1_Server Error (1)'), 
    'Server Error')

WebUI.takeScreenshot('C:\\playbook94\\Help\\pass.png')

not_run: WebUI.closeBrowser()

