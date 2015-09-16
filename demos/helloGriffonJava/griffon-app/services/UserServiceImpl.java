import com.tz.User;

import java.util.List;

/**
 * Created by hjl on 2015/9/15.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add(User user) {
        UserData.getData().add(user);
    }

    @Override
    public void update(User user) {
        for(User temp : UserData.getData()){
            if(user.getId() == temp.getId()){
                UserData.getData().remove(temp);
                UserData.getData().add(user);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for(User user : UserData.getData()){
            if(id == user.getId()){
                UserData.getData().remove(user);
                break;
            }
        }
    }

    @Override
    public User getById(int id) {
        for(User user : UserData.getData()){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return UserData.getData();
    }
}
