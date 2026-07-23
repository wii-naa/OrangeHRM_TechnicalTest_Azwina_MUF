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

WebUI.callTestCase(findTestCase('TC-04_Menambah System User Baru (Add User)'),
	[
		'user_role' : user_role,
		'employee_keyword': employee_keyword,
        'employee_name' : employee_name,
		'username' : username,
		'status' : status,
		'password' : password,
		'confirm_password' : confirm_password,
        'expected_success_message' : expected_success_saved_message
	], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TC-05_Mencari System User Berdasarkan Username'),
	[
		'search_keyword': username,
		'expected_result_count' : expected_result_count,
        'expected_username_in_result' : expected_username_in_result,
		'expected_empty_message' : expected_empty_message
	], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TC-07_Edit Data System User (Ubah Role dan Status)'),
	[
		'target_username' : username,
		'new_role' : new_role,
        'new_status' : new_status,
		'expected_success_message' : expected_success_update_message,
		'expected_role_after_edit' : expected_role_after_edit,
		'expected_status_after_edit' : expected_status_after_edit
	], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TC-08_Menghapus System User (Delete) dan Verifikasi'),
	[
		'target_username' : username,
		'expected_success_message' : expected_success_delete_message,
        'expected_after_delete_message' : expected_after_delete_message
	], FailureHandling.CONTINUE_ON_FAILURE)

