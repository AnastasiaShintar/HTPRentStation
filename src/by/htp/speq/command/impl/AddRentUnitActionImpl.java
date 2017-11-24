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
import java.util.Date;


public class AddRentUnitActionImpl implements StationAction {


    private IRentUnitLogic logic = new RentLogicFileImpl();
    private IEquipmentLogic logicDel = new EquipmentLogicFileImpl();


    @Override
    public void performAction() throws IOException {

        System.out.println("Введите имя пользователя: ");
        String userName = ConsoleMenu.readUserInput();

        System.out.println("Введите название equipment для аренды: ");
        String eqTitle = ConsoleMenu.readUserInput();

        Equipment eq = logicDel.deleteEquipment(eqTitle);
        if (eq != null) {
            RentUnit rentUnit = new RentUnit(eq, new Date(), userName);
            logic.addRentUnit(rentUnit);
            System.out.println("Арендовано оборудование: " + rentUnit);
        }

    }

}
