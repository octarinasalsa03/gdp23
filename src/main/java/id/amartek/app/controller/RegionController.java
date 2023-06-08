package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Region;
import id.amartek.app.service.RegionService;

@Controller
@RequestMapping("region")
public class RegionController {
    @Autowired
    private RegionService<Region> regionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("regions", regionService.Get());
        return "region/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("region", regionService.Get(id));
        } else {
            model.addAttribute("region", new Region());
        }
        return "region/form";
    }

    @PostMapping("save")
    public String save(Region region) {
        Boolean result = regionService.Save(region);
        if (result) {
            return "redirect:/region";
        }
        return "region/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            regionService.Delete(id);
        } else {
            return "redirect:/region";
        }
        return "region/index";
    }

}
