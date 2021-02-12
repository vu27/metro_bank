package util;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserMapper {

    // Util method to map users from MySQL database to User model class
    public static List<User> mapUsersFromMySQL(List<Map<String, Object>> resultList) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < resultList.size(); i++) {
            users.add(new User(Integer.parseInt(resultList.get(i).get("user_id").toString()), resultList.get(i).get("user_fname").toString(), resultList.get(i).get("user_lname").toString(), resultList.get(i).get("user_phone").toString(), resultList.get(i).get("user_role").toString(), resultList.get(i).get("user_email").toString(), "NA"));
        }

        return users;
    }
}
