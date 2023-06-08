package id.amartek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Role;
import id.amartek.app.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService<Role> {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> Get() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> Get(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Boolean Save(Role model) {
        roleRepository.save(model);
        return roleRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        roleRepository.deleteById(id);
        return !roleRepository.findById(id).isPresent();
    }

}
