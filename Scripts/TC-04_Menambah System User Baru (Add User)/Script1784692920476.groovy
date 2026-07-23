import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Date
import java.sql.Time

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

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Add']))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/Common/dropdown', [
	'label'   : 'Add User',
	'dropdown': 'User Role'
	]))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option':user_role]))

WebUI.setText(findTestObject('Object Repository/Add_User/input_EmployeeName'), employee_keyword)

WebUI.click(findTestObject('Object Repository/Add_User/option_Employee', ['employeeName':employee_name]))

WebUI.click(findTestObject('Object Repository/Common/dropdown', [
	'label'   : 'Add User',
	'dropdown':'Status'
	]))

WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': status]))

WebUI.setText(findTestObject('Object Repository/Add_User/input_Username'), username)

WebUI.setText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Password']), password)

WebUI.setText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Confirm Password']), confirm_password)

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Save']))
  
WebUI.waitForElementVisible(findTestObject('Object Repository/Common/message_success', ['message' : expected_success_message]), 10)
  
WebUI.verifyElementText(findTestObject('Object Repository/Common/message_success', ['message' : expected_success_message]), expected_success_message)

WebUI.takeScreenshot()
 