package artur.goz.Comparators;

import generated.Gun;

import java.util.Comparator;

import java.util.Comparator;

public class GunComparator implements Comparator<Gun> {
    @Override
    public int compare(Gun o1, Gun o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}

