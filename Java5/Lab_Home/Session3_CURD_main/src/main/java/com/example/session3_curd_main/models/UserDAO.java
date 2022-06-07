package com.example.session3_curd_main.models;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static List<User> list = new ArrayList<>();

    public User findByUsername(String username) {
        for (User user : list
        ) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public int update(User user) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(user.getUsername())) {
                list.set(i, user);
                return i;
            }
        }
        return -1;
    }

    public int save(User user) {
        if (findByUsername(user.getUsername()) != null) {
            update(user);
        } else {
            list.add(user);
        }
        return 1;
    }

    public int delete(String username) {
        User u = findByUsername(username);
        if (u != null) {
            list.remove(u);
            return 1;
        }
        return 0;
    }

    public List<User> getALl(){
        return list;
    }
}
