package com.levelup.springJavaConfig.service.impl;


import com.levelup.springJavaConfig.model.Person;
import com.levelup.springJavaConfig.repository.PersonDao;
import com.levelup.springJavaConfig.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public void savePerson(Person person) {
        if(person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        personDao.savePerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public Person findById(long id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }


    @Override
    public void deleteById(long id) {
        personDao.deleteById(id);
    }

    @Override
    public boolean isPersonExist(long id) {
        return personDao.isPersonExist(id);
    }
}
