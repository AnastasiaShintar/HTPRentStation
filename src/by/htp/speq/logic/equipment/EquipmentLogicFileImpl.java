package by.htp.speq.logic.equipment;

import by.htp.speq.Util;
import by.htp.speq.entity.Equipment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class EquipmentLogicFileImpl implements IEquipmentLogic {

    @Override
    public ArrayList<Equipment> readCatalog() {
        ArrayList<Equipment> catalog = new ArrayList<>();
        ArrayList<String> lines = Util.readData(Util.FILE_PATH);

        for (String line : lines) {
            Equipment eq = Util.createEquipment(Util.getSplitValues(line), 0);
            catalog.add(eq);
        }
        return catalog;
    }

    @Override
    public Equipment deleteEquipment(String title) {
        ArrayList<String> lines = Util.readData(Util.FILE_PATH);
        if (lines.isEmpty()) {
            System.out.println("Весь инвентарь в аренде!");
            return null;
        }
        Equipment eq = null;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Util.FILE_PATH))) {
            for (String line : lines) {
                if (Util.getSplitValues(line)[0].equals(title)) {
                    eq = Util.createEquipment(Util.getSplitValues(line), 0);
                } else {
                    bw.write(line);
                    bw.write("\n");
                }
            }
            if (eq == null) {
                System.out.println("Не найдено оборудование с таким названием!");
            }
        } catch (Exception e) {
        }
        return eq;
    }

    @Override
    public void addEquipment(Equipment equipment) {
        StringBuilder sb = new StringBuilder()
                .append(equipment.getTitle())
                .append(", ")
                .append(equipment.getHourRate());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Util.FILE_PATH, true))) {
            bw.write(sb.toString());
            bw.write("\n");
        } catch (Exception e) {
        }
    }

}
