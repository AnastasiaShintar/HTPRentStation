package by.htp.speq.logic.equipment;

import by.htp.speq.entity.Equipment;
import by.htp.speq.logic.equipment.IEquipmentLogic;

import java.util.ArrayList;

public class EquipmentLogicConsoleImpl implements IEquipmentLogic {

    @Override
    public ArrayList<Equipment> readCatalog() {

        Equipment eq1 = new Equipment("Eq1",2.5);
        Equipment eq2 = new Equipment("Eq2", 2.5);
        Equipment eq3 = new Equipment("Eq3", 2.5);

        ArrayList<Equipment> catalog = new ArrayList<>();
        catalog.add(eq1);
        catalog.add(eq2);
        catalog.add(eq3);

        return catalog;

    }

    @Override
    public Equipment deleteEquipment(String title) {
        return null;
    }

    @Override
    public void addEquipment(Equipment equipment) {

    }
}
