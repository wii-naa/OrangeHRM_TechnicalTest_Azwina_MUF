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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData dataFiles = findTestData('Data Files/TD_TC-02_Navigate_to_System_Users')

String admin_menu_label = dataFiles.getValue('admin_menu_label', 1)
String user_management_label = dataFiles.getValue('user_management_label', 1)
String users_label = dataFiles.getValue('users_label', 1)
String expected_url_keyword = dataFiles.getValue('expected_url_keyword', 1)
String expected_page_header = dataFiles.getValue('expected_page_header', 1)


WebUI.click(findTestObject('Object Repository/Menu/label_mainMenu', ['menuLabel':admin_menu_label]))
WebUI.click(findTestObject('Object Repository/Menu/label_topbarMenu', ['menuLabel':user_management_label]))
WebUI.click(findTestObject('Object Repository/Menu/label_dropdownMenu', ['menuLabel':users_label]))

String url = WebUI.getUrl()
assert url.contains(expected_url_keyword)
WebUI.verifyElementText(findTestObject('Object Repository/Menu/header_systemUser'), expected_page_header)

String projectDir = RunConfiguration.getProjectDir()
String path = projectDir + '/Screenshots/TC-02_Navigate_to_System_Users.png'
WebUI.takeScreenshot(path)