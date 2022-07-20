package javaOOP;

public class Variable_Method_Property {
	
	private int studentID;
	private String studentName;
	private double practicePoint, knowledgePoint;
	

	public Variable_Method_Property() {
	}

	public Variable_Method_Property(int studentID, String studentName, double practicePoint, double knowledgePoint) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.practicePoint = practicePoint;
		this.knowledgePoint = knowledgePoint;
	}


	private int getStudentID() {
		return studentID;
	}


	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	private String getStudentName() {
		return studentName;
	}


	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	private double getPracticePoint() {
		return practicePoint;
	}


	private void setPracticePoint(double practicePoint) {
		this.practicePoint = practicePoint;
	}


	private double getKnowledgePoint() {
		return knowledgePoint;
	}


	private void setKnowledgePoint(double knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}


	public double getAveragePoint() {
		return ((knowledgePoint + practicePoint*2)/3);
	}
	
	public void showStudentInfo() {
		System.out.println("Student ID: "+ studentID);
		System.out.println("Student Name: "+ studentName);
		System.out.println("Student  Average Point: "+ getAveragePoint());
	}	
	
	public static void main(String[] args) {
		Variable_Method_Property sv1 = new Variable_Method_Property(01, "Nguyen Mai An", 5, 5);
		sv1.showStudentInfo();
		
		Variable_Method_Property sv2 = new Variable_Method_Property(02, "Nguyen Tuan Anh", 8.1, 9.2);
		sv2.showStudentInfo();
		
		Variable_Method_Property sv3 = new Variable_Method_Property();
		sv3.setStudentID(03);
		sv3.setStudentName("Le Thi Tuyet");
		sv3.setKnowledgePoint(7.2);
		sv3.setPracticePoint(8);
		sv3.showStudentInfo();
		
		
		
	}

}
