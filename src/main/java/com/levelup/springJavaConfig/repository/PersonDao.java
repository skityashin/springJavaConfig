package com.levelup.springJavaConfig.repository;


import com.levelup.springJavaConfig.model.Person;
import java.util.List;

public interface PersonDao {
    public void savePerson (Person person);
    public void updatePerson (Person person);
    public void deleteById (long id);
    public boolean isPersonExist(long id);
    public Person findById (long id);
    public List<Person> getAllPersons ();

}
