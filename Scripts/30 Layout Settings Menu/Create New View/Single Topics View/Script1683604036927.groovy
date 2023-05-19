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

String viewName = 'SingleView-Topic'

WebUI.openBrowser('')

WebUI.navigateToUrl('http://lonenpsdevqa53/apstorytelling/#/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_d12e46 (8)'), 
    'administrator')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_26a78b (6)'), 
    'xSsKH/5z2FOPt3ox77z3yw==')

WebUI.sendKeys(findTestObject('Object Repository/Page_AP Storytelling/input_AP STORYTELLING_mauto block text-inpu_26a78b (6)'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Create New View'))

viewName += Math.floor(Math.random() * 1000).toInteger().toString()

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Save_mdl-textfield-2'), viewName)

WebUI.verifyElementPresent(findTestObject('singleViewRadio'), 100)

WebUI.verifyElementPresent(findTestObject('topicsRadio'), 100)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/button_Save (2)'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_View1'), viewName)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Views'))

def viewElementsCount = WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded\').childElementCount', 
    null)

for (def i = 1; i <= viewElementsCount; i++) {
    String viewText = WebUI.executeJavaScript(('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded > div:nth-child(' + 
        i) + ') > planning-view-item > div > div.planning-view-item-container > div.planning-view-item-title.bold\').innerText;', 
        null)

    if (viewText == viewName) {
        println((viewText + ' ************** FOUND *************** ') + viewName)

        break
    }
    
    println(viewText)
}

//WebUI.verifyElementText(findTestObject('viewVerify'), viewName)
WebUI.closeBrowser()

