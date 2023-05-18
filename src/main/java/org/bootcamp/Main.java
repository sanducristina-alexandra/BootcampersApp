package org.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String[] menuOptions = {
            "(1)help",
            "(2)add",
            "(3)check",
            "(4)remove",
            "(5)update",
            "(6)bootcampers",
            "(7)java",
            "(8)c",
            "(9)python",
            "(10)waitlist",
            "(11)available",
            "(12)bootcampers_number",
            "(13)waitlist_number",
            "(14)subscribe_number",
            "(15)search",
            "(16)quit"
    };
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
          int menuOption = 1;
          while(menuOption!=16){
              printMenu();
              menuOption = scanner.nextInt();
              switch (menuOption){
                  case 1: { printMenu();
                          break;}
                  case 2: {
                      System.out.println("Please enter the first name: ");
                      scanner.nextLine();
                      String firstName = scanner.nextLine();
                      System.out.println("Please enter the last name: ");
                      String lastName = scanner.nextLine();
                      System.out.println("Please enter the programming language. The choices are: JAVA, C or PYTHON.");
                      String language = scanner.nextLine();
                      ProgrammingLanguage programmingLanguage = ProgrammingLanguage.PYTHON;
                      if(language.equals("JAVA")) programmingLanguage = ProgrammingLanguage.JAVA;
                      else if (language.equals("C")) {
                          programmingLanguage = ProgrammingLanguage.C;
                      }

                      System.out.println("Please enter the certificates. Make sure to leave spaces between each one.");
                      String[] certificates = scanner.nextLine().split(" ");
                      List<String> certificatesList = new ArrayList<>(List.of(certificates));
                      System.out.println("Please enter the mail: ");
                      String mail = scanner.nextLine();
                      System.out.println("Please enter the phone number: ");
                      String phoneNumber = scanner.nextLine();
                      String result = bootcampersList.addParticipants(new Bootcamper(firstName,lastName,programmingLanguage,certificatesList,mail,phoneNumber));
                      System.out.println(result);
                      break;
                  }
                  case 3:{
                      System.out.println("Please enter the mail to check if the bootcamper is in one of the lists: ");
                      scanner.nextLine();
                      String mail = scanner.nextLine();
                      if(bootcampersList.foundInList(mail,bootcampersList.getListOfParticipats())){
                          System.out.println("This person is in the participants list.");
                      } else if (bootcampersList.foundInList(mail,bootcampersList.getListOfWaitingPersons())) {
                          System.out.println("This person is in the waiting list.");
                      }else{
                          System.out.println("This person is not registered for the event.");
                      }
                      break;
                  }
                  case 4:{
                      System.out.println("Please enter the mail: ");
                      scanner.nextLine();
                      String mail = scanner.nextLine();
                      Bootcamper bootcamper = bootcampersList.searchBootcamper(mail);
                      bootcampersList.removeBootcamper(bootcamper);
                      break;
                  }
                  case 5:{
                      System.out.println("Please enter the mail: ");
                      scanner.nextLine();
                      Bootcamper bootcamper = bootcampersList.searchBootcamper(scanner.nextLine());
                      System.out.println("Please enter the field you want to update:(firstname, lastname, programminglanguage, certificates, mail, phone) ");
                      String field = scanner.nextLine();
                      switch (field){
                          case "firstname":{
                              System.out.println("Please enter the new first name: ");
                              bootcamper.setFirstName(scanner.nextLine());
                              break;
                          }
                          case "lastname":{
                              System.out.println("Please enter the new last name: ");
                              bootcamper.setLastName(scanner.nextLine());
                              break;
                          }
                          case "programminglanguage":{
                              System.out.println("Please enter the new programming language: ");
                              String language = scanner.nextLine();
                              if(language.equals("JAVA")){
                                  bootcamper.setProgrammingLanguage(ProgrammingLanguage.JAVA);
                              } else if (language.equals("C")) {
                                  bootcamper.setProgrammingLanguage(ProgrammingLanguage.C);
                              } else if (language.equals("PYTHON")) {
                                  bootcamper.setProgrammingLanguage(ProgrammingLanguage.PYTHON);
                              }
                              break;
                          }
                          case "certificates":{
                              System.out.println("Please enter the name of the certificates separated with space: ");
                              String[] certificates = scanner.nextLine().split(" ");
                              List<String> certificatesList = new ArrayList<>(List.of(certificates));
                              bootcamper.setListOfCertificates(certificatesList);
                              break;
                          }
                          case "mail":{
                              System.out.println("Please enter the new mail: ");
                              bootcamper.setEmail(scanner.nextLine());
                              break;
                          }
                          case "phone":{
                              System.out.println("Please enter the new phone number: ");
                              bootcamper.setPhoneNumber(scanner.nextLine());
                              break;
                          }
                          default:{
                              System.out.println("You entered an invalid value!");
                          }
                      }
                  }
                  case 6:{
                      bootcampersList.showAttendanceList();
                      break;
                  }
                  case 7:{
                      bootcampersList.showAttendanceByProgrammingLanguage(ProgrammingLanguage.JAVA);
                      break;
                  }
                  case 8:{
                      bootcampersList.showAttendanceByProgrammingLanguage(ProgrammingLanguage.C);
                      break;
                  }
                  case 9:{
                      bootcampersList.showAttendanceByProgrammingLanguage(ProgrammingLanguage.PYTHON);
                      break;
                  }
                  case 10: {
                      bootcampersList.showWaitingList();
                      break;
                  }
                  case 11:{
                      System.out.println(bootcampersList.getSeatsAvailable());
                      break;
                  }
                  case 12:{
                      System.out.println(bootcampersList.nrOfParticipants());
                      break;
                  }
                  case 13:{
                      System.out.println(bootcampersList.nrOfPeopleInWaitingList());
                      break;
                  }
                  case 14:{
                      System.out.println(bootcampersList.nrOfPeople());
                      break;
                  }
                  case 15:{
                      scanner.nextLine();
                      System.out.println("Enter what you want to search: ");
                      String search = scanner.nextLine();
                      List<Bootcamper> list = bootcampersList.search(search);
                      for(Bootcamper b:list){
                          System.out.println(b);
                      }
                      break;
                  }
                  case 16: break;
                  default:{
                      System.out.println("You entered an invalid value!");
                  }
              }
          }
    }

    public static void printMenu(){
        System.out.println("Select your option: ");
        for (String menuOption:menuOptions){
            System.out.println(menuOption);
        }
    }
}
