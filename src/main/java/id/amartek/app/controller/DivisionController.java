package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Division;
import id.amartek.app.service.DivisionService;

@Controller
@RequestMapping("division")
public class DivisionController {
    @Autowired
    private DivisionService<Division> divisionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("divisions", divisionService.Get());
        return "division/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("division", divisionService.Get(id));
        } else {
            model.addAttribute("division", new Division());
        }
        return "division/form";
    }

    @PostMapping("save")
    public String save(Division division) {
        Boolean result = divisionService.Save(division);
        if (result) {
            return "redirect:/division";
        }
        return "division/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            divisionService.Delete(id);
        } else {
            return "redirect:/division";
        }
        return "division/index";
    }

}
