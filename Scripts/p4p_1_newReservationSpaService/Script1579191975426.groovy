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
import java.lang.String as String

WebUI.openBrowser('https://p4p-qa-bg.aws.paradise4paws.com/login/')
WebUI.maximizeWindow()


WebUI.setText(findTestObject('obj_login/input_user'), var_user)

WebUI.setText(findTestObject('obj_login/input_pass'), var_pass)

WebUI.delay(2)

WebUI.verifyElementClickable(findTestObject('obj_login/btn_login'))

WebUI.click(findTestObject('obj_login/btn_login'))

WebUI.delay(2)

WebUI.setText(findTestObject('obj_dashboard_emp/input_search'), var_searchParent)

WebUI.click(findTestObject('obj_dashboard_emp/btn_accountSearch'))

WebUI.delay(2)

WebUI.click(findTestObject('obj_accountInformation/a_TEST GABRIEL PROD'))

WebUI.delay(2)

WebUI.click(findTestObject('obj_profile/a_addReservation'))

WebUI.delay(2)

String flagBoar = '0'
KeywordLogger log = new KeywordLogger()
FileInputStream fisNewRes = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationSpaService.xlsx')
FileInputStream fisCanRes = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_2cancelReservation.xlsx')
XSSFWorkbook workbookNewRes = new XSSFWorkbook(fisNewRes)
XSSFWorkbook workbookCanRes = new XSSFWorkbook(fisCanRes)
XSSFSheet sheetNewRes = workbookNewRes.getSheet('Sheet1')
XSSFSheet sheetCanRes = workbookCanRes.getSheet('Sheet1')
int rowCount = 	var_row
int var = Integer.parseInt(var_idRowRes)
Row rowNewRes = sheetNewRes.getRow(var)
Row rowCanRes = sheetCanRes.getRow(var)

if (var_typeReserveation == 'Boarding') {
    WebUI.click(findTestObject('obj_reservation/4_/btn_Boarding'))

    flagBoar = '1'
} else if (var_typeReserveation == 'Daycare') {
    flagBoar = '2'

    WebUI.click(findTestObject('obj_reservation/4_/btn_Daycare'))
} else if (var_typeReserveation == 'SpaService') {
    WebUI.click(findTestObject('obj_reservation/4_/btn_Spa Service'))

    flagBoar = '3'
}

WebUI.click(findTestObject('obj_reservation/4_/i_location'))

switch (var_idFacility) {
    case 1:
        WebUI.delay(1)

        break
    case 2:
        WebUI.delay(1)

        break
    case 3:
        WebUI.delay(1)

        WebUI.click(findTestObject('obj_reservation/2_facility/i_3_facility'))

        break
    case 4:
        WebUI.delay(1)

        break
    case 5:
        WebUI.delay(1)

        break
    case 6:
        WebUI.delay(1)

        WebUI.click(findTestObject('obj_reservation/2_facility/i_6_facility'))

        break
    case 7:
        WebUI.delay(1)

        break
    case 8:
        WebUI.delay(1)

        break
    case 9:
        WebUI.delay(1)

        break
    case 10:
        WebUI.delay(1)

        break
    case 11:
        WebUI.delay(1)

        break
    case 12:
        WebUI.delay(1)

        break
    case 13:
        WebUI.delay(1)

        break
    case 14:
        WebUI.delay(1)

        break
    case 15:
        WebUI.delay(1)

        break
    case 16:
        WebUI.delay(1)

        break
    case 17:
        WebUI.delay(1)

        break
    case 18:
        WebUI.delay(1)

        break
    case 19:
        WebUI.delay(1)

        break
    case 20:
        WebUI.delay(1)

        break
}

String[] dateCI = var_checkinD.split(',')

String[] dateCO = var_checkoutD.split(',')

String[] arryPets = var_pets.split(',')

WebUI.delay(2)

if (var_repeting == 'Y') {
    WebUI.click(findTestObject('obj_reservation/4_/checkbox_repeating'))

    if (var_repeatingEvery == 'Weekly') {
        WebUI.selectOptionByValue(findTestObject('obj_reservation/4_/select_DailyWeeklyMonthlyOther'), 
            '2', true)
    } else if (var_repeatingEvery == 'Monthly') {
        WebUI.selectOptionByValue(findTestObject('obj_reservation/4_/select_DailyWeeklyMonthlyOther'), 
            '3', true)
    } else if (var_repeatingEvery == 'Other') {
        WebUI.selectOptionByValue(findTestObject('obj_reservation/4_/select_DailyWeeklyMonthlyOther'), 
            '4', true)
    }
}

