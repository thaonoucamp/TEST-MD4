package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.ICityService;
import com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    ICityService ICityService;

    @Autowired
    ICountryService ICountryService;

    @ModelAttribute
    public List<Country> getAllCountry() {
        return (List<Country>) ICountryService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list", ICityService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("obj", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("obj") City obj) {
        ICityService.save(obj);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("obj", new City());
        modelAndView.addObject("message", "Create new obj Object successfully!");

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("obj", ICityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView coachEditPlayer(@ModelAttribute("obj") City obj) {
        City city = ICityService.findById(obj.getId()).get();
        city.setId(obj.getId());
        city.setName(obj.getName());
        city.setCountry(obj.getCountry());
        city.setArea(obj.getArea());
        city.setPopulation(obj.getPopulation());
        city.setGdp(obj.getGdp());
        city.setDescription(obj.getDescription());

        ICityService.save(city);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("obj", ICityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("obj") City obj) {
        City city = ICityService.findById(obj.getId()).get();
        ICityService.delete(city.getId());
        return new ModelAndView("redirect:/home");
    }
}
