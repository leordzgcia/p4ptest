import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
//import com.kms.katalon.core.checkpoint.point as Checkpoint
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
import org.stringtemplate.v4.compiler.STParser.element_return as element_return
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
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return as value_return
import org.junit.After as After
import groovy.time.TimeCategory as TimeCategory
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import java.lang.String as String
WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')
WebUI.maximizeWindow()


String[] arryPets = var_pets.split(',')
String flagBoar = '0'
KeywordLogger log = new KeywordLogger()
FileInputStream fisCreInv = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3createInvoice.xlsx')
FileInputStream fisUpdInv = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3updateDeleteInvoice.xlsx')
FileInputStream fisPay = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
XSSFWorkbook workbookCreInv = new XSSFWorkbook(fisCreInv)
XSSFWorkbook workbookUpdInv = new XSSFWorkbook(fisUpdInv)
XSSFWorkbook workbookPay = new XSSFWorkbook(fisPay)
XSSFSheet sheetCreInv = workbookCreInv.getSheet('Sheet1')
XSSFSheet sheetUpdInv = workbookUpdInv.getSheet('Sheet1')
XSSFSheet sheetPay = workbookPay.getSheet('Sheet1')
//int rowCount = 	var_row
int var = Integer.parseInt(var_idRowRes)
Row rowCreInv = sheetCreInv.getRow(var)
Row rowUpdInv = sheetUpdInv.getRow(var)
Row rowPay = sheetPay.getRow(var)
Date today = new Date()
String todaysDate1 = today.format("mmm/dd/yy")
String todaysDate2 = today.format("dd/mm/yy")
String todaysDate3 = today.format("dd")
String nowTime = today.format("hhmm");

WebUI.setText(findTestObject('obj_login/input_user'), var_user)
WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)
WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))
WebUI.click(findTestObject('obj_login/btn_login'))
WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_parent)
WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'))
WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))
WebUI.click(findTestObject('obj_invoce/new_invoice/btn_createInvoice'))

if (arryPets.size() == 1) {
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))
	//WebUI.delay(2)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/a_Taxes ()_select2-choice_1'))
	//WebUI.delay(2)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Zeus'))
	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/b'))
	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/select_BOARDING_SUITEDAYCARE_SUITESPA_SUITE'))
	//WebUI.delay(2)
	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_boarding'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_day'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_package'), FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), var_item)
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), Keys.chord(Keys.ENTER))
	WebUI.delay(1)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/button_Save_Taxe'))
	WebUI.delay(1)
	/*Cell cellIdRow = rowUpdInv.createCell(0,0)
	cellIdRow.setCellType(cellIdRow.CELL_TYPE_STRING)
	cellIdRow.setCellValue(var_idRowRes)
	
	Cell cellUser = rowUpdInv.createCell(1,0)
	cellUser.setCellType(cellUser.CELL_TYPE_STRING)
	cellUser.setCellValue(var_user)
	
	Cell cellPass = rowUpdInv.createCell(2,0)
	cellPass.setCellType(cellPass.CELL_TYPE_STRING)
	cellPass.setCellValue(var_pass)
	
	Cell cellParent = rowUpdInv.createCell(3,0)
	cellParent.setCellType(cellParent.CELL_TYPE_STRING)
	cellParent.setCellValue(var_parent)
	
	Cell cellUpdInvPet = rowUpdInv.createCell(5,0)
	cellUpdInvPet.setCellType(cellUpdInvPet.CELL_TYPE_STRING)
	cellUpdInvPet.setCellValue(var_pets)
	
	Cell cellUpdInvDate = rowUpdInv.createCell(6,0)
	cellUpdInvDate.setCellType(cellUpdInvDate.CELL_TYPE_STRING)
	cellUpdInvDate.setCellValue(var_date)
	
	Cell cellUpdInvType = rowUpdInv.createCell(7,0)
	cellUpdInvType.setCellType(cellUpdInvType.CELL_TYPE_STRING)
	cellUpdInvType.setCellValue(var_type)
	
	Cell cellUpdInvItem = rowUpdInv.createCell(8,0)
	cellUpdInvItem.setCellType(cellUpdInvItem.CELL_TYPE_STRING)
	cellUpdInvItem.setCellValue(var_item)*/
}

if (arryPets.size() == 2) {
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))
	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/a_Taxes ()_select2-choice_1'))
	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Zeus'))
	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/b'))
	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/select_BOARDING_SUITEDAYCARE_SUITESPA_SUITE'))
	WebUI.delay(3)

	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_boarding'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_day'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_package'), FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), var_item)
	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), Keys.chord(Keys.ENTER))
	WebUI.delay(4)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))
	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/a_Taxes ()_select2-choice_2'))
	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Ares'))
	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/b'))

	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/select_BOARDING_SUITEDAYCARE_SUITESPA_SUITE'))
	WebUI.delay(3)
	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_boarding_2'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_day_2'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_package_2'), FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.delay(4)

	try {
		WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), var_item)
		WebUI.delay(3)
	
		WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), Keys.chord(Keys.ENTER))
		WebUI.delay(3)
		
	} catch (Exception e) {
		e.printStackTrace()
		log.logInfo('ERRO CACHADO')
	}
	
	/*
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), var_item)
	WebUI.delay(4)

	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), Keys.chord(Keys.ENTER))
	WebUI.delay(4)*/

	try {
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/button_Save_Taxe'))

	WebUI.delay(4)
	
	} catch (Exception e) {
		e.printStackTrace()
		log.logInfo('ERRO CACHADO 2')
	}
}

