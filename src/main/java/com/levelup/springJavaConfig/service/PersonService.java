package com.levelup.springJavaConfig.service;


import com.levelup.springJavaConfig.model.Person;
import java.util.List;

public interface PersonService {

    public void savePerson (Person person);
    public void updatePerson (Person person);
    public Person findById (long id);
    public List<Person> getAllPersons ();
    public void deleteById (long id);
    public boolean isPersonExist(long id);

}
