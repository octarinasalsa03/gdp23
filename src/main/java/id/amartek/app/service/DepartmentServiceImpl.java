package id.amartek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Department;
import id.amartek.app.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService<Department> {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> Get() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> Get(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Boolean Save(Department model) {
        Integer saveId = departmentRepository.save(model).getId();
        // departmentRepository.save(model);
        return departmentRepository.findById(saveId).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        departmentRepository.deleteById(id);
        return !departmentRepository.findById(id).isPresent();
    }

}
