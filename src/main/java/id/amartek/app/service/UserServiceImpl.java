package id.amartek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.User;
import id.amartek.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> Get() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> Get(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean Save(User model) {
        userRepository.save(model);
        return userRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        userRepository.deleteById(id);
        return !userRepository.findById(id).isPresent();
    }

}
