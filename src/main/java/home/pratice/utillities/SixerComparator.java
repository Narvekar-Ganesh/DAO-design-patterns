package home.pratice.utillities;

import home.pratice.domain.Batsman;

import java.util.Comparator;

public class SixerComparator implements Comparator<Batsman> {
    @Override
    public int compare(Batsman batsman1, Batsman batsman2) {
        if(batsman1.getNumberOfSixes()<batsman2.getNumberOfSixes()){
            return -1;
        }else if(batsman1.getNumberOfSixes()>batsman2.getNumberOfSixes()){
            return 1;
        }
        return 0;
    }
}
