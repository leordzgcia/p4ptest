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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('obj_login/input_user'), var_user)

WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)

WebUI.delay(3)

WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))

WebUI.click(findTestObject('obj_login/btn_login'))

WebUI.delay(3)

WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_parent)

WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))

WebUI.delay(5)

WebUI.click(findTestObject('obj_invoce/new_invoice/a_Invoices'))

WebUI.delay(5)

WebUI.click(findTestObject('obj_invoce/new_invoice/a_1795112'))

WebUI.delay(4)

WebUI.switchToWindowTitle('Paradise 4 Paws | Dog Boarding, Cat Boarding Chicago ORD Airport Resort')

not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/btn_createInvoice'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('obj_invoce/new_invoice/btn_saveInvoce'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(4)

WebUI.submit(findTestObject('obj_paymentdetails/1_pay/btn_Pay'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.submit(findTestObject('obj_paymentdetails/2_pay_inpu/a_pay_inv'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.submit(findTestObject('obj_paymentdetails/1_pay/obj_pay_path'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.submit(findTestObject('obj_paymentdetails/1_pay/a_Pay_spy'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_Pay'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('obj_paymentdetails/2_pay_inpu/a_pay_inv'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('obj_paymentdetails/1_pay/obj_pay_path'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('obj_paymentdetails/1_pay/a_Pay_spy'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(4)

