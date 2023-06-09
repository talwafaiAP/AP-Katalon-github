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

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Section Title_icon-ApplicationMenu hand fs22 (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Create New Team View'))

teamViewName = ('Team View ' + Math.floor(Math.random() * 10000).toInteger().toString())

println(teamViewName)

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Save_mdl-textfield-2 (3)'), teamViewName)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/button_Save (4)'))

WebUI.delay(2)

println(teamViewName+ "   was CREATED")

//
//WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_View3 assignments_icon-ApplicationMenu_ae05cc (3)'))
//
//WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Edit Team Settings'))
WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Section Title_icon-ApplicationMenu hand fs22'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/li_Show All Team Views'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Planning Views and Searches'),
	'Planning Views and Searches')

if (WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded\')',
	null)) {
	def teamViewElementsCount = WebUI.executeJavaScript('return document.querySelector(\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div > pane-container > div.is-expanded\').childElementCount',
		null)

	for (def i = 1; i <= teamViewElementsCount; i++) {
		String jsQuerySelector1='\'body > app-root > main > loader > div > main-content > div.main-content.sidemenu-expanded > planning-views > div > div.data-container-wrapper-filter-overlay.data-container-wrapper-filter-collapsed > div.left.oauto.data-container.scrollable.data-container-filter-overlay.data-container-filter-collapsed > loader > div > div:nth-child(1) > pane-container > div.is-expanded > div:nth-child(';
		String jsQuerySelector2=') > planning-view-item > div > div.planning-view-item-container > div.planning-view-item-title.bold\'';
		String query='return document.querySelector(' + jsQuerySelector1+ i + jsQuerySelector2+ ').innerText;';
		println(query)
		teamViewText = WebUI.executeJavaScript(query,null)

		if (teamViewText == teamViewName) {
			println((teamViewText + ' ************** FOUND *************** ') + teamViewName)
			String teamViewToDeleteQuery= 'return document.querySelector(' + jsQuerySelector1+ i + ') > planning-view-item > div > div.planning-view-item-buttons-container > div.planning-view-item-remove.icon-Delete.fs14\''+ ').click();';
			println(teamViewToDeleteQuery);
			WebUI.executeJavaScript(teamViewToDeleteQuery,null)
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
				println(teamViewText + " was DELETED ______________________________________")
			}

			

			break
		}
		
		println(teamViewText)
	}
}


//WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

