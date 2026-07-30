import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementNotPresentKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AdditionalKeywords keywords = new AdditionalKeywords()

TestData dataFiles = findTestData('Data Files/TD_TC-01_Login')

//get column name
String url = dataFiles.getValue('url', 1)
String username = dataFiles.getValue('username', 1)
String password = dataFiles.getValue('password', 1)
String expected_page_after_login = dataFiles.getValue('expected_page_after_login', 1)
	
WebUI.openBrowser(url)
WebUI.maximizeWindow()

//use additional keywords
keywords.waitForSetText(findTestObject('Object Repository/Login_Page/input_username'), username)
keywords.waitForSetText(findTestObject('Object Repository/Login_Page/input_password'), password)
keywords.waitForClick(findTestObject('Object Repository/Login_Page/button_Login'))
keywords.waitVerifyTextPresent(expected_page_after_login)
	
String projectDir = RunConfiguration.getProjectDir()
String path = projectDir + '/Screenshots/TC-01_Login.png'
WebUI.takeScreenshot(path)

