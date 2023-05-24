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

WebUI.click(findTestObject('Page_AP Storytelling Playbook/img_Playbook_avatar'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Manage Publication Channels (1) (1)'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Manage Publication Channels (2)'), 
    'Manage Publication Channels')

def itemsBefore = WebUI.getText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_6'))

println(itemsBefore.toInteger())

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_New (1) (1)'))

String channelName = (itemsBefore.toInteger() + 1) + ' Pub channel'

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Edition Names_w100 ellipsis new-item-_f47a4d (1)'), 
    channelName)

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_mdl-textfield-afc25cbc (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Email (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_mdl-textfield-2a219b4b (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Daily (1) (1)'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_w100 ellipsis new_4b7e80 (1)'), 
    'Sections')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Supports Revisions_mdl-checkbox__tick-outline (1)'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Supports Revisions_w100 ellipsis new-_95e938 (1)'), 
    'Edition')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/button_Save (1) (1)'))

def itemsAfter = WebUI.getText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_6'))

println(itemsAfter.toInteger())

WebUI.verifyElementText(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_6'), (itemsBefore.toInteger() + 
    1).toString())

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

