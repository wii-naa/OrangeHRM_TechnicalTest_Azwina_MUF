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

TestObject username = findTestObject('Object Repository/SystemUsers/input_username')

WebUI.sendKeys(username, Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(username, Keys.chord(Keys.BACK_SPACE))

WebUI.setText(username, search_username)

WebUI.click(findTestObject('Object Repository/SystemUsers/dropdown_userRole', ['dropdown': 'User Role']))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': search_role]))

WebUI.click(findTestObject('Object Repository/SystemUsers/dropdown_status', ['dropdown': 'Status']))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': search_status]))

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Search']))

WebUI.waitForPageLoad(5)

int records = WebUI.findWebElements(findTestObject('Object Repository/SystemUsers/div_tableCard'), 5).size()

if (records>0 ) {
	WebUI.verifyEqual(records, expected_result_count)	
	
	WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/username_searchResult'), expected_username_in_result)
	
	WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/role_searchResult', ['username': expected_username_in_result]), expected_role_in_result)
	
	WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/status_searchResult', ['username': expected_username_in_result]), expected_status_in_result)
	
} else {
	WebUI.verifyTextPresent(expected_empty_message, true)
}

WebUI.takeScreenshot()