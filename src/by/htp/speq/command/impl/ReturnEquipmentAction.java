package by.htp.speq.command.impl;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.equipment.EquipmentLogicFileImpl;
import by.htp.speq.logic.equipment.IEquipmentLogic;
import by.htp.speq.logic.rentunit.RentLogicFileImpl;
import by.htp.speq.logic.rentunit.IRentUnitLogic;
import by.htp.speq.view.ConsoleMenu;

import java.io.IOException;

public class ReturnEquipmentAction implements StationAction {

    private IEquipmentLogic logicAdd = new EquipmentLogicFileImpl();
    private IRentUnitLogic logicDel = new RentLogicFileImpl();


    @Override
    public void performAction() throws IOException {
        System.out.println("Введите название equipment для возврата: ");
        String title = ConsoleMenu.readUserInput();

        RentUnit ru = logicDel.deleteRentUnit(title);
        if (ru != null) {
            Equipment eq = ru.getEquipment();
            logicAdd.addEquipment(eq);
            System.out.println("В прокат вернули " + eq);
        }
    }
}
