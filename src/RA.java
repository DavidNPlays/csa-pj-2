// RA.java
public class RA extends Person {
    private int floor;
    public RA(String name, int wakeUpTime, String snack, String studyStyle, int floor) {
        super(name, wakeUpTime, snack, studyStyle);
        this.floor = floor;
    }
    // TODO: Override getInfo to include [RA] and floor number
    @Override
    public String getInfo() {
        return "[RA]" + super.getInfo() + " | Floor: " + floor; // correct format for returning
    }
}

