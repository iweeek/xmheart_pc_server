package com.xmheart.timer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;
import com.xmheart.service.NewspaperService;
import com.xmheart.service.VideoService;

@Component
public class UpdateTask {
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private NewspaperService newspaperService;
    
    @Autowired
    private ColumnService columnService;
    
    private final static long NEWSPAPER_COLUMN_ID = 23;  
    
//    @Scheduled(cron = "0 0 1 * * ?")
    @RequestMapping(value = { "/nijun" }, method = RequestMethod.POST)
    public List<XPWNav> job()   {  
        List<XPWElecNewspaper> lastestNewspaper = newspaperService.indexLastest();
        if (lastestNewspaper.size() > 4) {
            lastestNewspaper = lastestNewspaper.subList(0, 4);
        }
        
        List<XPWNav> newspaperNavs = columnService.getNavsByColumnId(NEWSPAPER_COLUMN_ID);
        
        for (int i = 0; i < lastestNewspaper.size(); i++) {
            XPWNav xpwNav = newspaperNavs.get(i);
            xpwNav.setArticleTitle(lastestNewspaper.get(i).getTitle());
            xpwNav.setUrl(lastestNewspaper.get(i).getUrl());
            xpwNav.setImgUrl(lastestNewspaper.get(i).getImageUrl());
            xpwNav.setPublishTime(lastestNewspaper.get(i).getPublishTime());
            columnService.updateNav(xpwNav);
        }
        return newspaperNavs;
    }
}
