package hbmtest;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hbm.Countries;
import hbm.Departments;
import hbm.Employees;
import hbm.HibernateUtil;
import hbm.JobHistory;
import hbm.Jobs;
import hbm.Locations;
import hbm.Regions;

public class TestMapeo {
	
	public static void createQuery1(Session session){
		String query="FROM Countries";
		List<Countries> result = ((List<Countries>) session.createQuery( query ).list());
		for ( Countries c :  result ) {
		    System.out.println(c.toString()+" "+c.getRegions().getRegionName());
		} 
	}
	
	public static void createQuery2(Session session, double parRegionId){
		String query = "FROM Regions as r WHERE r.regionId = :parRegionId ";
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parRegionId", BigDecimal.valueOf(parRegionId));
		List<Regions> result = (List<Regions>) queryRes.list();
		for ( Regions r :  result ) {
		    System.out.println(r);
		    for (Countries c : r.getCountrieses()) {
				System.out.println("\t"+c.toString());
			}
		} 
	}
	
	public static void createQuery3(Session session, String string) {
		List<Locations> result = ((List<Locations>) session.createQuery( string ).list());
		for ( Locations l :  result ) {
		    System.out.println(l.getLocationId()+" "+l.getStreetAddress()+" "+l.getStateProvince()+" "+l.getCountries().getCountryName());
		}
	}
	
	public static void createQuery4(Session session,String query, Short parLocationId){
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parLocationId", parLocationId);
		List<Locations> result = ((List<Locations>) queryRes.list());
		for ( Locations l :  result ) {
		    System.out.println(l.getLocationId()+" "+l.getStreetAddress()+" "+l.getStateProvince());
		    for (Departments d : l.getDepartmentses()) {
				System.out.println("    "+d.getDepartmentId()+" "+d.getDepartmentName());
			}
		} 
	}
	
