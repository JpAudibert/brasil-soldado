package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewInspection;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewInspection("jucabala@email.com").setVisible(true);
//            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
