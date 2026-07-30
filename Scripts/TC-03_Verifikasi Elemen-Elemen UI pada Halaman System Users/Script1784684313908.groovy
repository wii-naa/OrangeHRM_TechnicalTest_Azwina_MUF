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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Map elementMap = [
	"Username"      : "SystemUsers/input_username",
	"User Role"     : "SystemUsers/dropdown_userRole",
	"Employee Name" : "SystemUsers/input_employeeName",
	"Status"        : "SystemUsers/dropdown_status",
	"Search"        : "SystemUsers/button_search"
]

TestData dataFiles = findTestData('Data Files/TD_TC-03_Validate Elements')
int rows = dataFiles.getRowNumbers()

for (int i=1; i<=rows; i++) {
	
	String element_name = dataFiles.getValue("element_name", i)
	Boolean expected_visible = dataFiles.getValue("expected_visible", i)
	Boolean expected_enabled = dataFiles.getValue("expected_enabled", i)
	

	TestObject obj = findTestObject(elementMap[element_name])
	
	WebUI.verifyEqual(WebUI.findWebElement(obj).isDisplayed(), expected_visible)
	WebUI.verifyEqual(WebUI.findWebElement(obj).isEnabled(), expected_enabled)
	
}

String dir = RunConfiguration.getProjectDir()
String path = dir + '/Screenshots/TC-03_Verify_Elements.png'
WebUI.takeScreenshot(path)