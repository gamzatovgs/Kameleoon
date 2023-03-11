package com.kameleoon.trial_task.service.user;

import com.kameleoon.trial_task.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);
}
