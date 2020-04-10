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
            Person person = new Person(0, null, null, null, null, null, null, 0, false, null, null, 0);
            person.setName("Gabriel Antônio");
            person.setSurname("Basso Audibert");
            person.setBirthday(new Date(2001 - 05 - 16));
            person.setCpf("53408012091");
            person.setEmail("guigui@gmail.com");
            person.setPassword("senha");
            person.setType(1);
            person.setEnabled(true);
            person.setMomsName("Adriana Basso Audibert");
            person.setDadsName("Edson Audibert");
            person.setFkCityId(2);

            LoginController controller = new LoginController();
//            controller.update(state, 10);
            controller.authenticate("guigui@gmail.com", "senha");
//            ArrayList<Person> people = controller.show(5);
//            for (Person person1 : people) {
//                System.out.println(person.getIdPerson());
//                System.out.println(person.getName());
//                System.out.println(person.getSurname());
//                System.out.println(person.getBirthday());
//                System.out.println(person.getCpf());
//                System.out.println(person.getEmail());
//                System.out.println(person.getPassword());
//                System.out.println(person.getType());
//                System.out.println(person.isEnabled());
//                System.out.println(person.getMomsName());
//                System.out.println(person.getDadsName());
//                System.out.println(person.getFkCityId());
//            }

//            if (controller.authenticate("guigui@gmail.com", "senha")) {
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
