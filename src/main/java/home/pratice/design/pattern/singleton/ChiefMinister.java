package home.pratice.design.pattern.singleton;


/**
 * Singleton Design pattern- GoF
 * 1. make a default constructor as private
 * 2. have a static variable of the same class
 * 3. create a new method - getInstance();
 * 4. add a condition to check nullability and create a new instance if already not created
 * 5. return the already created object
 * 5. do not provide setter methods
 */
public class ChiefMinister {
    private String name;

    private static ChiefMinister chiefMinister;

    private ChiefMinister(){
        chiefMinister.name = "Shinde";
    }

    public String getName() {
        return name;
    }

    public static ChiefMinister getInstance(){
        if (chiefMinister == null){
            chiefMinister = new ChiefMinister();
        }
        return chiefMinister;
    }
}
