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

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Reset']))

WebUI.setText(findTestObject('Object Repository/SystemUsers/input_username'), target_username)

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Search']))

WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/username_searchResult'), target_username)

WebUI.click(findTestObject('Object Repository/SystemUsers/button_edit'))

WebUI.waitForPageLoad(5)

WebUI.verifyElementPresent(findTestObject('Object Repository/SystemUsers/header_editUser'), 5)

WebUI.click(findTestObject('Object Repository/Common/dropdown', [
	'label'   : 'Edit User',
	'dropdown': 'User Role'
	]))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': new_role]))

WebUI.click(findTestObject('Object Repository/Common/dropdown', [
	'label'   : 'Edit User',
	'dropdown': 'Status']))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': new_status]))

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Save']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Common/message_success', ['message': expected_success_message]),  5)

WebUI.verifyElementText(findTestObject('Object Repository/Common/message_success', ['message': expected_success_message]), expected_success_message)

WebUI.setText(findTestObject('Object Repository/SystemUsers/input_username'), target_username)

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Search']))

WebUI.waitForElementVisible(findTestObject('Object Repository/SystemUsers/username_searchResult'), 5)

WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/role_searchResult', ['username': target_username]), expected_role_after_edit)

WebUI.verifyElementText(findTestObject('Object Repository/SystemUsers/status_searchResult', ['username': target_username]), expected_status_after_edit)

WebUI.takeScreenshot()