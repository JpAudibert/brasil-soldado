package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewDashboard;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewDashboard().setVisible(true);
//            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
