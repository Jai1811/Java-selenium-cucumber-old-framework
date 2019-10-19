package allocator;

import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.util.Scanner;

public class Exceldata {

	public static void CreateBusinessFlowExcell() throws IOException {

		Scanner sc = new Scanner(System.in);

		int value = sc.nextInt();

		System.out.println("Enter the total number of keywords you want to create " + value);

		ArrayList<String> keywords = new ArrayList<>(value);

		keywords.add("TestCase");

		for (int i = 1; i <= value; i++) {

			keywords.add("keyword" + i);

		}

		Workbook workbook = new XSSFWorkbook();

		CreationHelper createhelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("keywords");

		// Font headerfont = workbook.createFont();

		Row headerow = sheet.createRow(0);

		for (int i = 0; i < value; i++) {

			Cell cell = headerow.createCell(i);

			cell.setCellValue(keywords.get(i));

		}

		FileOutputStream fileOut = new FileOutputStream("D:\\java\\Selenuim\\flow.xlsx");

		workbook.write(fileOut);

		fileOut.close();

	}

}
