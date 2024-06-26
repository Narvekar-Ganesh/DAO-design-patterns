package home.pratice.comparator;

import home.pratice.domain.Batsman;

import java.util.Comparator;

public class BatsmanComparator implements Comparator<Batsman> {
    @Override
    public int compare(Batsman batsman1, Batsman batsman2) {
        if (batsman1.getNumberOfCenturies() < batsman2.getNumberOfCenturies()){
            return -1;
        } else if (batsman1.getNumberOfCenturies() > batsman2.getNumberOfCenturies()) {
            return 1;
        }
        return 0;
    }
}
