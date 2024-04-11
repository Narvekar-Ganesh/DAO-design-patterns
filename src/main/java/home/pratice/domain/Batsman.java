package home.pratice.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data

public class Batsman implements Comparable {
    private String name;
    private int numberOfCenturies;

    private int numberOfSixes;
    public Batsman(String name, int numberOfCenturies) {
        this.name=name;
        this.numberOfCenturies =numberOfCenturies;
    }

    @Override
    public int compareTo(Object o) {
        Batsman batsman2 = (Batsman) o;
        if (this.getNumberOfCenturies() < batsman2.getNumberOfCenturies()){
            return -1;
        } else if (this.getNumberOfCenturies() > batsman2.getNumberOfCenturies()) {
            return 1;
        }
        return 0;
    }
}
