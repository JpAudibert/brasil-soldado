package com.brasilsoldado;

import com.brasilsoldado.controller.CityController;
import com.brasilsoldado.controller.StateController;
import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.model.City;
import com.brasilsoldado.model.State;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            System.out.println("abriu");
            City city = new City(0, null, null, 0);
            city.setInitials("GDI");
            city.setName("Garibaldi");
            city.setFkStateId(6);

            CityController controller = new CityController();
//            controller.update(state, 10);
//            controller.store(city);
            ArrayList<City> cities = controller.show(1);
            for (City city1 : cities) {
                System.out.println(city1.getIdCity());
                System.out.println(city1.getName());
                System.out.println(city1.getInitials());
                System.out.println(city1.getFkStateId());
            }

//            if (controller.delete(4)) {
//                System.out.println("Valeu!");
//            } else {
//                System.out.println("Moios");
//            }
//            new FrmJanelaPrincipal().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
