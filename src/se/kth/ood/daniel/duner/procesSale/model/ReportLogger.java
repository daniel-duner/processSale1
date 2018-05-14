package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Stores error reports in a textfile
 * @author danielduner
 *
 */
public class ReportLogger {
	private List<String> reportLog = new ArrayList<String>();
	private static ReportLogger instance = new ReportLogger();

	private ReportLogger(){
	}
	
	/**
	 * @return the only object of reportLogger
	 */
	public static ReportLogger getInstance(){
	      return instance;
	   }
	/**
	 * Adds a String to the report log
	 * @param report represents the error report
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void addReport(String report) throws FileNotFoundException, UnsupportedEncodingException{
		reportLog.add(report);
		createLogFile();
	}

	private void createLogFile() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("Error report log "+LocalDate.now().toString()+".log","UTF-8");
		StringBuilder str = new StringBuilder();
		int indexNo = 0;
		for(String reports : reportLog) {
			indexNo++;
			str.append(indexNo +". "+ reports+"\r\n");
		}
		writer.println("Error Report Log:");
		writer.println(str);
		writer.close();
	}
	
}
