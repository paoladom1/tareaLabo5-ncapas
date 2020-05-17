package com.uca.capas.controller;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private EstudianteDAO estudianteDAO;

    @RequestMapping("/inicio")
    public ModelAndView initMain() {
        Estudiante estudiante = new Estudiante();

        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", estudiante);
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/formulario")
    public ModelAndView insert(@ModelAttribute Estudiante estudiante, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if(br.hasErrors()) {
            mav.setViewName("index");
        } else {
            estudianteDAO.insert(estudiante);

            mav.addObject("estudiante", new Estudiante());
            mav.setViewName("index");
        }

        return mav;
    }

    @RequestMapping("/listado")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }


}
