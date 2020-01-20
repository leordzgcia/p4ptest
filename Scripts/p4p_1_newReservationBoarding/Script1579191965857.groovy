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

String flagBoar = '0'
KeywordLogger log = new KeywordLogger()
FileInputStream fisNewRes = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationBoarding.xlsx')
XSSFWorkbook workbookNewRes = new XSSFWorkbook(fisNewRes)
XSSFSheet sheetNewRes = workbookNewRes.getSheet('Sheet1')
int rowCount = var_row
int var = Integer.parseInt(var_idRowRes)
Row rowNewRes = sheetNewRes.getRow(var)
//Row rowInv = sheetInv.getRow(var)
Date today = new Date()
//String todaysDate1 = today.format('yyyy')/'dd'/MM/yyyy HH:mm')
String todaysDate4 = today.format('dd/MM/yyyy/HH/mm')
String[] date = todaysDate4.split('/')
log.logInfo(date[0])
log.logInfo(date[1])
//int intMesRes = Integer.parseInt(date[1])
String nowTime = today.format('hhmm')
String[] dateCI = var_checkinD.split(',')
String[] dateCO = var_checkoutD.split(',')
String[] arryPets = var_pets.split(',')
log.logInfo(todaysDate4)
WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('obj_login/input_user'), var_user)
WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)
WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))
WebUI.click(findTestObject('obj_login/btn_login'))
WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_searchParent)
WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'))
WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))
WebUI.click(findTestObject('obj_profile/a_addReservation'))
WebUI.click(findTestObject('obj_reservation/4_/btn_Boarding'))
flagBoar = '1'
WebUI.click(findTestObject('obj_reservation/4_/i_location'))
WebUI.click(findTestObject(('obj_reservation/2_facility/i_' + var_idFacility) + '_facility'))
WebUI.click(findTestObject('obj_reservation/4_/dateCheckIn'))

//log.logInfo(date[1])
//int var1 = Integer.parseInt(date[1].toString())
if (((date[1]) == '01') & ((dateCI[1]) == '02')) {
    WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/MES/btn_Jan2020_pullright'))
}
if (((date[1]) == '01') & ((dateCI[1]) == '03')) {
	WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/MES/btn_Jan2020_pullright'))
	WebUI.delay(2)
	WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/MES/btn_Jan2020_pullright'))
}

WebUI.click(findTestObject(('obj_reservation/3_date2020/CI/'+dateCI[1]+'2020/button_' + (dateCI[0])) + (dateCI[1])+'_ci'))

if (flagBoar == '1') {
    WebUI.click(findTestObject('obj_reservation/4_/dateCheckOut'))
 
    //recibe el dia de la fecha checkout
    WebUI.click(findTestObject(('obj_reservation/3_date2020/CO/'+dateCO[1]+'2020/button_' + (dateCO[0])) + (dateCO[1])+'_co'))
}
if (var_checkinT.size() == 1) {
    var_checkinT = ('000' + var_checkinT)
}
if (var_checkinT.size() == 2) {
    var_checkinT = ('00' + var_checkinT)
}
if (var_checkinT.size() == 3) {
    var_checkinT = ('0' + var_checkinT)
}

WebUI.click(findTestObject('obj_reservation/4_/timeCheckin'))
//WebUI.click(findTestObject('obj_meses/time_'+var_checkinT+'am_ci'))
WebUI.click(findTestObject(('obj_reservation/0_horas/CI/time_' + var_checkinT) + '_ci'))
WebUI.click(findTestObject('obj_reservation/4_/timeCheckOut'))
WebUI.click(findTestObject(('obj_reservation/0_horas/CO/time_' + var_checkoutT) + '_co'))
if (arryPets.size() == 1) {
    WebUI.click(findTestObject('obj_reservation/4_/div_Ares'))
} else if (arryPets.size() == 2) {
    WebUI.click(findTestObject('obj_reservation/4_/div_Ares'))
    WebUI.click(findTestObject('obj_reservation/4_/div_Zeus'))
} else if (arryPets.size() == 3) {
    WebUI.click(findTestObject('obj_reservation/4_/div_Ares'))
    WebUI.click(findTestObject('obj_reservation/4_/div_Zeus'))
    WebUI.click(findTestObject('obj_reservation/4_/div_Athena'))
}

