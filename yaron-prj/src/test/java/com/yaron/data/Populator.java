package com.yaron.data;

import com.yaron.model.User;
import com.yaron.server.dao.UserDao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;

/**
 * User: Gad Mehditache
 * Date: 17/05/11
 * Time: 11:41
 */

@Component
@Transactional
public class Populator {

    @Resource
    UserDao userDao;

    @PostConstruct
    public void populate() {

        HashSet<User> users = new HashSet<User>();

        users.add( new User("Gad"));
        users.add( new User("Yinon"));
        users.add( new User("Yaakov"));
        users.add( new User("Semion"));

        for (User user : users) {
            userDao.create(user);
        }

    }

}
