package home.pratice.service;

import home.pratice.dao.implimentation.StudentWithH2DAO;
import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Book;
import home.pratice.domain.LibraryCard;
import home.pratice.domain.MobileNumber;
import home.pratice.domain.Student;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
@Getter
@Setter

public class StudentRegistrationService {
    private StudentDAO studentDAO; //has-a relationship


    public Student getStudent(Long studentId) {
        Student student = studentDAO.getStudent(studentId);
        return student;
    }

    public String registerStudent(int rollNumber, String name, String gender, String addresLine1, String addresLine2, String mobileNumber1, String mobileNumber2) {
        Student student = prepareStudent(rollNumber, name, gender, addresLine1, addresLine2);
        LibraryCard libraryCard = prepareLibraryCard(name);
        Book book = prapareBook(rollNumber, name);
        List<MobileNumber> mobileNumbers = prepareMobileNumbers(mobileNumber1, mobileNumber2);

        student.setBook(book);
        student.setLibraryCard(libraryCard);
        student.setMobileNumbers((ArrayList<MobileNumber>) mobileNumbers);

        Boolean result = studentDAO.saveStudent(student);
        if (result) {
            return "Student with student name:" + name + "is registered succssefully";
        } else {
            return "Student with student name:" + name + "is not registered";
        }
    }

    private List<MobileNumber> prepareMobileNumbers(String... mobileNumbersAsString) { //varargs arguments
        List<MobileNumber> mobileNumbers = new ArrayList<>();

        for(String eachMobileNumberAsString : mobileNumbersAsString){
            MobileNumber mobileNumber = new MobileNumber();
            mobileNumber.setNumber(eachMobileNumberAsString);
            mobileNumber.setCountryCode("+91");

            mobileNumbers.add(mobileNumber);
        }

        return mobileNumbers;
    }

//    public String registerSingleStudent(int rollNumber,String   name ){
//        Student student = saveSingleStudent(rollNumber,+name);
//    }


    public String deleteStudent(Long studentId) {
        Boolean result = studentDAO.deleteStudent(studentId);
        if (result) {
            return "Requested student is deleted sucssefully";
        } else {
            return "Requested student is not deleted ";
        }
    }

    private Student prepareStudent(int rollNumber, String name, String gender, String addresLine1, String addresLine2) {
        Student student = new Student();
        student.setRollNumber(rollNumber);
        student.setName(name);
        student.setGender(gender);
        student.setAddresLine1(addresLine1);
        student.setAddresLine2(addresLine2);
        return student;
    }

    private LibraryCard prepareLibraryCard(String studentName) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNumber(9999);
        libraryCard.setCardName(studentName);
        return libraryCard;
    }

    private Book prapareBook(int rollNumber, String name) {
        Book book = new Book();
        book.setBookNumber(456);
        book.setBookName(name);
        return book;
    }

    public String updateStudent(Long id, String nameToBeUpdate) {
        Student studentToBeUpdate = studentDAO.getStudent(id);
        if (studentToBeUpdate != null) {
            studentToBeUpdate.setName(nameToBeUpdate);
            studentDAO.updateStudent(studentToBeUpdate);
            return "Student id updated successfully";
        } else {
            return "Student is not updated";
        }
    }


}


