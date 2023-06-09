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

String viewName = 'Slideshow-'

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Create New View'))

viewName += Math.floor(Math.random() * 1000).toInteger().toString()

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Save_mdl-textfield-2'), viewName)

//WebUI.click(findTestObject('assignRadioClick'), FailureHandling.STOP_ON_FAILURE)
//WebUI.verifyElementPresent(findTestObject('assignmentRadio'), 0)
WebUI.click(findTestObject('slideshowRadioClick'))

//WebUI.click(findTestObject(null))
WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > mdl-dialog-host-component > div.ng-star-inserted > create-new-view > div > div.left.w100.prop-container.pright30.pleft30.scrollable > div:nth-child(13) > viewstates-list > mdl-list > mdl-list-item:nth-child(1) > mdl-list-item-primary-content > mdl-checkbox\').click()', 
    null)

WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > mdl-dialog-host-component > div.ng-star-inserted > create-new-view > div > div.left.w100.prop-container.pright30.pleft30.scrollable > div:nth-child(13) > viewstates-list > mdl-list > mdl-list-item:nth-child(2) > mdl-list-item-primary-content > mdl-checkbox\').click()', 
    null)

WebUI.verifyElementPresent(findTestObject('slideshowRadioVerify'), 30)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/button_Save (2)'))

//WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_View1'), viewName)
WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Views'))

def slideshowsCount = WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded\').childElementCount', 
    null)

for (def i = 1; i <= slideshowsCount; i++) {
    String viewText = WebUI.executeJavaScript(('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded > div:nth-child(' + 
        i) + ') > planning-view-item > div > div.planning-view-item-container > div.planning-view-item-title.bold\').innerText;', 
        null)

    //body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded > div:nth-child(1) > planning-view-item > div > div.planning-view-item-container > div.planning-view-item-title.bold
    if (viewText == viewName) {
        println((viewText + ' ************** FOUND *************** ') + viewName)

        break
    } //    println((viewText + '\t') + viewName)
}

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

