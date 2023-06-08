package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.model.Department;
import id.amartek.app.model.Division;
import id.amartek.app.model.Region;
import id.amartek.app.service.DepartmentService;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentService<Department> departmentService;

    // DELETE
    @Test
    void deleteDepartment() {
        // arrange
        Integer id = 36;

        Boolean expected = true, actual;

        actual = departmentService.Delete(id);

        assertEquals(expected, actual);
    }

    // INSERT AND UPDATE
    @Test
    void saveDepartment() {
        Region region = new Region(1, "WIB");
        Division division = new Division(1, "Human Capital Management");
        Department department = new Department(39, "Coba", region, division);

        Boolean expected = true, actual;

        actual = departmentService.Save(department);

        assertEquals(expected, actual);
    }

}
