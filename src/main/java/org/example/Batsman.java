package org.example;

public class Batsman implements Comparable {
    private String name;
    private int numberOfCenturies;

    private int numberOfSixes;

    public Batsman() {

    }

    public String getName() {
        return name;
    }

    public Batsman(String name, int numberOfCenturies, int numberOfSixes) {
        this.name = name;
        this.numberOfCenturies = numberOfCenturies;
        this.numberOfSixes = numberOfSixes;
    }

    public int getNumberOfSixes() {
        return numberOfSixes;
    }

    public void setNumberOfSixes(int numberOfSixes) {
        this.numberOfSixes = numberOfSixes;
    }

    public int getNumberOfCenturies() {
        return numberOfCenturies;
    }

    public void setNumberOfCenturies(int numberOfCenturies) {
        this.numberOfCenturies = numberOfCenturies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Batsman(String name, int numberOfCenturies) {
        this.name = name;
        this.numberOfCenturies = numberOfCenturies;
    }

    @Override
    public String toString() {
        return "Batsman{" +
                "name='" + name + '\'' +
                ", numberOfCenturies=" + numberOfCenturies +
                ", numberOfSixes=" + numberOfSixes +
                '}';
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