if (arryPets.size() == 3) {
	log.logInfo('SIZE 3')

	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))

	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/a_Taxes ()_select2-choice_1'))

	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Zeus'))

	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/b'))

	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/select_BOARDING_SUITEDAYCARE_SUITESPA_SUITE'))

	WebUI.delay(3)
	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_boarding'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_day'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice_ok_1/select_package'), FailureHandling.STOP_ON_FAILURE)
	}

	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), var_item)

	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub/input_Taxes_Item_1'), Keys.chord(Keys.ENTER))

	WebUI.delay(4)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))

	WebUI.delay(3)
	//WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/a_Taxes ()_select2-choice_1'))
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/a_Taxes ()_select2-choice_2'))

	WebUI.delay(3)

	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Ares'))

	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/b'))

	not_run: WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/select_BOARDING_SUITEDAYCARE_SUITESPA_SUITE'))

	WebUI.delay(3)

	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_boarding_2'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_day_2'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_package_2'), FailureHandling.STOP_ON_FAILURE)
	}

	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), var_item)

	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_2'), Keys.chord(Keys.ENTER))

	WebUI.delay(4)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/btn_AddLineItem'))

	WebUI.delay(3)
	//WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/a_Taxes ()_select2-choice_1'))
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/a_Taxes ()_select2-choice_3'))

	WebUI.delay(3)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/div_Poseidon'))

	WebUI.delay(3)

	if (var_type == 'BOARDING_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_boarding_3'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'DAYCARE_SUITE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_day_3'), FailureHandling.STOP_ON_FAILURE)
	}
	if (var_type == 'PACKAGE') {
		WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/select_package_3'), FailureHandling.STOP_ON_FAILURE)
	}

	WebUI.delay(4)

	/*WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_3'), var_item)
	 WebUI.delay(4)
	 WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub2/input_Taxes_Item_3'), Keys.chord(Keys.ENTER))*/
	try {
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub3/input_item3'), var_item)
	WebUI.delay(4)
	WebUI.sendKeys(findTestObject('obj_invoce/new_invoice/new_invoice_sub3/input_item3'), Keys.chord(Keys.ENTER))
	} catch (Exception e) {
		e.printStackTrace()
		Cell cell = rowInv.createCell(9,0)
		cell.setCellType(cell.CELL_TYPE_STRING)
		cell.setCellValue('Item invalid')
		WebUI.delay(2)
		FileOutputStream fosInv = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3createInvoice.xlsx')
		workbookInv.write(fosInv)
		fosInv.close()
	}
	WebUI.delay(2)
	WebUI.click(findTestObject('obj_invoce/new_invoice/new_invoice_sub/button_Save_Taxe'))
	WebUI.delay(2)
}
WebUI.delay(1)
var_url = WebUI.getUrl()
String[] arrayUrl = var_url.split('/')

//INVOICE OK
Cell cellCreInv = rowCreInv.createCell(9,0)
cellCreInv.setCellType(cellCreInv.CELL_TYPE_STRING)
cellCreInv.setCellValue(arrayUrl[8])
Cell cellUpdInv = rowUpdInv.createCell(4,0)
cellUpdInv.setCellType(cellUpdInv.CELL_TYPE_STRING)
cellUpdInv.setCellValue(arrayUrl[8])
//PET
Cell cellUpdPet = rowUpdInv.createCell(5,0)
cellUpdPet.setCellType(cellUpdPet.CELL_TYPE_STRING)
cellUpdPet.setCellValue(var_pets)
//DATE
Cell cellUpdDate = rowUpdInv.createCell(6,0)
cellUpdDate.setCellType(cellUpdDate.CELL_TYPE_STRING)
cellUpdDate.setCellValue(var_date)

//type item
Cell cellUpdType = rowUpdInv.createCell(7,0)
cellUpdType.setCellType(cellUpdType.CELL_TYPE_STRING)
cellUpdType.setCellValue(var_type)
Cell cellUpdItem = rowUpdInv.createCell(8,0)
cellUpdItem.setCellType(cellUpdItem.CELL_TYPE_STRING)
cellUpdItem.setCellValue(var_item)

//create OK
Cell cellUpdCre = rowUpdInv.createCell(9,0)
cellUpdCre.setCellType(cellUpdCre.CELL_TYPE_STRING)
cellUpdCre.setCellValue('CREATE')


/*Cell cellP = rowPay.createCell(5,0)
cellP.setCellType(cellP.CELL_TYPE_STRING)
cellP.setCellValue(arrayUrl[8])*/

FileOutputStream fosCreInv = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3createInvoice.xlsx')
workbookCreInv.write(fosCreInv)
fosCreInv.close()
FileOutputStream fosUpdInv = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_3updateDeleteInvoice.xlsx')
workbookUpdInv.write(fosUpdInv)
fosUpdInv.close()
FileOutputStream fosPay = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_4payment.xlsx')
workbookPay.write(fosPay)
fosPay.close()