//String stringDeposit = WebUI.getText(findTestObject('obj_reservation/4_/span_requiresdeposit'), FailureHandling.CONTINUE_ON_FAILURE)
int varHoliday = 0

//if (stringDeposit.contains('requires a deposit')) {
/*if (stringDeposit != null) {
    varHoliday = 1
}*/
//WebUI.click(findTestObject('obj_reservation/4_/div_Ares'))
/*if ((flagBoar == '1') || (flagBoar == '2')) {
	WebUI.click(findTestObject('obj_reservation/4_/div_suite_rad_deluxe'))
}*/
try {
    WebUI.click(findTestObject('obj_reservation/4_/div_suite_rad_deluxe'))
}
catch (Exception e) {
    e.printStackTrace()
    log.logInfo('ERROR EXCEPCION')
    Cell cell1Err = rowNewRes.createCell(18, 0)
    Cell cell2Err = rowNewRes.createCell(19, 0)
    cell1Err.setCellType(cell1Err.CELL_TYPE_STRING)
    cell1Err.setCellValue('Error')
    cell2Err.setCellType(cell2Err.CELL_TYPE_STRING)
    cell2Err.setCellValue('Suites no disponibles')
    FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationBoarding.xlsx')
    workbookNewRes.write(fos)
    fos.close()
} 
WebUI.click(findTestObject('obj_reservation/4_/btn_next2'))
/*if (flagBoar == '1') {
 WebUI.click(findTestObject('obj_reservation/4_/button_DeclineThisPromo'))
 }*/
