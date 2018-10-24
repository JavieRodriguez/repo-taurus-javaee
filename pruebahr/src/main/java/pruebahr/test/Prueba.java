package pruebahr.test;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.exception.DRException;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import pruebahr.bd.Conector;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conector conector = new Conector();
		try {
			conector.conectar();
			Statement statement = conector.con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEES");
			
			TextColumnBuilder columns[] = new TextColumnBuilder[2];
			columns[0]=col.column("EmployeeID", "EMPLOYEE_ID",type.stringType());
			columns[1]=col.column("FirstName", "FIRST_NAME",type.stringType());
			OutputStream pdfExporterBuilder;
			report()
			.setDataSource("SELECT * FROM EMPLOYEES", conector.con)
			.addTitle(cmp.text("Javier"))
			//.toPdf(pdfExporterBuilder)
			//.addColumnHeader(cmp.currentDate())
			.columns(columns)
			.show();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}	
			conector.desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
