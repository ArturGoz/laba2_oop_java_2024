package artur.goz.testGun;

import generated.Gun;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GunSortTest {
    @Test
    public void sortTest(){
        Gun gun1 = new Gun();
        gun1.setModel("AK-47");
        Gun gun2 = new Gun();
        gun2.setModel("M16");
        Gun gun3 = new Gun();
        gun3.setModel("Glock");

        List<Gun> gunList = Arrays.asList(gun1,gun2,gun3);
        Collections.sort(gunList, (o1, o2) -> 0);
        assertEquals(Arrays.asList(gun1,gun3,gun2),gunList);
    }
}