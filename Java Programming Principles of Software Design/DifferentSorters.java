import java.util.*;

public class DifferentSorters {
    public static void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list);
        int quakeNumber = 600;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

    }

    public static void sortByTitleAndDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, new TitleAndDepthComparator());
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    public static void sortByLastWordInTitleThenByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";

        ArrayList<QuakeEntry> list = parser.read(source);

        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    public static void main(String[] args){
        // sortWithCompareTo();
        // sortByTitleAndDepth();
        sortByLastWordInTitleThenByMagnitude();

    }
}