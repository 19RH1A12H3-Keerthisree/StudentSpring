package com.springboot;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class MainMethod
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ApplicationContext context=new ClassPathXmlApplicationContext("Cfg.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		StudentD D=(StudentD)context.getBean("studentD");
		do
		{
			System.out.println("Enter your choice :");
			System.out.println("1. Insert 2. Delete 3. Update 4. Select  5. Exit");
			int n=sc.nextInt();
			switch(n) {
			
			case 1:System.out.println("Insertion");
				Student s1=new Student();
				System.out.println("Enter Id :");
				s1.setStudentId(sc.nextInt());
				System.out.println("Enter Name :");
				s1.setStudentName(sc.next());
				System.out.println("Enter Gender :");
				s1.setStudentGender(sc.next());
				System.out.println("Enter marks :");
				s1.setStudentMarks(sc.nextInt());
				System.out.println("Enter Mobile number :");
				s1.setStudentMobileno(sc.nextLong());
				int status=D.insertStudent(s1);
				System.out.println(status);
				break;
			
			case 2:System.out.println("deletion");
				
				Student s2=new Student();
				s2.setStudentId(sc.nextInt());
				int status1=D.deleteStudent(s2);
				System.out.println(status1);
				break;
			
			//case 3:System.out.println("Updation");
			
			
			 case 3:
			        System.out.println("Enter the studentId whose information is to be updated");
			        int n3=sc.nextInt();
			        System.out.println("a.Update studentName b.Update studentGender c.Update studentMarks d.Update studentMobileno. ");
			        char ch1=sc.next().charAt(0);
			        switch(ch1) {
			        case 'a':
			        	String query3="update student set studentName=? where studentId=?";
			        System.out.println("Enter the studentName to which the name is to be updated");
			        String s4=sc.next();
			        template.update(query3,s4,n3);
			        break;
			        case 'b':
			        	String query4="update student set studentGender=? where studentId=?";
			        System.out.println("Enter the studentGender to which the gender is to be updated");
			        String s5=sc.next();
			        template.update(query4,s5,n3);
			        break;
			        case 'c':
			        	String query5="update student set studentMarks=? where studentId=?";
			        System.out.println("Enter the studentMarks to which the marks is to be updated");
			        String s6=sc.next();
			        template.update(query5,s6,n3);
			        break;
			        case 'd':
			        	String query6="update student set studentMobileno=? where studentId=?";
			        System.out.println("Enter the studentMobileno to which the number is to be updated");
			        String s7=sc.next();
			        template.update(query6,s7,n3);
			        break;}
			        System.out.println("Record updated.. ");
			        break;
	    		
		
			/*	Student s3=new Student();
				System.out.println("Enter student Id to be updated:");
				s3.setStudentId(sc.nextInt());
				System.out.println("Enter student name to be updated:");
				s3.setStudentName(sc.next());
				System.out.println("Enter student marks to be updated:");
				s3.setStudentMarks(sc.nextInt());
				System.out.println("Enter student gender to be updated:");
				s3.setStudentGender(sc.next());
				System.out.println("Enter mobile number to be updated:");
				s3.setStudentMobileno(sc.nextLong());
				
				int status2=D.updateStudent(s3);
				System.out.println(status2);
				break;*/
				
				case 4:System.out.println("Selecting");
				Student s8=new Student();
				List<Student> w=D.selectStudent(s8);
				for (Student r : w) {
					System.out.println(r.getStudentId()+"     "+r.getStudentName()+"     "+r.getStudentGender()+"     "+r.getStudentMarks()+"     "+r.getStudentMobileno());
				}
				break;
	
				case 5:System.out.println("existing");
				System.exit(0);
				break;
				}
			
			}while(true);
			

		
	/*	Student s1=new Student();
		//Student student1=(Student)context.getBean("student1");
		s1.setStudentId(5);
		s1.setStudentName("Roohi");
		s1.setStudentGender("Female");
		s1.setStudentMarks(675);
		int status=D.insertStudent(s1);
		System.out.println(status);	*/
		
		
		//System.out.println(student1.getStudentId()+ " "+student1.getStudentName()+" "+student1.getStudentGender()+" "+student1.getStudentMarks());

		
		
		
	}
}
