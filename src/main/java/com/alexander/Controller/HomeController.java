package com.alexander.Controller;

import com.alexander.model.Vacante;
import com.alexander.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/tabla")
    public String mostarTabla(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.00);
        model.addAttribute("vacante", vacante);
        return "detalle";

    }
    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de sistemas");
        lista.add("Auxiliar Administrativo");
        lista.add("Arquitecto de planos");

        model.addAttribute("empleos", lista);

        return "listado";

    }
    @GetMapping("/")
    public String mostrarHome(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);


        return "home";
    }

}




