package home.pratice.comparator;

import home.pratice.domain.Book;

import java.util.Comparator;

public class BookNumberComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1 , Book book2) {
        if(book1.getBookNumber()<book2.getBookNumber()){
            return 1;
        } else if (book1.getBookNumber()>book2.getBookNumber()) {
            return -1;
        }
        return 0;
    }
}
