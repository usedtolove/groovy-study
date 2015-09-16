import com.tz.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjl on 2015/9/15.
 */
public class UserData {

    private static List<User> instance = init();

    private static List<User> init() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("test user"+i);
            user.setAge(20 + i);
            userList.add(user);
        }
        return userList;
    }

    public static List<User> getData(){
        return instance;
    }

}
