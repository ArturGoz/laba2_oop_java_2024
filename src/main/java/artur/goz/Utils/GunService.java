package artur.goz.Utils;

import artur.goz.Comparators.GunComparator;
import generated.Gun;

import java.util.Collections;
import java.util.List;

public class GunService {
    public static List<Gun> sortGuns(List<Gun> guns) {
        guns.sort(new GunComparator());
        return guns;
    }
}
