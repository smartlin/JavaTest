package cn.lxh.java.Framework;

import java.util.HashMap;

/**
 * Created by starlin
 * on 2019/7/4 16:57.
 */

class User {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public User(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof User)) {
            return false;
        } else {
            return this.getId().equals(((User) o).getId());
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

public class HashMapDemoWithHashCode {
    public static void main(String[] args) {
        User user1 = new User(1);
        User user2 = new User(1);
        HashMap<User, String> map = new HashMap<User,String>();
        map.put(user1, "1");
        System.out.println(map.get(user2));
    }
}
