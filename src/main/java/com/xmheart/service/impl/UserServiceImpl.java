package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWUserMapper;
import com.xmheart.model.XPWUser;
import com.xmheart.service.UserService;
import com.xmheart.util.ResponseBody;


/**
* TokenService 实现类.
* 
* @author x1ny
* @date 2017年5月22日
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    XPWUserMapper userMapper;
    @Override
    public List<XPWUser> search(XPWUser user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(XPWUser user, ResponseBody resBody) {
        userMapper.updateByPrimaryKey(user);
        return 0;
    }

    @Override
    public XPWUser read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAvatarUrl(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }
	
}
