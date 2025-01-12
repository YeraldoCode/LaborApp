package com.alexander.service;

import com.alexander.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


@Service
public class VacanteServiceImpl implements IVacanteService{

    private List<Vacante> lista = null;

    public VacanteServiceImpl(){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
             lista = new LinkedList<Vacante>();
            try {
                //creacion de la primera oferta de trabajo
                Vacante vacante1 = new Vacante();
                vacante1.setId(1);
                vacante1.setNombre("Ingeniero Civil");
                vacante1.setDescripcion("Diseñar un puente peatonal");
                vacante1.setFecha(sdf.parse("09-11-2024"));
                vacante1.setSalario(23000.00);
                vacante1.setDestacado(1);
                vacante1.setImagen("empresa1.png");


                //creamos segunda oferta
                Vacante vacante2 = new Vacante();
                vacante2.setId(2);
                vacante2.setNombre("Ingeniero de sistemas ");
                vacante2.setDescripcion("Diseñar un programa");
                vacante2.setFecha(sdf.parse("19-11-2024"));
                vacante2.setSalario(25000.00);
                vacante2.setDestacado(0);
                vacante2.setImagen("empresa2.png");

                //creamos la tercera oferta de trabajo
                Vacante vacante3 = new Vacante();
                vacante3.setId(3);
                vacante3.setNombre("Contador Publico");
                vacante3.setDescripcion("se solicita contador con 5 años de experiencia");
                vacante3.setFecha(sdf.parse("09-10-2024"));
                vacante3.setSalario(12000.00);
                vacante3.setDestacado(0);
                vacante3.setImagen("empresa3.png");

                //creamos la cuarta oferta de trabajo
                Vacante vacante4 = new Vacante();
                vacante4.setId(4);
                vacante4.setNombre("Ingeniero electrico");
                vacante4.setDescripcion("Mantenimiento en instalacion electrica");
                vacante4.setFecha(sdf.parse("09-11-2024"));
                vacante4.setSalario(20000.00);
                vacante4.setDestacado(1);
                vacante4.setImagen("empresa4.png");


                //agregar vacante a la lista
                lista.add(vacante1);
                lista.add(vacante2);
                lista.add(vacante3);
                lista.add(vacante4);
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());

            }
    }

    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {

        for(Vacante v : lista) {
            if (v.getId()==idVacante){
                return v;
            }
        }
        return null;
    }
}
