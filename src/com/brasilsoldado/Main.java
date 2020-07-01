package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewDashboard;
import com.brasilsoldado.view.ViewInspection;
import com.brasilsoldado.view.ViewListInspection;
import com.brasilsoldado.view.ViewStart;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewDashboard("jucabala@email.com").setVisible(true);
//            new ViewDashboard("gerson@quartel.com").setVisible(true);
//            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
