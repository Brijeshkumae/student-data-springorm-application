package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.enity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao con=context.getBean("studentDao",StudentDao.class);
      //  Student student=new Student(234,"brijesh","meerut");
      //  int r=con.insert(student);
      //  System.out.println("data inserted "+r);
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         boolean value=true;
        while(value) {
        System.out.println(" press 1 for add new student");
        System.out.println(" press 2 for display all student");
        System.out.println(" press 3 for get details for single student");
        System.out.println(" press 4 for delete new student");
        System.out.println(" press 5 for update student");
        System.out.println(" press 6 for exit");
       
        try {
        int input=Integer.parseInt(br.readLine());
        	switch(input) {
        	
        	case 1:
        		// add student
        		System.out.println("Enter student id");
        		int uId=Integer.parseInt(br.readLine());
        		System.out.println("Enter student name");
        		String uName=br.readLine();
        		System.out.println("Enter student city");
        		String uCity=br.readLine();
        		Student s=new Student();
        	    s.setStudentId(uId);
        	    s.setStudentName(uName);
        	    s.setStudentCity(uCity);
        		int r=con.insert(s);
        		System.out.println(r+ "  student added");
        		System.out.println("**************************************");
        		break;
        		
        	case 2:
        		// select all student
        	         List<Student> stu=con.getAllStudent();
        	         for(Student t:stu) {
        	        	 System.out.println("id "+t.getStudentId());
        	        	 System.out.println("Name "+t.getStudentName());
        	        	 System.out.println("city "+t.getStudentCity());
        	        	 System.out.println("*******************************");
        	         }
        		
        		break;
        	case 3:
        		System.out.println("Enter student id");
        		int usId=Integer.parseInt(br.readLine());
        		Student x=con.getStudent(usId);
        	     System.out.println("id "+x.getStudentId());
   	        	 System.out.println("Name "+x.getStudentName());
   	        	 System.out.println("city "+x.getStudentCity());
   	        	 System.out.println("*******************************");
   	             break;
        	case 4:
        		System.out.println("Enter student id");
        		int userId=Integer.parseInt(br.readLine());
        		con.deleteStudent(userId);
        		System.out.println("delete done");
        		break;
        	case 5:
        		System.out.println("Enter student id which you want to update");
        		int useId=Integer.parseInt(br.readLine());
        		System.out.println("Enter student name");
        		String useName=br.readLine();
        		System.out.println("Enter student city");
        		String useCity=br.readLine();
        		Student student=new Student();
        		student.setStudentId(useId);
        		student.setStudentName(useName);
        		student.setStudentCity(useCity);
        		
        		con.updateStudent(student);
        		System.out.println("update data");
        		
        		
        		break;
        	case 6:
        		value=false;
        		break;
        	}
        	
        	
        	
        	
        }catch(Exception e) {
        	System.out.println("invalid input try with other one");
        	System.out.println(e.getMessage());
        }
    }
}
}