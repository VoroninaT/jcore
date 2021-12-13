package lesson4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {

    private Map<String, List<String>> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber){

        if (contacts.containsKey(name)) {
            // если фамилия уже есть в мапе - надо добавить номер
            List<String> phones = contacts.getOrDefault(name, new ArrayList<>());
            phones.add(phoneNumber);

        } else {
            // если в мапе нет фамилии - добавляем и фамилию и номер
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            contacts.put(name, phones);
        }
    }

    public List<String> search(String name){
        return contacts.getOrDefault(name, new ArrayList<>());
    }

}