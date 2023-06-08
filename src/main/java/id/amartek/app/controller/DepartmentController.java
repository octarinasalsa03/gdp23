package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Department;
import id.amartek.app.model.Division;
import id.amartek.app.model.Region;
import id.amartek.app.service.DepartmentService;
import id.amartek.app.service.DivisionService;
import id.amartek.app.service.RegionService;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService<Department> departmentService;
    @Autowired
    private RegionService<Region> regionService;
    @Autowired
    private DivisionService<Division> divisionService;

    @GetMapping
    public String index(Model model) {
        // List<Department> departments = departmentService.Get();
        model.addAttribute("departments", departmentService.Get());
        return "department/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("department", departmentService.Get(id));
            model.addAttribute("regions", regionService.Get());
            model.addAttribute("divisions", divisionService.Get());
        } else {
            model.addAttribute("department", new Department());
            model.addAttribute("regions", regionService.Get());
            model.addAttribute("divisions", divisionService.Get());
        }
        return "department/form";
    }

    @PostMapping("save")
    public String save(Department department) {
        Boolean result = departmentService.Save(department);
        if (result) {
            return "redirect:/department";
        }
        return "department/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            departmentService.Delete(id);
        } else {
            return "redirect:/department";
        }
        return "department/index";
    }

}
