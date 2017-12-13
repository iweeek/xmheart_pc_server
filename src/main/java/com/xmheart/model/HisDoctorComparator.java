package com.xmheart.model;

import java.text.Collator;
import java.util.Comparator;

public class HisDoctorComparator implements Comparator<HisDoctor> {

    Collator cmp = Collator.getInstance(java.util.Locale.CHINA);  
    
    @Override
    public int compare(HisDoctor o1, HisDoctor o2) {
        return cmp.compare(o1.getName(), o2.getName());  
    }

}
