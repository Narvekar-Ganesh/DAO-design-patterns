package home.pratice.design.pattern.singleton;

public class ChiefMinisterRunner {
    public static void main(String[] args) {
        ChiefMinister chiefMinister = ChiefMinister.getInstance();
        System.out.println("chief-minister hashcode : " + chiefMinister.hashCode());

        chiefMinister = ChiefMinister.getInstance();
        System.out.println("chief-minister hashcode : " + chiefMinister.hashCode());

        chiefMinister = ChiefMinister.getInstance();
        System.out.println("chief-minister hashcode : " + chiefMinister.hashCode());

    }
}
