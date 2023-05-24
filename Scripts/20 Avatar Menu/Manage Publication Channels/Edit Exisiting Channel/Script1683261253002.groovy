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

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/img_Playbook_avatar (3)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_Manage Publication Channels (3)'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Edition Names_w100 ellipsis new-item-_f47a4d (2)'), 
    '17 Pub channel test')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_keyboard_arrow_down (1)'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/div_CMS'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_keyboard_arrow_down_mdl-checkbox__tick_794862'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_w100 ellipsis new_4b7e80 (2)'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_w100 ellipsis new_4b7e80 (2)'), 
    'Edition2')

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_keyboard_arrow_down_w100 ellipsis new_4b7e80_1'), 
    'Sections2')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_keyboard_arrow_down_mdl-checkbox__tick_794862_1'))

WebUI.callTestCase(findTestCase('Logout and close browser (partial)'), [:], FailureHandling.STOP_ON_FAILURE)

