import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

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

WebUI.setText(username, search_keyword)

WebUI.click(findTestObject('Object Repository/Common/button', ['button': 'Search']))

WebUI.waitForPageLoad(5)

int records = WebUI.findWebElements(findTestObject('Object Repository/SystemUsers/div_tableCard'), 5).size()

if (records>0 ) {
	WebUI.verifyEqual(records, expected_result_count)
	
	String actualUsername = WebUI.getText(findTestObject('Object Repository/SystemUsers/username_searchResult'))	
	WebUI.verifyMatch(actualUsername, expected_username_in_result, true)
	
} else {
	WebUI.verifyTextPresent(expected_empty_message, true)
}

WebUI.takeScreenshot()

