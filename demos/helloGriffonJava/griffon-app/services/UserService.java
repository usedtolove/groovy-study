import com.tz.User;

import java.util.List;

/**
 * Created by hjl on 2015/9/15.
 */
public interface UserService {

    void add(User user);

    void update(User user);

    void delete(int id);

    User getById(int id);

    List<User> getAll();

}
