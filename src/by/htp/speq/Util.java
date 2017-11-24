package by.htp.speq;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {
    public static final String FILE_PATH = "resourses/station_info.txt";
    public static final String FILE2_PATH = "resourses/rented_equipment.txt";
    public static final String DATEFORMAT = "dd.MM.yyyy-HH:mm";
    private static final String DELIMETER = ",";

    public static ArrayList<String> readData(String file) {
        ArrayList<String> fileLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLines;
    }

    public static Equipment createEquipment(String[] values, int startIndex) {
        Equipment eq = new Equipment();
        eq.setTitle(values[startIndex].trim());
        eq.setHourRate(Double.parseDouble(values[startIndex + 1].trim()));
        return eq;
    }

    public static RentUnit createRentUnitFromLine(String[] values) {
        Equipment eq = createEquipment(values, 2);
        return new RentUnit(eq, Util.getDateFromFile(values[1].trim()), values[0].trim());
    }

    public static String[] getSplitValues(String line) {
        String[] values = line.split(DELIMETER);
        return values;
    }

    public static Date getDateFromFile(String dataLine) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dataLine);
        } catch (ParseException e) {
        }
        return date;
    }

    public static String getDateToFile(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
        return simpleDateFormat.format(date);
    }

    public static long fineHours(Date rentDate) {
        long dayInterval = getHoursInterval(rentDate);
        return dayInterval > 24 ? dayInterval - 24 : 0;
    }

    public static long getHoursInterval(Date rentDate) {
        Date currentDate = new Date();
        long dayInterval = (currentDate.getTime() - rentDate.getTime()) / (1000 * 60 * 60);
        return dayInterval;
    }


}
