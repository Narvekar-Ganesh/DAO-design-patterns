package home.pratice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column
    private int rollNumber;

    @Column
    private String name;
    @Column
    private String gender;

    @Column
    private String addresLine1;

    @Column
    private String addresLine2;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddresLine1(String addresLine1) {
        this.addresLine1 = addresLine1;
    }

    public void setAddresLine2(String addresLine2) {
        this.addresLine2 = addresLine2;
    }

    public String getAddresLine1() {
        return addresLine1;
    }

    public String getAddresLine2() {
        return addresLine2;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private LibraryCard libraryCard;

    @OneToOne(cascade = CascadeType.ALL)
    private Book book;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", addresLine1='" + addresLine1 + '\'' +
                ", addresLine2='" + addresLine2 + '\'' +
                ", libraryCard=" + libraryCard +
                ", book=" + book +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<MobileNumber> mobileNumbers;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book){
        this.book=book;
    }
    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

}
