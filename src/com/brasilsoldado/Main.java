package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewStart;
import com.brasilsoldado.view.person.ViewPersonCreate;
import com.brasilsoldado.view.ViewQualification;
import com.brasilsoldado.view.ViewState;
import com.brasilsoldado.view.ViewWarning;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewWarning().setVisible(true);
//            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
