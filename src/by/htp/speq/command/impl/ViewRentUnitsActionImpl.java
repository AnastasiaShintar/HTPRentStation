package by.htp.speq.command.impl;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.rentunit.RentLogicFileImpl;
import by.htp.speq.logic.rentunit.IRentUnitLogic;

import java.io.IOException;
import java.util.ArrayList;

public class ViewRentUnitsActionImpl implements StationAction {

    private IRentUnitLogic logic;

    {
        logic = new RentLogicFileImpl();
    }

    @Override
    public void performAction() throws IOException {
        ArrayList<RentUnit> rentUnits = logic.readRentUnits();

        if (rentUnits.isEmpty()) {
            System.out.println("Весь инвентарь на базе!");
        }

        for (RentUnit rentUnit : rentUnits) {
            if (rentUnit != null) {
                System.out.println(rentUnit);
            }
        }
    }
}
