package com.brasilsoldado;

import com.brasilsoldado.controller.StateController;
import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.model.State;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            System.out.println("abriu");
            State state = new State(0, null, null);
            state.setInitials("SP");
            state.setName("São Paulo");
            
            StateController controller = new StateController();
//            controller.update(state, 10);
//            controller.store(state);
            ArrayList<State> states =  controller.show(10);
            for (State state1 : states) {
                System.out.println(state1.getName());
                System.out.println(state1.getInitials());
            }
            
            if (controller.delete(10)) {
                System.out.println("Valeu!");   
            }else{
                System.out.println("Moios");
            }
//            new FrmJanelaPrincipal().setVisible(true);
        } else {
            System.out.println("deu problema");
        }
    }
}
