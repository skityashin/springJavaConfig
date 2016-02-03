package com.levelup.springJavaConfig.repository.impl;


import com.levelup.springJavaConfig.model.Person;
import com.levelup.springJavaConfig.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void savePerson(Person person) {
        hibernateTemplate.saveOrUpdate(person);
    }

    @Override
    public void updatePerson(Person person) {
        hibernateTemplate.saveOrUpdate(person);
    }

    @Override
    public Person findById(long id) {
        return hibernateTemplate.get(Person.class, id);
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) hibernateTemplate.find("from Person");
    }

    @Override
    public void deleteById(long id) {
        hibernateTemplate.delete(id);
    }

    @Override
    public boolean isPersonExist(long id) {
        return hibernateTemplate.contains(id);
    }
}