WebUI.click(findTestObject('obj_reservation/4_/dateCheckIn'))

/*if (dateCI[2]=='2020') {
 WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_December19_ci_btnpullright'))
 WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_01_ci_0120'))
 }*/
//WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_December19_ci_btnpullright'))
WebUI.delay(2)

//WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_January20_ci_btnpullright'))
// recibe el dia de la fecha checkin
switch (dateCI[0]) {
    case '1':
        WebUI.click(findTestObject('obj_meses/button_01_ci'))

        break
    case '2':
        WebUI.click(findTestObject('obj_meses/button_02_ci'))

        break
    case '3':
        WebUI.click(findTestObject('obj_meses/button_03_ci'))

        break
    case '4':
        WebUI.click(findTestObject('obj_meses/button_04_ci'))

        break
    case '5':
        WebUI.click(findTestObject('obj_meses/button_05_ci'))

        break
    case '6':
        WebUI.click(findTestObject('obj_meses/button_06_ci'))

        break
    case '7':
        WebUI.click(findTestObject('obj_meses/button_07_ci'))

        break
    case '8':
        WebUI.click(findTestObject('obj_meses/button_08_ci'))

        break
    case '9':
        WebUI.click(findTestObject('obj_meses/button_09_ci'))

        break
    case '10':
        WebUI.click(findTestObject('obj_meses/button_10_ci'))

        break
    case '11':
        WebUI.click(findTestObject('obj_meses/button_11_ci'))

        break
    case '12':
        WebUI.click(findTestObject('obj_meses/button_12_ci'))

        break
    case '13':
        WebUI.click(findTestObject('obj_meses/button_13_ci'))

        break
    case '14':
        WebUI.click(findTestObject('obj_meses/button_14_ci'))

        break
    case '15':
        WebUI.click(findTestObject('obj_meses/button_15_ci'))

        break
    case '16':
        WebUI.click(findTestObject('obj_meses/button_16_ci'))

        break
    case '17':
        WebUI.click(findTestObject('obj_meses/button_17_ci'))

        break
    case '18':
        WebUI.click(findTestObject('obj_meses/button_18_ci'))

        break
    case '19':
        WebUI.click(findTestObject('obj_meses/button_19_ci'))

        break
    case '20':
        WebUI.click(findTestObject('obj_meses/button_20_ci'))

        break
    case '21':
        WebUI.click(findTestObject('obj_meses/button_21_ci'))

        break
    case '22':
        WebUI.click(findTestObject('obj_meses/button_22_ci'))

        break
    case '23':
        WebUI.click(findTestObject('obj_meses/button_23_ci'))

        break
    case '24':
        WebUI.click(findTestObject('obj_meses/button_23_ci'))

        break
    case '25':
        WebUI.click(findTestObject('obj_meses/button_25_ci'))

        break
    case '26':
        WebUI.click(findTestObject('obj_meses/button_26_ci'))

        break
    case '27':
        WebUI.click(findTestObject('obj_meses/button_27_ci'))

        break
    case '28':
        WebUI.click(findTestObject('obj_meses/button_28_ci'))

        break
    case '29':
        WebUI.click(findTestObject('obj_meses/button_29_ci'))

        break
    case '30':
        WebUI.click(findTestObject('obj_meses/button_30_ci'))

        break
    case '31':
        WebUI.click(findTestObject('obj_meses/button_31_ci'))

        break
}

