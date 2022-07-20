package javaOOP;

public class Topic_13_Class_And_Object {
	
	private int studentID;
	private String studentName;
	private double practicePoint, knowledgePoint;
	

	public Topic_13_Class_And_Object() {
	}

	public Topic_13_Class_And_Object(int studentID, String studentName, double practicePoint, double knowledgePoint) {
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
		Topic_13_Class_And_Object sv1 = new Topic_13_Class_And_Object(01, "Nguyen Mai An", 5, 5);
		sv1.showStudentInfo();
		
		Topic_13_Class_And_Object sv2 = new Topic_13_Class_And_Object(02, "Nguyen Tuan Anh", 8.1, 9.2);
		sv2.showStudentInfo();
		
		Topic_13_Class_And_Object sv3 = new Topic_13_Class_And_Object();
		sv3.setStudentID(03);
		sv3.setStudentName("Le Thi Tuyet");
		sv3.setKnowledgePoint(7.2);
		sv3.setPracticePoint(8);
		sv3.showStudentInfo();
		
		
		
	}

}
