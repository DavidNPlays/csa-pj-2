// Roommate.java
public class Roommate extends Person {
    private int roomNum;
    public Roommate(String name, int wakeUpTime, String snack, String studyStyle, int roomNum) {
        super(name, wakeUpTime, snack, studyStyle);
        this.roomNum = roomNum;
    }
// TODO: Override getInfo to include room number // **Zaid did this part**

    //@Override
    public String getInfo()
    {
        return super.getInfo() + " | Room: " + roomNum;
    }
}
