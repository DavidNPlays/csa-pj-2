// Person.java
public class Person {
    protected String name;
    protected int wakeUpTime;
    protected String snack;
    protected String studyStyle;
    public Person(String name, int wakeUpTime, String snack, String studyStyle) {
        this.name = name;
        this.wakeUpTime = wakeUpTime;
        this.snack = snack;
        this.studyStyle = studyStyle;
    }
    // TODO: Return formatted info string
    public String getInfo() {
        return "Name: " + name +" | Wake-up: " + wakeUpTime + " | Snack: " + snack + " | Study: " + studyStyle;
    }
    public String getName() {
        return name;
    }
    public int getWakeUpTime() {
        return wakeUpTime;
    }
    public String getStudyStyle() {
        return studyStyle;
    }
}
