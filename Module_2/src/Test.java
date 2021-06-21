import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("A",1);
        map.put("B",2);
        System.out.println(map.get("B"));
    }
}
