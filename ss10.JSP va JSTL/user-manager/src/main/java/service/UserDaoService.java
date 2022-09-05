package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserDaoService implements IUserDaoService {
    public IUserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user){
    }
//    public Map<String, String> insertUser(User user) {
//        Map<String,String> map = new HashMap<>();
//        if ("".equals(user.getName())){
//            map.put("name","khong duoc bo trong");
//        }
//        if ("".equals(user.getEmail())){
//            map.put("email","email khong duoc bo trong");
//        }
//        return map;
//    }

    @Override
    public User selectUser(int user) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
