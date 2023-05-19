package org.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
          BootcampersList bootcampersList = new BootcampersList(4);
          List<String> certificates1 = new ArrayList<>();
          certificates1.add("c1");
          certificates1.add("c2");
          bootcampersList.addParticipants(new Bootcamper("cris","cris",ProgrammingLanguage.JAVA,certificates1,"cris@cris.com","0766666666"));
          bootcampersList.addParticipants(new Bootcamper("radu","radu",ProgrammingLanguage.JAVA,certificates1,"radu@cris.com","0766636666"));
          bootcampersList.addParticipants(new Bootcamper("andrei","andrei",ProgrammingLanguage.C,certificates1,"a@cris.com","0766666656"));
          bootcampersList.addParticipants(new Bootcamper("anara","ana",ProgrammingLanguage.PYTHON,certificates1,"ana@cris.com","0766666566"));
          bootcampersList.addParticipants(new Bootcamper("nimeni","nimeni",ProgrammingLanguage.PYTHON,certificates1,"nimeni@cris.com","0766661566"));
          Scanner scanner = new Scanner(System.in);
          Menu menu = new Menu();
          menu.menuFunctions(scanner,bootcampersList);
    }

}
