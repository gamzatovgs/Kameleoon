package com.kameleoon.trial_task.dao.user;

import com.kameleoon.trial_task.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);
}
