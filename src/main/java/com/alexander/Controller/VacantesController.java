package com.alexander.Controller;

import com.alexander.model.Vacante;
import com.alexander.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {


    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/create")
    public String crear(){
        return "vacantes/formVacante";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con id: "+ idVacante);
        model.addAttribute("id", idVacante);


        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int  idVacante, Model model){

        Vacante vacante = serviceVacantes.buscarPorId(idVacante);

        System.out.println("idVacante: "+ idVacante);
        model.addAttribute("vacante", vacante);

        //buscar los detalles de la vacante en la base de datos



        return "detalle";
    }
}