WebUI.click(findTestObject('obj_reservation/4_/btn_next2'))
WebUI.click(findTestObject('obj_reservation/4_/button_Submit Reservation'))
if ((flagBoar == '2') && (((var_repeatingEvery == 'Daily') || (var_repeatingEvery == 'Monthly')) || (var_repeatingEvery == 
'Weekly'))) {
    WebUI.click(findTestObject('obj_reservation/4_/button_Ok' //cance xls
            )) //WebUI.delay(1)
    //WebUI.click(findTestObject('obj_reservation/4_/button_Return To Reservation'), FailureHandling.CONTINUE_ON_FAILURE)
} else {
    try {
        WebUI.click(findTestObject('obj_reservation/4_/button_Return To Reservation_2'), FailureHandling.CONTINUE_ON_FAILURE)
    }
    catch (Exception e) {
        e.printStackTrace()
        log.logInfo('ERROR EXCEPCION')
        Cell cell1Err = rowNewRes.createCell(18, 0)
        Cell cell2Err = rowNewRes.createCell(19, 0)
        cell1Err.setCellType(cell1Err.CELL_TYPE_STRING)
        cell1Err.setCellValue('Error')
        cell2Err.setCellType(cell2Err.CELL_TYPE_STRING)
        cell2Err.setCellValue('Reservacion existente')
        FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationBoarding.xlsx')
        workbookNewRes.write(fos)
        fos.close()
    } 
    
    WebUI.click(findTestObject('obj_reservation/4_/button_Go to CheckOut'))
    var_url = WebUI.getUrl()
    String[] arrayUrl = var_url.split('/')
    WebUI.verifyElementText(findTestObject('obj_reservation/4_/span_status'), '( BK )', FailureHandling.STOP_ON_FAILURE)
    log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/a_1795351')))
    Cell cell = rowNewRes.createCell(16, 0)
    cell.setCellType(cell.CELL_TYPE_STRING)
    cell.setCellValue(arrayUrl[5])
    String varIdInv = WebUI.getText(findTestObject('obj_reservation/4_/a_1795351')).toString()
    Cell celldInvoice = rowNewRes.createCell(17, 0)
    celldInvoice.setCellType(cell.CELL_TYPE_STRING)
    celldInvoice.setCellValue(varIdInv)
    Cell cellStatus = rowNewRes.createCell(20, 0)
    cellStatus.setCellType(cell.CELL_TYPE_STRING)
    cellStatus.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
    Cell cellHol = rowNewRes.createCell(18, 0)
    cellHol.setCellType(cell.CELL_TYPE_STRING)
    Cell cellInv3 = rowInv.createCell(3, 0)
    cellInv3.setCellType(cell.CELL_TYPE_STRING)
    if (varHoliday == 1) {
        cellHol.setCellValue('Y')
        cellInv3.setCellValue('Y')
    } else {
        cellHol.setCellValue('N')
        cellInv3.setCellValue('N')
    }
    if (var == 1) {
        Cell cellTime = rowNewRes.createCell(36, 0)
        cellTime.setCellType(cell.CELL_TYPE_STRING)
        cellTime.setCellValue(nowTime)
    }
    log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/1_co_date')))
    WebUI.click(findTestObject('obj_reservation/4_/tab_checkIn'))
    WebUI.delay(1)
    log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/input_CheckinDate_checkin')))
    WebUI.click(findTestObject('obj_reservation/4_/tab_editReservation'))
    WebUI.delay(1)
    log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/input_CheckinDate_edit')))
    WebUI.delay(3)
    Cell cellDCI = rowNewRes.createCell(22, 0)
    cellDCI.setCellType(cell.CELL_TYPE_STRING)
    cellDCI.setCellValue(var_checkinD)
    Cell cellDCO = rowNewRes.createCell(23, 0)
    cellDCO.setCellType(cell.CELL_TYPE_STRING)
    cellDCO.setCellValue(var_checkoutD)
    Cell cellDCI1 = rowNewRes.createCell(24, 0)
    cellDCI1.setCellType(cell.CELL_TYPE_STRING)
    cellDCI1.setCellValue(var_checkinD)
    Cell cellDCO1 = rowNewRes.createCell(25, 0)
    cellDCO1.setCellType(cell.CELL_TYPE_STRING)
    cellDCO1.setCellValue(var_checkoutD)
    WebUI.click(findTestObject('obj_reservation/4_/tab_checkOut'))
    WebUI.delay(1)

    if (var_cancelRes == 'Y') {
        WebUI.click(findTestObject('obj_reservation/4_/tab_editReservation'))
        WebUI.click(findTestObject('obj_reservation/4_/button_Next'))
        WebUI.click(findTestObject('obj_reservation/4_/button_Next'))
        WebUI.click(findTestObject('obj_reservation/4_/btn_cancelReservation'))
        WebUI.delay(1)
        WebUI.click(findTestObject('obj_reservation/4_/button_Cancel This Reservation'))
        WebUI.delay(2)
        WebUI.verifyElementText(findTestObject('obj_reservation/4_/span_status'), '( CAN )', FailureHandling.STOP_ON_FAILURE)

        log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
        Cell cellCan = rowNewRes.createCell(28, 0)
        cellCan.setCellType(cell.CELL_TYPE_STRING)
        cellCan.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
    } else {
        WebUI.click(findTestObject('obj_reservation/4_/tab_checkIn'))
        WebUI.delay(1)
        WebUI.click(findTestObject('obj_reservation/4_/button_CheckIn_tabCheckin'))
        String urlCO = WebUI.getUrl()
        log.logInfo(urlCO)
        WebUI.navigateToUrl(urlCO)
        WebUI.delay(1)
        log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
        WebUI.delay(1)
        Cell cellIn = rowNewRes.createCell(31, 0)
        cellIn.setCellType(cell.CELL_TYPE_STRING)
        cellIn.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
        WebUI.click(findTestObject('obj_reservation/4_/tab_checkOut'))
        WebUI.delay(60)
        WebUI.click(findTestObject('obj_reservation/4_/a_InitiateCheckout_tabCO'))
        WebUI.delay(8)
        WebUI.scrollToPosition(100, 99)
        String urlCO2 = WebUI.getUrl()
        WebUI.click(findTestObject('obj_reservation/4_/a_btnGO_tabCO'))
        WebUI.delay(2)
        log.logInfo(urlCO2)
        WebUI.navigateToUrl(urlCO2)
        log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
        Cell cellOut = rowNewRes.createCell(34, 0)
        cellOut.setCellType(cell.CELL_TYPE_STRING)
        cellOut.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
    }
    FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationBoarding.xlsx')
    workbookNewRes.write(fos)
    var_row++
}

