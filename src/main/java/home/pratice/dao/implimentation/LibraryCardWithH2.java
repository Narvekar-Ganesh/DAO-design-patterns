package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

public class LibraryCardWithH2 implements LibraryCardDAO {
    public LibraryCard getLibraryCard(int cardNumber){
         LibraryCard libraryCard = new LibraryCard();
         libraryCard.setCardNumber(123);
         libraryCard.setCardName("H2");
//        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
//        session.beginTransaction();
//        LibraryCard libraryCard=(LibraryCard) session.byId(LibraryCard.class).load((Long)cardNumber);
//        session.getTransaction().commit();;
        return libraryCard;

    }
    public void saveLibraryCard(int cardNumber, String cardName ){
        LibraryCard libraryCard =new LibraryCard();
        libraryCard.setCardNumber(cardNumber);
        libraryCard.setCardName(cardName);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(libraryCard);
        session.getTransaction().commit();;
        System.out.println(" LibraryCard persisted succssefully");
    }
}
