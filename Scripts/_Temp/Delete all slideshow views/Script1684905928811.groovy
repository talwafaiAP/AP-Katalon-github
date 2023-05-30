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

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Views'))

WebUI.delay(10)

String slideshowCount;

if(WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded\');', 
    null)!= null) {
	slideshowCount = WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded\').childElementCount;',
	null)


}else {
	slideshowCount="0"
}

println(slideshowCount)

for (def i = slideshowCount.toInteger(); i >= 1; i--) {
    println(((slideshowCount + ':SlideshowCount,       ') + i) + ' :i')

    WebUI.executeJavaScript(('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(2) > pane-container > div.is-expanded > div:nth-child(' + 
        i) + ') > planning-view-item > div > div.planning-view-item-buttons-container > div.planning-view-item-remove.icon-Delete.fs14\').click();', 
        null)

    WebUI.delay(2)

    WebUI.executeJavaScript('return document.querySelector(\'body > ngb-modal-window > div > div > modal > div.modal-footer > button.yes-btn.bolder.mright10.pointer\').click();', 
        null)

    String err = WebUI.executeJavaScript('return document.querySelector(\'body > ngb-modal-window > div > div > modal > div.modal-header > h4\').innerText', 
        null)

    if (err == 'Error') {
        println('**** ERROR ****')

        WebUI.executeJavaScript('document.querySelector(\'body > ngb-modal-window > div > div > modal > div.modal-header > button\').click();', 
            null)
    } else {
        println(' ____________ SUCCESS ____________')
    }
    
    WebUI.delay(2)
}

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