//WebUI.setText(findTestObject('obj_reservation/4_/dateCheckIn'), var_checkDate)//not_run: WebUI.click(findTestObject('obj_reservation/3_date2020/Mes/CI_close'))
//log.logInfo('PRUEBA FLAG')
//log.logInfo(flagBoar)
if (flagBoar == '1') {
    WebUI.click(findTestObject('obj_reservation/4_/dateCheckOut'))

    //recibe el dia de la fecha checkout
    switch (dateCO[0]) {
        case '1':
            WebUI.click(findTestObject('obj_meses/button_01_co'))

            break
        case '2':
            WebUI.click(findTestObject('obj_meses/button_02_co'))

            break
        case '3':
            WebUI.click(findTestObject('obj_meses/button_03_co'))

            break
        case '4':
            WebUI.click(findTestObject('obj_meses/button_04_co'))

            break
        case '5':
            WebUI.click(findTestObject('obj_meses/button_05_co'))

            break
        case '6':
            WebUI.click(findTestObject('obj_meses/button_06_co'))

            break
        case '7':
            WebUI.click(findTestObject('obj_meses/button_07_co'))

            break
        case '8':
            WebUI.click(findTestObject('obj_meses/button_08_co'))

            break
        case '9':
            WebUI.click(findTestObject('obj_meses/button_09_co'))

            break
        case '10':
            WebUI.click(findTestObject('obj_meses/button_10_co'))

            break
        case '11':
            WebUI.click(findTestObject('obj_meses/button_11_co'))

            break
        case '12':
            WebUI.click(findTestObject('obj_meses/button_12_co'))

            break
        case '13':
            WebUI.click(findTestObject('obj_meses/button_13_co'))

            break
        case '14':
            WebUI.click(findTestObject('obj_meses/button_14_co'))

            break
        case '15':
            WebUI.click(findTestObject('obj_meses/button_15_co'))

            break
        case '16':
            WebUI.click(findTestObject('obj_meses/button_16_co'))

            break
        case '17':
            WebUI.click(findTestObject('obj_meses/button_17_co'))

            break
        case '18':
            WebUI.click(findTestObject('obj_meses/button_18_co'))

            break
        case '19':
            WebUI.click(findTestObject('obj_meses/button_19_co'))

            break
        case '20':
            WebUI.click(findTestObject('obj_meses/button_20_co'))

            break
        case '21':
            WebUI.click(findTestObject('obj_meses/button_21_co'))

            break
        case '22':
            WebUI.click(findTestObject('obj_meses/button_22_co'))

            break
        case '23':
            WebUI.click(findTestObject('obj_meses/button_23_co'))

            break
        case '24':
            WebUI.click(findTestObject('obj_meses/button_24_co'))

            break
        case '25':
            WebUI.click(findTestObject('obj_meses/button_25_co'))

            break
        case '26':
            WebUI.click(findTestObject('obj_meses/button_26_co'))

            break
        case '27':
            WebUI.click(findTestObject('obj_meses/button_27_co'))

            break
        case '28':
            WebUI.click(findTestObject('obj_meses/button_28_co'))

            break
        case '29':
            WebUI.click(findTestObject('obj_meses/button_29_co'))

            break
        case '30':
            WebUI.click(findTestObject('obj_meses/button_30_co'))

            break
        case '31':
            WebUI.click(findTestObject('obj_meses/button_31_co'))

            break
    }
}

/*if (dateCO[2]=='2020') {
 WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_December19__co_pullright'))
 WebUI.click(findTestObject('obj_reservation/5_botonesMesCalenda/button_31_co_0120'))
 }*/
not_run: WebUI.click(findTestObject('obj_reservation/3_date2020/Mes/CO_close'))

//WebUI.click(findTestObject('obj_reservation/3_date2020/Mes/CI_MesAnterior'))
//WebUI.click(findTestObject('obj_reservation/3_date2020/Mes/CI_MesPosterior'))
WebUI.click(findTestObject('obj_reservation/4_/timeCheckin'))

//log.logInfo('test timePicker')
switch (var_checkinT) {
    case 0:
        break
    case 24:
        break
    case 64:
        break
    case 88:
        break
    case 128:
        break
    case 152:
        break
    case 216:
        break
    case 256:
        break
    case 280:
        break
    case 320:
        break
    case 344:
        break
    case 384:
        break
    case 408:
        break
    case 448:
        break
    case 472:
        break
    case '800':
        WebUI.click(findTestObject('obj_meses/time_800am_ci'))

        break
    case 900:
        break
    case 1000:
        break
    case 1030:
        break
    case 1100:
        break
    case 1130:
        break
    case 1200:
        break
    case 1230:
        break
    case 1300:
        break
    case 1330:
        break
    case 1400:
        break
    case 1430:
        break
    case 1500:
        break
    case 1530:
        break
    case 1600:
        break
    case 1630:
        break
    case 1700:
        break
    case 1730:
        break
    case 1800:
        break
    case 1830:
        break
    case 1900:
        break
    case 1930:
        break
    case 2000:
        break
    case 2030:
        break
    case 2100:
        break
    case 2130:
        break
    case 2200:
        break
    case 2230:
        break
    case 2300:
        break
    case 2330:
        break
}

WebUI.click(findTestObject('obj_reservation/4_/timeCheckOut'))

switch (var_checkoutT) {
    case '1200':
        //log.logInfo('test 1200')
        WebUI.click(findTestObject('obj_meses/time_1200pm_co'))

        break
    case 1300:
        //log.logInfo('test 1300')
        break
}

WebUI.delay(2)

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