	public static void createQuery5(Session session,String query){
		List<Employees> result = ((List<Employees>) session.createQuery( query ).list());
		for ( Employees e :  result ) {
		    System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName()+" "+(e.getDepartments()==null?"No tiene departamento":e.getDepartments().getDepartmentId()+" "+e.getDepartments().getDepartmentName()));
		} 
	}
	public static void createQuery6(Session session,String query){
		List<Departments> result = ((List<Departments>) session.createQuery( query ).list());
		for ( Departments d :  result ) {
		    System.out.println(d.getDepartmentId()+" "+d.getDepartmentName()+" "+(d.getEmployees()==null?"No tiene jefe.":d.getEmployees().getEmployeeId()+" "+d.getEmployees().getFirstName()+" "+d.getEmployees().getLastName()));
		} 
	}
	
	public static void createQuery7(Session session,String query, Short parDepartmentId){
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parDepartmentId", parDepartmentId);
		List<Departments> result = ((List<Departments>) queryRes.list());
		for ( Departments d :  result ) {
		    System.out.println(d.getDepartmentId()+" "+d.getDepartmentName());
		    for (Employees e : d.getEmployeeses()) {
				System.out.println("    "+e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName());
			}
		} 
	}
	
	public static void createQuery8(Session session,String query){
		List<Employees> result = ((List<Employees>) session.createQuery( query ).list());
		for ( Employees e :  result ) {
		    System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName()+" "+(e.getEmployees()==null?"No tiene jefe":e.getEmployees().getEmployeeId()+" "+e.getEmployees().getFirstName()+" "+e.getEmployees().getLastName()));
		} 
	}
	
	public static void createQuery9(Session session,String query, Integer parEmployeeId){
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parEmployeeId", parEmployeeId);
		List<Employees> result = ((List<Employees>) queryRes.list());
		for ( Employees e :  result ) {
		    System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName());		    
		    for (Employees emp : e.getEmployeeses()) {
		    					System.out.println("    "+emp.getEmployeeId()+" "+emp.getFirstName()+" "+emp.getLastName());
			}
		} 
	}
	
	public static void createQuery10(Session session,String query, Integer parEmployeeId){
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parEmployeeId", parEmployeeId);
		List<Employees> result = ((List<Employees>) queryRes.list());
		for ( Employees e :  result ) {
		    System.out.println(e.getEmployees().getEmployeeId()+" "+e.getEmployees().getFirstName()+" "+e.getEmployees().getLastName());		    
		    System.out.println("       "+e.getEmployees().getDepartments().getDepartmentId()+" "+e.getEmployees().getDepartments().getDepartmentName());
		} 
	}
	public static void createQuery11(Session session,String query){
		Query queryRes = session.createQuery(query);
		List<Employees> result = ((List<Employees>) queryRes.list());
		for ( Employees e :  result ) {
		    System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getJobs().getJobId()+" "+e.getJobs().getJobTitle());		    
		} 
	}
	
	public static void createQuery12(Session session,String query, String parJobId){
		Query queryRes = session.createQuery(query);
		queryRes.setParameter("parJobId", parJobId);
		List<Jobs> result = ((List<Jobs>) queryRes.list());
		for ( Jobs j :  result ) {
		    System.out.println(j.getJobId()+" "+j.getJobTitle());	
		    for (Employees e : j.getEmployeeses()) {
		    	System.out.println("       "+e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName());
			}
		} 
	}
	public static void createQuery13(Session session,String query){
		Query queryRes = session.createQuery(query);
		List<JobHistory> result = ((List<JobHistory>) queryRes.list());
		for ( JobHistory jh :  result ) {
		    System.out.println(jh.getEmployees().getEmployeeId()+" "+jh.getEmployees().getFirstName()+" "+jh.getEmployees().getLastName()+" "+jh.getJobs().getJobId()+" "+jh.getJobs().getJobTitle()+" "+jh.getDepartments().getDepartmentId()+" "+jh.getDepartments().getDepartmentName());		    
		} 
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(" Ejercicio 1");
		createQuery1(session);
		System.out.println(" Ejercicio 2");
		createQuery2( session, 2.0);
		System.out.println(" Ejercicio 3");
		createQuery3(session, "FROM Locations as l");
		System.out.println(" Ejercicio 4");
		createQuery4( session,"FROM Locations as l WHERE l.locationId = :parLocationId" , Short.valueOf("1700"));
		System.out.println(" Ejercicio 5");
		createQuery5( session,"FROM Employees as e" );
		System.out.println(" Ejercicio 6");
		createQuery6( session,"FROM Departments as d" );

		System.out.println(" Ejercicio 7");
		createQuery7( session,"FROM Departments as d WHERE d.departmentId = :parDepartmentId", Short.valueOf("110"));
		System.out.println(" Ejercicio 8");
		createQuery8( session,"FROM Employees as e" );
		System.out.println(" Ejercicio 9");
		createQuery9( session,"FROM Employees as e WHERE e.employeeId = :parEmployeeId", Integer.parseInt("100"));
		System.out.println(" Ejercicio 10");
		createQuery10( session,"FROM Employees as e WHERE e.employeeId = :parEmployeeId", Integer.parseInt("102"));
		System.out.println(" Ejercicio 11");
		createQuery11( session,"FROM Employees as e");
		System.out.println(" Ejercicio 12");
		createQuery12( session,"FROM Jobs as j WHERE j.jobId = :parJobId","SA_REP");
		System.out.println(" Ejercicio 13"); 
		createQuery13( session,"FROM JobHistory as jh");
		insertarPais();
//		eliminarPais();
		session.close();
	   
	}
	
//	private static void buscarRegionesSinPaises(){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		List regiones= session.createQuery("FROM Regions r where r.countrieses IS EMPTY").list();
//		for (Regions r :  regiones) {
//			
//		}
//	}

	private static void insertarPais() {
		Regions r = new Regions(BigDecimal.valueOf(5.0));
		Countries c = new Countries("109", r, "ddd", null);
		
		
		
	}

	

}
