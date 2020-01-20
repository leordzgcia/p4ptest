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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import java.util.Date as Date
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return as value_return
import java.lang.String as String
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')

KeywordLogger log = new KeywordLogger()

WebUI.maximizeWindow()

WebUI.setText(findTestObject('obj_login/input_user'), var_user)

WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)

WebUI.delay(2)

WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))

WebUI.click(findTestObject('obj_login/btn_login'))

WebUI.delay(2)

WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_mailParent)

WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'))

WebUI.delay(2)

WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))

WebUI.delay(1)

String a = ((var_url1 + var_idReservation) + var_url2) + var_idParent

WebUI.delay(4)

log.logInfo('URL: ' + a)

WebUI.navigateToUrl(a)

WebUI.delay(3)

WebUI.click(findTestObject('obj_reservation/4_/button_Next'))

WebUI.delay(1)

/*if (flagBoar == '1') {
 WebUI.click(findTestObject('obj_reservation/4_/button_DeclineThisPromo'))
 }*/
//WebUI.click(findTestObject('obj_reservation/4_/button_Next'))// SALE SOBRANDO EN SPASERVICE
//WebUI.delay(2)


if (var_typeReserv == 'BOARDING') {
	WebUI.click(findTestObject('obj_reservation/4_/button_DeclineThisPromo'))
	log.logInfo('TEST 1')
	WebUI.delay(2)
	//WebUI.click(findTestObject('obj_reservation/4_/button_Next'))// SALE SOBRANDO EN SPASERVICE
}

WebUI.click(findTestObject('obj_reservation/4_/button_Next'))

WebUI.click(findTestObject('obj_reservation/4_/btn_cancelReservation'))

//WebUI.click(findTestObject('obj_paymentdetails/1_pay/btn_CancelThisReservation'))
//WebUI.click(findTestObject('obj_reservation/4_/btn_cancelReservation'))

WebUI.delay(4)

WebUI.click(findTestObject('obj_reservation/4_/button_Cancel This Reservation'))

WebUI.delay(4)

WebUI.navigateToUrl(a)

WebUI.verifyElementText(findTestObject('obj_reservation/4_/span_status'),
		'( CAN )', FailureHandling.STOP_ON_FAILURE)

log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))

WebUI.delay(5)


int var = Integer.parseInt(var_idRowRes)
FileInputStream fisCan = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_2cancelReservation.xlsx')
XSSFWorkbook workbookCan = new XSSFWorkbook(fisCan)
XSSFSheet sheetCan = workbookCan.getSheet('Sheet1')

Row row = sheetCan.getRow(var)
Cell cell = row.createCell(7,0)
cell.setCellType(cell.CELL_TYPE_STRING)
cell.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
//Cell cell2 = row.createCell(8, 0)
//cell2.setCellType(cell.CELL_TYPE_STRING)
//cell2.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))

FileOutputStream fosCan = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_2cancelReservation.xlsx')
workbookCan.write(fosCan)

fosCan.close()