//WebUI.click(findTestObject('obj_reservation/4_/div_Ares'))
not_run: WebUI.click(findTestObject('object_reservations/i_Day_fa fa-circle-o ng-scope'))

if ((flagBoar == '1') || (flagBoar == '2')) {
    WebUI.click(findTestObject('obj_reservation/4_/div_suite_rad_deluxe'))
}

//WebUI.click(findTestObject('obj_reservation/4_/div_suite_rad_deluxe'))
WebUI.click(findTestObject('obj_reservation/4_/btn_next2'))

WebUI.delay(3)

if (flagBoar == '1') {
    WebUI.click(findTestObject('obj_reservation/4_/button_DeclineThisPromo'))
}

WebUI.delay(2)

WebUI.click(findTestObject('obj_reservation/4_/btn_next2'))

WebUI.click(findTestObject('obj_reservation/4_/button_Submit Reservation'))

WebUI.delay(2)

if ((flagBoar == '2') && (((var_repeatingEvery == 'Daily') || (var_repeatingEvery == 'Monthly')) || (var_repeatingEvery == 'Weekly'))) {
    WebUI.click(findTestObject('obj_reservation/4_/button_Ok'))

} else {
    WebUI.delay(2)
	try{
		WebUI.click(findTestObject('obj_reservation/4_/button_Return To Reservation'))
	} catch (Exception e) {
	e.printStackTrace()
	log.logInfo('ERROR EXCEPCION')
	/*int var = Integer.parseInt(var_idRowRes)
	 FileInputStream fis = new FileInputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationBoarding.xlsx')
	 XSSFWorkbook workbook = new XSSFWorkbook(fis)
	 XSSFSheet sheet = workbook.getSheet('Sheet1')
	 int rowCount = 	var_row
	 Row row = sheet.getRow(var)*/
	Cell cell1Err = rowNewRes.createCell(16,0)
	Cell cell2Err = rowNewRes.createCell(17,0)
	cell1Err.setCellType(cell1Err.CELL_TYPE_STRING)
	cell1Err.setCellValue('Error')
	cell2Err.setCellType(cell2Err.CELL_TYPE_STRING)
	cell2Err.setCellValue('Reservacion existente')
	FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationSpaService.xlsx')
	workbookNewRes.write(fos)
	fos.close()
	WebUI.delay(1)
	
	
	//cance xls
	Cell cellCan = rowCanRes.createCell(5,0)
	cellCan.setCellType(cellCan.CELL_TYPE_STRING)
	cellCan.setCellValue('Error en la reservacion')
	FileOutputStream fosCan = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_2cancelReservation.xlsx')
	workbookCanRes.write(fosCan)
	fosCan.close()
	
	}
	
    WebUI.delay(6)

    WebUI.click(findTestObject('obj_reservation/4_/button_Go to CheckOut'))

    WebUI.delay(2)

    log.logInfo(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))

    var_url = WebUI.getUrl()

    String[] arrayUrl = var_url.split('/')

	//int var = Integer.parseInt(var_idRowRes)
    WebUI.verifyElementText(findTestObject('obj_reservation/4_/span_status'), 
        '( BK )', FailureHandling.STOP_ON_FAILURE)

    Cell cell = rowNewRes.createCell(15,0)
	cell.setCellType(cell.CELL_TYPE_STRING)
	cell.setCellValue(arrayUrl[5])
	Cell cell2 = rowNewRes.createCell(16, 0)
	cell2.setCellType(cell.CELL_TYPE_STRING)
	cell2.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
	Cell cell3 = rowNewRes.createCell(18, 0)
	cell3.setCellType(cell.CELL_TYPE_STRING)
	cell3.setCellValue('Reservacion generada')

    FileOutputStream fos = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_1newReservationSpaService.xlsx')
	workbookNewRes.write(fos)
	fos.close()
	WebUI.delay(1)
	var_row++
	log.logInfo('POST CANCEL')
	
	Cell cellCan = rowCanRes.createCell(5,0)
	cellCan.setCellType(cellCan.CELL_TYPE_STRING)
	cellCan.setCellValue(arrayUrl[5])
	Cell cell2Can = rowCanRes.createCell(7, 0)
	cell2Can.setCellType(cell.CELL_TYPE_STRING)
	cell2Can.setCellValue(WebUI.getText(findTestObject('obj_reservation/4_/span_status')))
	FileOutputStream fosCan = new FileOutputStream('/home/leonardo-arkusmty/Desktop/P4P/DATA_AUTOMATINTESTING/data_2cancelReservation.xlsx')
	workbookCanRes.write(fosCan)
	fosCan.close()
}

