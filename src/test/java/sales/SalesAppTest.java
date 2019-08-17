package sales;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class SalesAppTest {

	@Test
	public void testGenerateReport() throws ParseException {

        //Mock主類中所有依賴類
		SalesDao salesDao = Mockito.mock(SalesDao.class);
		SalesReportDao salesReportDao = Mockito.mock(SalesReportDao.class);
		Sales sales = Mockito.mock(Sales.class);
		EcmService ecmService = Mockito.mock(EcmService.class);
		SalesActivityReport report = Mockito.mock(SalesActivityReport.class);
		SalesReportData salesReportData = Mockito.mock(SalesReportData.class);

		List<SalesReportData> reportDataList = new ArrayList<>();
		int maxRow=100;

		for (int i=0;i<maxRow;i++){
			reportDataList.add(salesReportData);
//			when(salesReportData.getType()).thenReturn("");
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = dateFormat.parse("2019-08-09 00:00:00");
		Date date2 = dateFormat.parse("2020-08-09 00:00:00");

		//Stub  Spy指定行爲      不會調用真實方法，但也會返回指定的行爲
		SalesApp salesApp = Mockito.spy(new SalesApp());    //Spy部分mock，調用部分真實方法（返回mock的子分支）

		doReturn(salesDao).when(salesApp).getSalesDao();
		doReturn(salesReportDao).when(salesApp).getSalesReportDao();
		doReturn(ecmService).when(salesApp).getEcmService();
		doReturn(report).when(salesApp).generateReport(Mockito.any(),Mockito.any());

		//Stub  Mock指定行爲     會調用主類中所mock類真實的方法，返回指定的行爲
		when(salesDao.getSalesBySalesId(Mockito.any())).thenReturn(sales);
		when(sales.getEffectiveFrom()).thenReturn(date1);
		when(sales.getEffectiveTo()).thenReturn(date2);
		when(salesReportDao.getReportData(Mockito.any())).thenReturn(reportDataList);
		when(report.toXml()).thenReturn("");

		salesApp.generateSalesActivityReport("DUMMY", maxRow, false, false);

		Mockito.verify(ecmService, times(1)).uploadDocument(Mockito.any());
	}
}

