package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewStart;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            System.out.println("abriu");
            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
