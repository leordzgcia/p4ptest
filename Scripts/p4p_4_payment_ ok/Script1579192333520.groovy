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
import java.util.Date as Date
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.deleteClause_scope as deleteClause_scope

KeywordLogger log = new KeywordLogger()
FileInputStream fisPay = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
XSSFWorkbook workbookPay = new XSSFWorkbook(fisPay)
XSSFSheet sheetPay = workbookPay.getSheet('Sheet1')
//int rowCount = var_row
int var = Integer.parseInt(var_idRowRes)
Row rowPay = sheetPay.getRow(var)
Date today = new Date()
String nowTime = today.format('hhmmdd')
WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('obj_login/input_user'), var_user)
WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)
WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))
WebUI.click(findTestObject('obj_login/btn_login'))
WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_parent)
WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))
WebUI.click(findTestObject('obj_invoce/new_invoice/a_Invoices'))
WebUI.delay(1)
not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/a_1795112'))
//WebUI.click(findTestObject('Object Repository/obj_paymentdetails/newpay/Page_Paradise 4 Paws  Dog Boarding Cat Boar_145431/a_1795348'))
var_url = WebUI.getUrl()
String[] arrayUrl = var_url.split('/')

String urlInvoice = ((((((((((((((((arrayUrl[0]) + '/') + (arrayUrl[1])) + '/') + (arrayUrl[2])) + '/') + (arrayUrl[3])) + 
'/') + (arrayUrl[4])) + '/') + (arrayUrl[5])) + '/') + 'invoice') + '/') + (arrayUrl[7])) + '/') + var_invoice
WebUI.navigateToUrl(urlInvoice)
WebUI.delay(6)

if (var_paybalance == 'N') {
	WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_Pay'))
}
if (var_paybalance=='Y') {
	WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_Pay_2'))
}
//WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_Pay'))
WebUI.delay(1)
WebUI.click(findTestObject('obj_paymentdetails/1_pay/rBtn_' + var_method))
WebUI.delay(1)
WebUI.getText(findTestObject('obj_paymentdetails/1_pay/a_amountDue_1'))
WebUI.getText(findTestObject('obj_paymentdetails/1_pay/a_amountDue_2'))
log.logInfo(WebUI.getText(findTestObject('obj_paymentdetails/1_pay/a_amountDue_1')))
log.logInfo(WebUI.getText(findTestObject('obj_paymentdetails/1_pay/a_amountDue_2')))
/*if (var_reqdeposit == 'Y') {
    log.logInfo('REQUIERE DEPOSITO C')
}*/

Cell cellAD = rowPay.createCell(11, 0)
cellAD.setCellType(cellAD.CELL_TYPE_STRING)
cellAD.setCellValue(WebUI.getText(findTestObject('obj_paymentdetails/1_pay/a_amountDue_1')))

if (var_paybalance == 'Y') {
    WebUI.click(findTestObject('obj_paymentdetails/1_pay/rBtn_PayBalance'))
	Cell cellS= rowPay.createCell(14, 0)
	cellS.setCellType(cellS.CELL_TYPE_STRING)
	cellS.setCellValue('PAYMENT')
	
} else {
    WebUI.click(findTestObject('obj_paymentdetails/1_pay/rBtn__OtherAmount'))
    WebUI.setText(findTestObject('obj_paymentdetails/1_pay/input_AmounttoPay'), var_amountpay)
    WebUI.delay(3)
}
WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_makeAPayment'))
WebUI.delay(3)
FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
workbookPay.write(fos)


