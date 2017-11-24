package by.htp.speq.logic.rentunit;

import by.htp.speq.entity.RentUnit;

import java.util.ArrayList;

public interface IRentUnitLogic {

    ArrayList<RentUnit> readRentUnits();

    void addRentUnit(RentUnit rentUnit);

    RentUnit deleteRentUnit(String title);

}
