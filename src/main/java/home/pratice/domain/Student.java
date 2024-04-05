package home.pratice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data

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

    @OneToOne(cascade = CascadeType.ALL)
    private LibraryCard libraryCard;

    @OneToOne(cascade = CascadeType.ALL)
    private Book book;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MobileNumber> mobileNumbers;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    public static void main(String[] args) {
        String prefix = "Mr.";
        String firstName = "Swapnil";
        String midleName = "Aba";
        String lastName = "Narvekar";
        String string4 = "Object class is Mother of all class ";
        String toBeTrim = "     Sahil         ";
        String fullName = prefix.concat(" ").concat(firstName).concat(" ").concat(midleName).concat(" ").concat(lastName);// concate to or more string
        System.out.println("full Name is: " + fullName);
        System.out.println(string4.substring(7));// returns subrting of string
        System.out.println(string4.substring(7, 15));

        char result = string4.charAt(12);//  Returns the character at position denoted by the int index
        System.out.println(result);

        String toUpperCase = string4.toUpperCase();// to upper class
        System.out.println(toUpperCase);

        String tolowerCase = string4.toLowerCase();//to lower class
        System.out.println(tolowerCase);

        String trim = toBeTrim.trim();//ommit white space
        System.out.println(trim);


    }

}
