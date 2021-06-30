package case_study.services.facility;

import case_study.services.interface_service.Service;

public interface FacilityService extends Service {
    void displayAddNewService();
    void addNewVilla();
    void addNewHouse();
    void addNewRoom();
    void displayMaintenanceList();
}
