package com.brasilsoldado;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.view.ViewStart;
import com.brasilsoldado.view.person.ViewPersonCreate;
import com.brasilsoldado.view.qualification.ViewQualification;
import com.brasilsoldado.view.state.ViewState;

public class Main {

    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            new ViewQualification().setVisible(true);
//            new ViewStart().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
