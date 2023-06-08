package id.amartek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Region;
import id.amartek.app.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService<Region> {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> Get() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> Get(Integer id) {
        return regionRepository.findById(id);
    }

    @Override
    public Boolean Save(Region model) {
        regionRepository.save(model);
        return regionRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        regionRepository.deleteById(id);
        return !regionRepository.findById(id).isPresent();
    }

}
