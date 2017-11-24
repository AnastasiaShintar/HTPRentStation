package by.htp.speq.command;

import by.htp.speq.command.impl.*;

public class ActionHelper {

    public static StationAction defineAction(int input) {

        StationAction action = new DefaultActionImpl();

        switch (input) {
            case 1:
                action = new ViewCatalogActionImpl();
                break;
            case 2:
                action = new ViewRentUnitsActionImpl();
                break;
            case 3:
                action = new AddRentUnitActionImpl();
                break;
            case 4:
                action = new ReturnEquipmentAction();
                break;
            case 0:
                System.out.println("Exit");
                break;
            default:
                break;
        }

        return action;

    }

}
