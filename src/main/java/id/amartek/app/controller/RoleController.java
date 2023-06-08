package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Role;
import id.amartek.app.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService<Role> roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.Get());
        return "role/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("role", roleService.Get(id));
        } else {
            model.addAttribute("role", new Role());
        }
        return "role/form";
    }

    @PostMapping("save")
    public String save(Role role) {
        Boolean result = roleService.Save(role);
        if (result) {
            return "redirect:/role";
        }
        return "role/form";
    }

    @PostMapping(value = { "delete/{id}" })
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            roleService.Delete(id);
        } else {
            return "redirect:/role";
        }
        return "role/index";
    }

}
