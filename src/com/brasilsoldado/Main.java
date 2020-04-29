package com.brasilsoldado;

import com.brasilsoldado.controller.CityController;
import com.brasilsoldado.controller.PersonController;
import com.brasilsoldado.controller.StateController;
import com.brasilsoldado.view.ViewQualificationCreate;
import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.model.City;
import com.brasilsoldado.model.Person;
import com.brasilsoldado.model.State;
import com.brasilsoldado.view.ViewPersonCreate;
import com.brasilsoldado.view.ViewStart;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //controllers
        PersonController personController = new PersonController();
        StateController stateController = new StateController();
        CityController cityController = new CityController();

        // personMockup
        Person personMockup = new Person();
        personMockup.setName("João Pedro");
        personMockup.setSurname("Basso Audibert");
        personMockup.setBirthday(new Date());
        personMockup.setCpf("63696938041");
        personMockup.setEmail("gabriel@gmail.com");
        personMockup.setPassword("senhasuperSecreta123");
        personMockup.setType(1);
        personMockup.setEnabled(true);
        personMockup.setMomsName("Adriana Audibert");
        personMockup.setDadsName("Edson Audibert");
        personMockup.setFkCityId(1);
        
        Person personMockupEdit = new Person();
        personMockupEdit.setName("Juca");
        personMockupEdit.setSurname("Bala");
        personMockupEdit.setBirthday(new Date());
        personMockupEdit.setCpf("63696938041");
        personMockupEdit.setEmail("juca@gmail.com");
        personMockupEdit.setPassword("senhacripto");
        personMockupEdit.setType(1);
        personMockupEdit.setEnabled(true);
        personMockupEdit.setMomsName("maria silva");
        personMockupEdit.setDadsName("felipe dos santos");
        personMockupEdit.setFkCityId(1);

        // stateMockup
        State stateMockup = new State();
        stateMockup.setName("Rio Grande do Sul");
        stateMockup.setInitials("RS");
        
        State stateMockup2 = new State();
        stateMockup2.setName("Sao Paulo");
        stateMockup2.setInitials("SP");
        
        State stateMockupEdit = new State();
        stateMockupEdit.setName("Ceara");
        stateMockupEdit.setInitials("CE");

        // cityMockup
        City cityMockup = new City();
        cityMockup.setName("Carlos Barbosa");
        cityMockup.setInitials("CBA");
        cityMockup.setFkStateId(1);
        
        City cityMockup2 = new City();
        cityMockup2.setName("Campinas");
        cityMockup2.setInitials("CMP");
        cityMockup2.setFkStateId(11);
        
        City cityMockupEdit = new City();
        cityMockupEdit.setName("Lajeado");
        cityMockupEdit.setInitials("LJD");
        cityMockupEdit.setFkStateId(6);

        if (DBConnection.getInstance() != null) {
//            new ViewStart().setVisible(true);

// personcontroller
//            personController.store(personMockupEdit);
//            personController.update(personMockupEdit, 8);
//            personController.delete(8);
//            for (Person index : personController.index()) { // show || index
//                System.out.println("Id: " + index.getIdPerson());
//                System.out.println("Nome: " + index.getName() + " " + index.getSurname());
//                System.out.println("CPF: " + index.getCpf());
//                System.out.println("Email: " + index.getEmail());
//                System.out.println("Senha: " + index.getPassword());
//                System.out.println("");
//            }

// statecontroller
//            stateController.store(stateMockupEdit);
//            stateController.update(stateMockupEdit, 12);
//            stateController.delete(12);
//            for (City index : cityController.show(6)) { // show || index
//                System.out.println("Id: " + index.getIdCity());
//                System.out.println("Nome: " + index.getName());
//                System.out.println("Sigla: " + index.getInitials());
//                System.out.println("");
//            }

// citycontroller
//            cityController.store(cityMockup2);
//            cityController.update(cityMockup2, 1);
            cityController.delete(5);
            for (City index : cityController.show(2)) { // show || index
                System.out.println("Id: " + index.getIdCity());
                System.out.println("Nome: " + index.getName());
                System.out.println("Sigla: " + index.getInitials());
                System.out.println("");
            }
            

        } else {
            System.out.println("deu problema");
        }
    }
}
