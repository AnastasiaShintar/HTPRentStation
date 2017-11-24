package by.htp.speq.entity;

import by.htp.speq.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentUnit {

    private String userName;
    private Equipment equipment;
    private Date rentDate;
    private double totalCost;
    private double fine;

    public RentUnit(Equipment equipment, Date rentDate, String userName) {
        this.userName = userName;
        this.equipment = equipment;
        this.rentDate = rentDate;
    }

    public String getUserName() {
        return userName;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public double getTotalCost() {
        return equipment.getHourRate() * Util.getHoursInterval(rentDate) + getFine();
    }

    public double getFine() {
        return Util.fineHours(rentDate) * (equipment.getHourRate() + 0.1d * equipment.getHourRate()) ;
    }

    @Override
    public String toString() {
        return "[customer: " + userName + "] "
                + equipment
                + " / fine = " + String.format("%.2f", getFine())
                + " / totalCost = " + String.format("%.2f", getTotalCost())
                + " / rentDate: " + new SimpleDateFormat(Util.DATEFORMAT).format(rentDate)
        		+ " / hoursInterval: " + Util.getHoursInterval(rentDate);
    }
}
