package service;

import model.User;

public interface IUserService {

    User findUserByUserName(String name);

    void createUser(User user);
   void updateUser(long id, User user);
   User findUserById(long id);
   void updatePassword(long id, User user);
}
