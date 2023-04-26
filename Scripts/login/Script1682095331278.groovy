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

def URL = GlobalVariable.protocol + '://' + GlobalVariable.server + '/apstorytelling/'
WebUI.openBrowser(URL)
WebUI.maximizeWindow()
switch(GlobalVariable.playbookVersion) {   
	case 9.5: CustomKeywords.'playbook95.login.test'(); break;
	case 9.34: CustomKeywords.'playbook934.login.test'(); break;
	default: CustomKeywords.'playbook94.login.test'(); break;
 }
WebUI.closeBrowser()



// Javascript
//document.evaluate('/html/head/script[4]/text()', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.data.slice(6966,6969)
//println(WebUI.executeJavaScript("return document.evaluate('/html/head/script[4]/text()', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.data.slice(6966,6969)", null))
//String js = 'function x(){return document.evaluate(\'/html/head/script[4]/text()\', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.data.slice(6966,6969)};x();'
//
//String result = WebUI.executeJavaScript(js, null)
//
//println(result)

//WebUI.click(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46'))


