package case_study.services.facility;

import case_study.services.interface_service.Service;

public interface FacilityService extends Service {
    void displayAddNewService();
    void displayAddNewVilla();
    void addAvailableVilla();
    void addNewVilla();
    void displayAddNewHouse();
    void addNewHouse();
    void addAvailableHouse();
    void displayAddNewRoom();
    void addNewRoom();
    void addAvailableRoom();
    void displayMaintenanceList();
}
