package com.yaron.server.dao;

import org.springframework.stereotype.Repository;

import com.yaron.model.User;


@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Long> implements UserDao {
}
