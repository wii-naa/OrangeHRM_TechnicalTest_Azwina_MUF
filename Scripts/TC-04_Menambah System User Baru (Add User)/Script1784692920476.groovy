import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.mockito.ArgumentMatchers.contains

import java.sql.Date
import java.sql.Time

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

AdditionalKeywords keywords = new AdditionalKeywords()

TestData dataFiles = findTestData('Data Files/TD_TC-04_Add User')
int rows = dataFiles.getRowNumbers()

for (int i=1; i<=rows; i++) {
	//get column name
	String user_role = dataFiles.getValue("user_role", i)
	String employee_keyword = dataFiles.getValue("employee_keyword", i)
	String employee_name = dataFiles.getValue("employee_name", i)
	String username = dataFiles.getValue("username", i)
	String status = dataFiles.getValue("status", i)
	String password = dataFiles.getValue("password", i)
	String confirm_password = dataFiles.getValue("confirm_password", i)
	String expected_success_message = dataFiles.getValue("expected_success_message", i)
	
	//use additional keywords
	keywords.waitForClick(findTestObject('Object Repository/Common/button', ['button': 'Add']))
	
	keywords.waitForClick(findTestObject('Object Repository/Common/dropdown', [
		'label'   : 'Add User',
		'dropdown': 'User Role'
		]))
	
	keywords.waitForClick(findTestObject('Object Repository/Common/dropdown_option', ['option':user_role]))
	
	keywords.waitForSetText(findTestObject('Object Repository/Add_User/input_EmployeeName'), employee_keyword)
	
	keywords.waitForClick(findTestObject('Object Repository/Add_User/option_Employee', ['employeeName':employee_name]))
	
	keywords.waitForClick(findTestObject('Object Repository/Common/dropdown', [
		'label'   : 'Add User',
		'dropdown':'Status'
		]))
	
	keywords.waitForClick(findTestObject('Object Repository/Common/dropdown_option', ['option': status]))
	
	keywords.waitForSetText(findTestObject('Object Repository/Add_User/input_Username'), username)
	
	keywords.waitForSetText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Password']), password)
	
	keywords.waitForSetText(findTestObject('Object Repository/Add_User/input_Password', ['label':'Confirm Password']), confirm_password)
	
	keywords.waitForClick(findTestObject('Object Repository/Common/button', ['button': 'Save']))
	  
	//WebUI.waitForElementVisible(findTestObject('Object Repository/Common/message_success', ['message' : expected_success_message]), 10)
	  
	keywords.waitVerifyElementText(findTestObject('Object Repository/Common/toast_message'), expected_success_message)
	
	
	String dir = RunConfiguration.getProjectDir()
	String path = dir + '/Screenshots/TC-04_Add_User ['+ username +'].png'
	WebUI.takeScreenshot(path)
	
	 
}

