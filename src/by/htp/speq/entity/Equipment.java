package by.htp.speq.entity;

public class Equipment {

    private String title;
    private double hourRate;

    public Equipment() {

    }

    public Equipment(String title, double hourRate) {
        this.title = title;
        this.hourRate = hourRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    @Override
    public String toString() {
        return "[Title: '" + title + "']"
                + " hourRate = " + hourRate;
    }


}
