package sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SalesApp {

	SalesDao salesDao;
	SalesReportDao salesReportDao;
	EcmService ecmService;

	public EcmService getEcmService() {
		return ecmService;
	}
	public SalesDao getSalesDao() {
		return salesDao;
	}

	public SalesReportDao getSalesReportDao() {
		return salesReportDao;
	}


	public void generateSalesActivityReport(String salesId, int maxRow, boolean isNatTrade, boolean isSupervisor) {

		SalesDao salesDao = getSalesDao();
		Sales sales = salesDao.getSalesBySalesId(salesId);  //根據ID獲得Sales

		SalesReportDao salesReportDao = getSalesReportDao();
		List<SalesReportData> reportDataList = salesReportDao.getReportData(sales);    //根據Sales獲得reportDataList

//		List<SalesReportData> filteredReportDataList = new ArrayList<SalesReportData>();

		List<String> headers = null;
		if (salesId == null) {
			return;
		}
		Date today = new Date();
		Date date=sales.getEffectiveTo();
		if (today.after(sales.getEffectiveTo())
				|| today.before(sales.getEffectiveFrom())){
			return;
		}


//		for (SalesReportData data : reportDataList) {      //遍歷reportDataList，添加至filteredReportDataList
//			if ("SalesActivity".equalsIgnoreCase(data.getType())) {
//				if (data.isConfidential()) {
//					if (isSupervisor) {
//						filteredReportDataList.add(data);
//					}
//				}else {
//					filteredReportDataList.add(data);
//				}
//			}
//		}
//
//		List<SalesReportData> tempList = new ArrayList<SalesReportData>();  //把reportDataList數據添加至tempList
//		for (int i=0; i < reportDataList.size() || i < maxRow; i++) {
//			tempList.add(reportDataList.get(i));
//		}
//		filteredReportDataList = tempList;


		if (isNatTrade) {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Time");
		} else {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Local Time");
		}

		SalesActivityReport report = this.generateReport(headers, reportDataList);

		EcmService ecmService =getEcmService();

		ecmService.uploadDocument(report.toXml());

	}

	protected SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
		// TODO Auto-generated method stub
		return null;
	}

}
