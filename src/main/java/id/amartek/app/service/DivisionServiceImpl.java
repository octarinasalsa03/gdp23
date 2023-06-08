package id.amartek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Division;
import id.amartek.app.repository.DivisionRepository;

@Service
public class DivisionServiceImpl implements DivisionService<Division> {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> Get() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> Get(Integer id) {
        return divisionRepository.findById(id);
    }

    @Override
    public Boolean Save(Division model) {
        divisionRepository.save(model);
        return divisionRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        divisionRepository.deleteById(id);
        return !divisionRepository.findById(id).isPresent();
    }

}
