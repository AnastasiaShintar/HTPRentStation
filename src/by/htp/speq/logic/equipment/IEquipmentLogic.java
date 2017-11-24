package by.htp.speq.logic.equipment;

import by.htp.speq.entity.Equipment;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IEquipmentLogic {

    ArrayList<Equipment> readCatalog() throws FileNotFoundException;

    Equipment deleteEquipment(String title);

    void addEquipment(Equipment equipment);


}
