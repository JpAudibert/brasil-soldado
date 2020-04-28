package com.brasilsoldado;

import com.brasilsoldado.view.ViewQualificationCreate;
import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewPersonCreate;
import com.brasilsoldado.view.ViewStart;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewQualificationCreate().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
