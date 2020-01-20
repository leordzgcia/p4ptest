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
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return as array_return
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import java.util.Date as Date
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook

WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')
WebUI.maximizeWindow()
String[] arryPets = var_pets.split(',')
//String flagBoar = '0'
KeywordLogger log = new KeywordLogger()
FileInputStream fisUpd = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3updateDeleteInvoice.xlsx')
//FileInputStream fisPay = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
XSSFWorkbook workbookUpd = new XSSFWorkbook(fisUpd)
//XSSFWorkbook workbookPay = new XSSFWorkbook(fisPay)
XSSFSheet sheetUpd = workbookUpd.getSheet('Sheet1')
//XSSFSheet sheetPay = workbookPay.getSheet('Sheet1')
//int rowCount = 	var_row
int var = Integer.parseInt(var_idRowRes)
Row rowUpd = sheetUpd.getRow(var)
//Row rowPay = sheetPay.getRow(var)
WebUI.setText(findTestObject('obj_login/input_user'), var_user)
WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)
WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))
WebUI.click(findTestObject('obj_login/btn_login'))
WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_parent)
WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'))
WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))
WebUI.delay(2)
WebUI.click(findTestObject('obj_profile/tab_Invoices'))
WebUI.delay(2)
String var_url = WebUI.getUrl()

String[] arrayUrl = var_url.split('/')
WebUI.delay(4)

String urlInvoice = ((((((((((((((((arrayUrl[0]) + '/') + (arrayUrl[1])) + '/') + (arrayUrl[2])) + '/') + (arrayUrl[3])) +
'/') + (arrayUrl[4])) + '/') + (arrayUrl[5])) + '/') + 'invoice') + '/') + (arrayUrl[7])) + '/') + var_invoice

WebUI.navigateToUrl(urlInvoice)
//WebUI.delay(4)
//String urlCO = WebUI.getUrl()
//log.logInfo(urlCO)
WebUI.delay(4)
if (var_movimiento == 'UPDATE') {
	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_boarding'), FailureHandling.STOP_ON_FAILURE)
	}
	
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_day'), FailureHandling.STOP_ON_FAILURE)
	}
	
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_package'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'SERVICES') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_package'), FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('obj_invoce/1_tabedit/input_item_editDelete'), var_item)
	//WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), var_item)
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('obj_invoce/1_tabedit/input_item_editDelete'), Keys.chord(Keys.ENTER))
	//WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), Keys.chord(Keys.ENTER))
	WebUI.delay(1)
	
	Cell celltype = rowUpd.createCell(7, 0)
	celltype.setCellType(celltype.CELL_TYPE_STRING)
	celltype.setCellValue(var_type)
	
	Cell cellitem = rowUpd.createCell(8, 0)
	cellitem.setCellType(cellitem.CELL_TYPE_STRING)
	cellitem.setCellValue(var_item)
	
	Cell celltypeorigin = rowUpd.createCell(12, 0)
	celltypeorigin.setCellType(celltypeorigin.CELL_TYPE_STRING)
	celltypeorigin.setCellValue(var_type)
	
	Cell cellitemorigin = rowUpd.createCell(13, 0)
	cellitemorigin.setCellType(cellitemorigin.CELL_TYPE_STRING)
	cellitemorigin.setCellValue(var_item)
	
	Cell celltypeActual = rowUpd.createCell(14, 0)
	celltypeActual.setCellType(celltypeActual.CELL_TYPE_STRING)
	celltypeActual.setCellValue(var_typeActual)
	
	Cell cellitemActual = rowUpd.createCell(15, 0)
	cellitemActual.setCellType(cellitemActual.CELL_TYPE_STRING)
	cellitemActual.setCellValue(var_itemActual)
	

}
if (var_movimiento=='DELETE') {
	WebUI.click(findTestObject('obj_invoce/1_tabedit/btn_DeleteRowInvoice_editTable'))
	WebUI.delay(4)
	
}
if (var_movimiento =='NEW') {
	
}
  
    WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/button_Save_Taxe'))
    WebUI.delay(4)
//}
//var_url = WebUI.getUrl()
//String[] arrayUrl = var_url.split('/')
//WebUI.delay(2)
//Cell cell = rowInv.createCell(9, 0)
//cell.setCellType(cell.CELL_TYPE_STRING)
//cell.setCellValue(arrayUrl[8])
//WebUI.delay(2)
//Cell cell2 = rowPay.createCell(5, 0)
//cell2.setCellType(cell.CELL_TYPE_STRING)
//cell2.setCellValue(arrayUrl[8])
WebUI.delay(2)
FileOutputStream fosUpd = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3updateDeleteInvoice.xlsx')
workbookUpd.write(fosUpd)
fosUpd.close()
//FileOutputStream fosPay = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
//workbookPay.write(fosPay)
//fosPay.close()
WebUI.delay(2)

