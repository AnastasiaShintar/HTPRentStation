package by.htp.speq.logic.rentunit;

import by.htp.speq.Util;
import by.htp.speq.entity.RentUnit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class RentLogicFileImpl implements IRentUnitLogic {
    @Override
    public ArrayList<RentUnit> readRentUnits() {
        ArrayList<RentUnit> rentUnits = new ArrayList<>();
        for (String line : Util.readData(Util.FILE2_PATH)) {
            String[] values = Util.getSplitValues(line);
            RentUnit rentUnit = Util.createRentUnitFromLine(values);
            rentUnits.add(rentUnit);
        }
        return rentUnits;
    }

    @Override
    public void addRentUnit(RentUnit rentUnit) {
        StringBuilder sb = new StringBuilder()
                .append(rentUnit.getUserName())
                .append(", ")
                .append(Util.getDateToFile(rentUnit.getRentDate()))
                .append(", ")
                .append(rentUnit.getEquipment().getTitle())
                .append(", ")
                .append(rentUnit.getEquipment().getHourRate());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Util.FILE2_PATH, true))) {
            bw.write(sb.toString());
            bw.write("\n");
        } catch (Exception e) {
        }
    }

    @Override
    public RentUnit deleteRentUnit(String title) {
        RentUnit deletedRentUnit = null;
        ArrayList<String> lines = Util.readData(Util.FILE2_PATH);
        if (lines.isEmpty()) {
            System.out.println("Весь инвентарь на базе!");
            return null;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Util.FILE2_PATH))) {
            for (String line : lines) {
                String eqTitle = Util.getSplitValues(line)[2].trim();
                if (!title.equals(eqTitle)) {
                    bw.write(line);
                    bw.write("\n");
                } else {
                    String[] values = Util.getSplitValues(line);
                    deletedRentUnit = Util.createRentUnitFromLine(values);
                    if (Util.getHoursInterval(deletedRentUnit.getRentDate()) == 0) {
                        bw.write(line);
                        bw.write("\n");
                        System.out.println("Данный инвентарь в аренде меньше часа!");
                        return null;
                    }
                }
            }
            if (deletedRentUnit == null) {
                System.out.println("Не найдено оборудование с таким названием!");
            }
        } catch (Exception e) {
        }
        return deletedRentUnit;
    }


}


/**
 * �������� �. ���� ����������� ������ ������������� ������������
 * ����� ������� ���� ����� ��������� ��������
 * <p>
 * � ����� ������������ �������� ����� ���. ����� ������������� ��������� ����������. � ���� ������ ���� ���������� ������ ������ ����.
 * � ����� ���������� ���������� ������ ������� ������ ������������� ������������
 * � ������ ���������� ������������ �������� ����� ��������������
 * <p>
 * ������ ��� 194, ��� � 1,2, 8,9
 */
