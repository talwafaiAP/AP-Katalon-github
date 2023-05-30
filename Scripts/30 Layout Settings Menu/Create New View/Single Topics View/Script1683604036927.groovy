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

// Javascript actions
String clickHamburgerMenu='document.querySelector(\'body > app-root > main > loader > div > top-bar > div > div.hamburger-menu.left.mright10 > span\').click()'
clickShowAllViews='document.querySelector(\'body > app-root > main > loader > div > top-bar > div > div.hamburger-menu.left.mright10 > mdl-popover > ul > li:nth-child(1)\').click()'

WebUI.callTestCase(findTestCase('Login (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

String viewName = 'SingleView-Topic'

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Create New View'))

viewName += Math.floor(Math.random() * 1000).toInteger().toString()

println("View name: "+ viewName)

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Save_mdl-textfield-2'), viewName)

WebUI.verifyElementPresent(findTestObject('singleViewRadio'), 100)

WebUI.verifyElementPresent(findTestObject('topicsRadio'), 100)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/button_Save (2)'))

WebUI.delay(10)

//WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_View1'), viewName)

//WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (1)'))
WebUI.executeJavaScript(clickHamburgerMenu, null);

//WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Views'))

WebUI.executeJavaScript(clickShowAllViews, null)

def viewElementsCount = WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded\').childElementCount', 
    null)

Boolean found=false;
String foundString= ' ************** FOUND *************** ';

for (def i = 1; i <= viewElementsCount; i++) {
	println("Views count: "+ viewElementsCount+"   i: "+i)
    String viewText = WebUI.executeJavaScript(('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded > div:nth-child(' + 
        i) + ') > planning-view-item > div > div.planning-view-item-container > div.planning-view-item-title.bold\').innerText;', 
        null)

    if (viewText == viewName) {
        println("\n"+viewText + foundString + viewName+"\n")
		found=true;
        break;
    }
    
    println(viewText)
}

if(!found) {
	println(' **                     NOT FOUND !!!               **')
}

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

