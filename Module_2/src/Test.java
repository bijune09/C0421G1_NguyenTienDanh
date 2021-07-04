import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.utils.read_and_write_file.ReadAndWriteFile;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test extends ReadAndWriteFile {
    public static void main(String[] args) {
        String filepath = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\room.csv";
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Villa villa = new Villa("Ocean Villa", 150, 10000000, 10, "Day", "CE", 20, 2);
        House house = new House("Oat House", 100, 7000000, 8, "Week", "TCVN", 3);
        Room room = new Room("Jasmine Room", 50, 250000, 2, "Hours", "Netflix and snacks");
        facilityIntegerMap.put(villa, 0);
        facilityIntegerMap.put(house, 0);
        facilityIntegerMap.put(room, 0);
        String line = house.getName()+","+house.getArea()+","+house.getPrice()+","+house.getCapacity()+","+house.getGuestStay()+","+house.getStandard()
                +","+house.getFloor()+","+0;
        new ReadAndWriteFile<>().readFileWithMap(filepath);
        Map<Facility,Integer> map = new LinkedHashMap<>();
        map = new ReadAndWriteFile<>().readFileWithMap(filepath);
        System.out.println(map);
    }
}
