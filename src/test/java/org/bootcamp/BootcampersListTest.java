package org.bootcamp;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class BootcampersListTest {
    static BootcampersList bootcampersList = new BootcampersList(4);
    @BeforeEach
     void setUp(){
        List<String> certificates1 = new ArrayList<>();
        certificates1.add("c1");
        certificates1.add("c2");
        bootcampersList.addParticipants(new Bootcamper("cris","cris",ProgrammingLanguage.JAVA,certificates1,"cris@cris.com","0766666666"));
        bootcampersList.addParticipants(new Bootcamper("radu","radu",ProgrammingLanguage.JAVA,certificates1,"radu@cris.com","0766636666"));
        bootcampersList.addParticipants(new Bootcamper("andrei","andrei",ProgrammingLanguage.C,certificates1,"a@cris.com","0766666656"));
        bootcampersList.addParticipants(new Bootcamper("anara","ana",ProgrammingLanguage.PYTHON,certificates1,"ana@cris.com","0766666566"));
        bootcampersList.addParticipants(new Bootcamper("nimeni","nimeni",ProgrammingLanguage.PYTHON,certificates1,"nimeni@cris.com","0766661566"));
    }

    @Test
    @DisplayName("Bootcamper found in correct list")
    void foundInListCorrectBootcamperandList(){
        Assertions.assertTrue(bootcampersList.foundInList("cris@cris.com",bootcampersList.getListOfParticipats()));
    }

    @Test
    @DisplayName("Bootcamper in incorrect list")
    void foundInListCorrectBootcamperNotList(){
        Assertions.assertFalse(bootcampersList.foundInList("cris@cris.com",bootcampersList.getListOfWaitingPersons()));
    }

    @Test
    @DisplayName("Bootcamper does not exist")
    void foundInListInCorrectBootcamper(){
        Assertions.assertFalse(bootcampersList.foundInList("cris@cri.com",bootcampersList.getListOfParticipats()));
    }

    @Test
    @DisplayName("Mail is valid")
    void isMailValidCorrect(){
        Assertions.assertTrue(bootcampersList.isMailValid("cris234@ceva.altceva"));
    }

    @Test
    @DisplayName("Mail is not valid")
    void isMailValidIncorrect(){
        Assertions.assertFalse(bootcampersList.isMailValid("cris234ceva"));
    }

    @Test
    @DisplayName("Bootcamper's data is valid")
    void checkValidBootcamperCorrect(){
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"ceva@altceva","0711111111");
        Assertions.assertTrue(bootcampersList.checkValidBootcamper(b));
    }

    @Test
    @DisplayName("Bootcamper's data is invalid")
    void checkValidBootcamperIncorrect(){
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"cevaaltceva","0711111111");
        Assertions.assertFalse(bootcampersList.checkValidBootcamper(b));
    }

    @Nested
    public class NestedTestBlock{
        BootcampersList bootcampersListt = new BootcampersList(4);
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"ceva@altceva","0711111111");
        @Test
        @DisplayName("Adding participants in list")
        void addParticipantss(){
            Assertions.assertEquals("success",bootcampersListt.addParticipants(b));
        }

        @Test
        @DisplayName("Remove from participants list")
        void removeBootcamperParticipantsListt(){
            bootcampersListt.addParticipants(b);
            Assertions.assertTrue(bootcampersListt.removeBootcamper(b));
        }

        @Test
        @DisplayName("Show correct number of participants")
        void getNrOfParticipantss(){
            bootcampersListt.addParticipants(b);
            Assertions.assertEquals(1,bootcampersListt.nrOfParticipants());
        }

        @Test
        @DisplayName("Show correct number of people in waiting list")
        void getNrOfPeopleInWaitingListt(){
            Assertions.assertEquals(0,bootcampersListt.nrOfPeopleInWaitingList());
        }
        @Test
        @DisplayName("Show correct number of people")
        void getNrOfPeoplee(){
            bootcampersListt.addParticipants(b);
            Assertions.assertEquals(1,bootcampersListt.nrOfParticipants());
        }

    }
    @Test
    @DisplayName("Adding participants in waiting list")
    void addParticipantsInWaitingList(){
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"ceva@alceva","0711111111");
        Assertions.assertEquals("your number in the list is 3",bootcampersList.addParticipants(b));
    }

    @Test
    @DisplayName("Adding a participant that is already in list")
    void addParticipantsThatAreInList(){
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"ceva@altceva","0711111111");
        bootcampersList.addParticipants(b);
        Assertions.assertEquals("registered",bootcampersList.addParticipants(b));
    }

    @Test
    @DisplayName("Adding incorrect infos for participant.")
    void addParticipantsIncorrectInfo(){
        Bootcamper b = new Bootcamper("fsf","Effdd",ProgrammingLanguage.JAVA,new ArrayList<>(),"ceva@altceva","0711111");
        Assertions.assertEquals("The infos are incorrect!",bootcampersList.addParticipants(b));
    }

    @Test
    @DisplayName("Remove from waiting list")
    void removeBootcamperWaitingList(){
        Bootcamper b = new Bootcamper("nimeni2","nimeni2",ProgrammingLanguage.PYTHON,new ArrayList<>(),"nimeni2@cris.com","0766661576");
        bootcampersList.addParticipants(b);
        Assertions.assertTrue(bootcampersList.removeBootcamper(b));
    }

    @Test
    @DisplayName("Remove a bootcamper that does not exist")
    void removeIncorrectBootcamper(){
        Bootcamper b = new Bootcamper("nimeni2","nimeni2",ProgrammingLanguage.PYTHON,new ArrayList<>(),"nimeni2@cris.com","0766661576");
        Assertions.assertFalse(bootcampersList.removeBootcamper(b));
    }

    @Test
    @DisplayName("Show correct number of seats available")
    void getSeatsAvailableNoSeats(){
        Assertions.assertEquals("There are no seats available!",bootcampersList.getSeatsAvailable());
    }

    @Test
    @DisplayName("Show correct number of participants")
    void getNrOfParticipants(){
        Assertions.assertEquals(4,bootcampersList.nrOfParticipants());
    }

    @Test
    @DisplayName("Show correct number of people in waiting list")
    void getNrOfPeopleInWaitingList(){
        Assertions.assertEquals(3,bootcampersList.nrOfPeopleInWaitingList());
    }

}
