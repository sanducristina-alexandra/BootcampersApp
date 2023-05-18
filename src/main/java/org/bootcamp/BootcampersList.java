package org.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class BootcampersList {

    private int nrOfAvailablePlaces;
    private List<Bootcamper> listOfParticipats;
    private List<Bootcamper> listOfWaitingPersons;

    public BootcampersList(int nrOfAvailablePlaces) {
        this.nrOfAvailablePlaces = nrOfAvailablePlaces;
        listOfParticipats = new ArrayList<Bootcamper>(nrOfAvailablePlaces);
        listOfWaitingPersons = new ArrayList<Bootcamper>();
    }

    public boolean foundInList(String mail,List<Bootcamper> list){
        boolean found = false;
        for(Bootcamper b:list){
            if(b.getEmail().equals(mail))
                found=true;
        }
        return found;
    }

    public boolean isMailValid(String mail){
        final Pattern MAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return MAIL_REGEX.matcher(mail).matches();
    }
    public boolean checkValidBootcamper(Bootcamper b){
        if(b.getFirstName().equals("")) return false;
        if(b.getLastName().equals("")) return false;
        if(b.getPhoneNumber().length()!=10) return false;
        if(!isMailValid(b.getEmail())) return false;
        return true;
    }
    public String addParticipants(Bootcamper bootcamper){
        String result = "";
        if(checkValidBootcamper(bootcamper)) {
            if (!foundInList(bootcamper.getEmail(), listOfParticipats) && !foundInList(bootcamper.getEmail(), listOfWaitingPersons)) {
                if (listOfParticipats.size() >= nrOfAvailablePlaces) {
                    listOfWaitingPersons.add(bootcamper);
                    System.out.println("You have successfully registered on the waiting list and received the order number " + listOfWaitingPersons.size() + ". We will notify you if a place becomes available.");
                    result = "your number in the list is " + (listOfWaitingPersons.size());
                } else {
                    listOfParticipats.add(bootcamper);
                    System.out.println("Congratulations! Your place at the Bootcamp is confirmed. We are waiting for you!.");
                    result = "success";
                }
            } else {
                result = "registered";
            }
        }else{
            result = "The infos are incorrect!";
        }
         return result;
    }

    public Bootcamper searchBootcamper(String mail) {
        for (Bootcamper b : listOfParticipats) {
            if (b.getEmail().equals(mail)) {
                return b;
            }
        }
        for (Bootcamper b : listOfWaitingPersons) {
            if (b.getEmail().equals(mail)) {
                return b;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean removeBootcamper(Bootcamper b){
        if(foundInList(b.getEmail(),listOfParticipats)){
            listOfParticipats.remove(b);
            System.out.println("The person was removed from the participants list.");
            if(!listOfWaitingPersons.isEmpty()){
                listOfParticipats.add(listOfWaitingPersons.get(0));
                System.out.println(b.getFirstName() + " "+ b.getLastName()+" who has this email adress "+b.getEmail()+" was moved to the participants list.");
            }
            return true;
        } else if (foundInList(b.getEmail(),listOfWaitingPersons)) {
            listOfWaitingPersons.remove(b);
            System.out.println("The person was removed from the waiting list.");
            return true;
        }else return false;
    }
    public void showAttendanceList(){
        for(Bootcamper b: listOfParticipats){
            System.out.println(b);
            System.out.println();
        }
    }
    public void showAttendanceByProgrammingLanguage(ProgrammingLanguage programmingLanguage){
        for(Bootcamper b: listOfParticipats){
            if(b.getProgrammingLanguage() == programmingLanguage){
                System.out.println(b);
                System.out.println();
            }
        }
    }

    public void showWaitingList(){
        for (Bootcamper b: listOfWaitingPersons){
            System.out.println(b);
            System.out.println();
        }
    }

    public String getSeatsAvailable(){
        int nrParticipants = listOfParticipats.size();
        int seatsAvailable = nrOfAvailablePlaces - nrParticipants;
        if(seatsAvailable==0){
            return "There are no seats available!";
        }else{
            return "There are " + seatsAvailable +" seats available.";
        }
    }

    public int nrOfParticipants(){
        return listOfParticipats.size();
    }

    public int nrOfPeopleInWaitingList(){
        return listOfWaitingPersons.size();
    }

    public int nrOfPeople(){
        return nrOfParticipants()+nrOfPeopleInWaitingList();
    }

    public List<Bootcamper> search(String searchString){
        List<Bootcamper> result = new ArrayList<>();
        for(Bootcamper b:listOfParticipats){
              if(searchInFirstName(b.getFirstName(),searchString))
                  result.add(b);
              else if (searchInLastName(b.getLastName(),searchString)) {
                  result.add(b);
              } else if (searchInProgrammingLanguage(b.getProgrammingLanguage(),searchString)) {
                  result.add(b);
              } else if (searchInCertificates(b.getListOfCertificates(),searchString)) {
                  result.add(b);
              } else if (searchInMail(b.getEmail(),searchString)) {
                  result.add(b);
              } else if (searchInPhone(b.getPhoneNumber(),searchString)) {
                  result.add(b);
              }
        }
        return result;
    }

    public boolean searchInFirstName(String firstName,String searchString){
        return firstName.toLowerCase().contains(searchString.toLowerCase());
    }

    public boolean searchInLastName(String lastName,String searchString){
        return lastName.toLowerCase().contains(searchString.toLowerCase());
    }

    public boolean searchInProgrammingLanguage(ProgrammingLanguage programmingLanguage,String searchString){
        return programmingLanguage.toString().toLowerCase().contains(searchString.toLowerCase());
    }
    
    public boolean searchInCertificates(List<String> list,String searchString){
        boolean result = false;
        for(String certificate: list){
            if(certificate.toLowerCase().contains(searchString.toLowerCase()))
                result = true;
        }
        return result;
    }
    
    public boolean searchInMail(String mail,String searchString){
        return mail.toLowerCase().contains(searchString.toLowerCase());
    }

    public boolean searchInPhone(String phone,String searchString){
        return phone.toLowerCase().contains(searchString.toLowerCase());
    }

    public List<Bootcamper> getListOfParticipats() {
        return listOfParticipats;
    }

    public List<Bootcamper> getListOfWaitingPersons() {
        return listOfWaitingPersons;
    }
}
