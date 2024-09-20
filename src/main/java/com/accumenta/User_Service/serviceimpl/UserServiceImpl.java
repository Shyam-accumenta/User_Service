package com.accumenta.User_Service.serviceimpl;

import com.accumenta.User_Service.exception.UserAlredyExistException;
import com.accumenta.User_Service.exception.UserNotFoundException;
import com.accumenta.User_Service.model.User;
import com.accumenta.User_Service.repository.UserRepository;
import com.accumenta.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        User dbUser = this.userRepository.findById(user.getUserId()).orElse(null);
        if (dbUser == null) {
            return this.userRepository.save(user);
        } else {
            throw new UserAlredyExistException(" user alredy exist");
        }
    }

    @Override
    public User getUser(long userId) {
        User dbUser = this.userRepository.findById(userId).get();
        if (dbUser != null) {
            return this.userRepository.findById(userId).get();
        } else {
            throw new UserAlredyExistException(" user alredy exist");
        }
    }

    @Override
    public User updateUser(User user, long userId) {
        User dbUser = this.userRepository.findById(userId).get();
        if (dbUser==null) {
            dbUser.setUserId(userId);
            dbUser.setUserName(user.getUserName());
            dbUser.setUserEmail(user.getUserEmail());
            dbUser.setUserNumber(user.getUserNumber());
            return this.userRepository.save(dbUser);
        } else {
            throw new UserAlredyExistException(" user already exist");
        }
    }


    @Override
    public boolean deleteUser(long userId) {
        Optional<User> dbUser = this.userRepository.findById(userId);
        if (dbUser.isPresent()) {
            this.userRepository.delete(dbUser.get());
            return true;
        } else {
            throw new UserAlredyExistException(" user already exist");
        }
    }

    @Override
    public User getUserByMobileNumber(long userMobileNumber) {
        User dbUser = this.userRepository.findByUserNumber(userMobileNumber);
        if (dbUser == null) {
            throw new UserNotFoundException(" user Not Found Exception");
        }
        return dbUser;
    }
}
