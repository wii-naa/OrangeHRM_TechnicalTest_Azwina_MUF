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

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Add']))

if (input_role?.trim()) {
	WebUI.click(findTestObject('Object Repository/Common/dropdown', [
		'label'   : 'Add User',
		'dropdown': 'User Role'
		]))
	
	WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option':input_role]))
}

if (input_employee?.trim()) {
	WebUI.setText(findTestObject('Object Repository/Add_User/input_EmployeeName'), input_employee)
	
	WebUI.click(findTestObject('Object Repository/Add_User/option_Employee', ['employeeName':input_employee]))	
}

if (input_status?.trim()) {
	WebUI.click(findTestObject('Object Repository/Common/dropdown', [
		'label'   : 'Add User',
		'dropdown':'Status'
		]))
	
	WebUI.click(findTestObject('Object Repository/Common/dropdown_option', ['option': input_status]))
}

if (input_username?.trim()) {
	WebUI.setText(findTestObject('Object Repository/Add_User/input_Username'), input_username)
}


if (input_password?.trim()) {
	WebUI.setText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Password']), input_password)
}

if (input_confirm_password?.trim()) {
	WebUI.setText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Confirm Password']), input_confirm_password)
}

if (expected_save_success == "true") {
	
	WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Save']))
	
	WebUI.verifyElementText(findTestObject('Object Repository/Common/toast_message'), 'Successfully Saved')
	
	WebUI.takeScreenshot()
	
} else {
	
	WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Save']))
	
	WebUI.verifyTextPresent(expected_error_message, true)
	
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Cancel']))
}

WebUI.waitForPageLoad(5)