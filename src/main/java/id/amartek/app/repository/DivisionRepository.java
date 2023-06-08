package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.model.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {

}
