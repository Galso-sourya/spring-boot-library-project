package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {
private String courseName;
private String courseType;
//private String instructorName;
private FullName instructorName;
public GreatLearning(String courseName) {
	this.courseName=courseName;
}
public GreatLearning(String courseName,String courseType) {
	this.courseName=courseName;
	this.courseType=courseType;
}
/*public GreatLearning() {
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getCourseType() {
	return courseType;
}
public void setCourseType(String courseType) {
	this.courseType = courseType;
}
public String getInstructorName() {
	return instructorName;
}
public void setInstructorName(String instructorName) {
	this.instructorName = instructorName;
}
public GreatLearning(String courseName, String courseType, String instructorName) {
	super();
	this.courseName = courseName;
	this.courseType = courseType;
	this.instructorName = instructorName;
}*/

}
