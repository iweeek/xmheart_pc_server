package com.xmheart.util;

import java.text.Collator;
import java.util.Comparator;

import com.xmheart.model.HisDoctor;

public class HisDoctorComparator implements Comparator<HisDoctor> {

    Collator cmp = Collator.getInstance(java.util.Locale.CHINA);  
    
    @Override
    public int compare(HisDoctor o1, HisDoctor o2) {
        int num = cmp.compare(o1.getName(), o2.getName());
        if (num == 0) {
            num = new Integer(o1.getWorkType()).compareTo(new Integer(o2.getWorkType()));
        }
        return num;
    }

}
