package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;
import home.pratice.domain.User;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;

public class LibraryCardWithH2DAO implements LibraryCardDAO {
    public LibraryCard getLibraryCard(Long cardId) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        LibraryCard libraryCard = session.byId(LibraryCard.class).load(cardId);
        session.getTransaction().commit();
        return libraryCard;
    }

    public Boolean saveLibraryCard(int cardNumber, String cardName) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNumber(cardNumber);
        libraryCard.setCardName(cardName);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Serializable savedId = session.save(libraryCard);
        Long primaryKey = (Long) savedId;
        session.getTransaction().commit();
        if (primaryKey != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteLibraryCard(Long libraryCardID){
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        LibraryCard libraryCardFromDatabase = session.byId(LibraryCard.class).load((Long)libraryCardID);
        if(libraryCardFromDatabase!=null){
            session.delete(libraryCardFromDatabase);
            session.getTransaction().commit();
            return true;
        }else{
            return false;
        }

    }
}
