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
import javax.script.*
import org.openqa.selenium.WebElement as WebElement
import org.apache.groovy.util.Arrays.*

WebUI.callTestCase(findTestCase('Login (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (4)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Edit Team Settings (1)'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_AP STORYTELLING_mdl-textfield-6d6bef92'), 
    '')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Section Title_icon-ApplicationMenu hand fs22'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Team Views'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Planning Views and Searches'), 
    'Planning Views and Searches')

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

