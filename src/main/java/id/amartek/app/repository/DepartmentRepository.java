package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
