package com.brasilsoldado;

import com.brasilsoldado.controller.CityController;
import com.brasilsoldado.controller.LoginController;
import com.brasilsoldado.controller.PersonController;
import com.brasilsoldado.controller.StateController;
import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.model.City;
import com.brasilsoldado.model.Person;
import com.brasilsoldado.model.State;
import java.sql.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            System.out.println("abriu");
//            new FrmJanelaPrincipal().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
