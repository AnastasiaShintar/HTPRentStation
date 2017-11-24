package by.htp.speq.command.impl;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.logic.equipment.EquipmentLogicFileImpl;
import by.htp.speq.logic.equipment.IEquipmentLogic;

import java.io.IOException;
import java.util.ArrayList;

public class ViewCatalogActionImpl implements StationAction {

    private IEquipmentLogic logic;

    {
//		logic=new EquipmentLogicConsoleImpl();

        logic = new EquipmentLogicFileImpl();

//		logic=new DataBaseStationLogicImpl();
    }

    @Override
    public void performAction() throws IOException {

        ArrayList<Equipment> catalog = logic.readCatalog();
        if (catalog.isEmpty()) {
            System.out.println("Весь инвентарь арендован!");
        }

        for (Equipment eq : catalog) {
            if (eq != null) {
                System.out.println(eq);
            }
        }

    }

}
