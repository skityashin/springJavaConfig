package com.levelup.springJavaConfig.controller;


import com.levelup.springJavaConfig.model.Person;
import com.levelup.springJavaConfig.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        if (CollectionUtils.isEmpty(persons)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(persons, HttpStatus.OK);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getById(@PathVariable long personId){
       if(!personService.isPersonExist(personId)){
           return new ResponseEntity(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity(personService.findById(personId), HttpStatus.OK);
    }

//    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity getOneById(@PathVariable long personId) {
//        return new ResponseEntity(personService.findById(personId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/delete/{personId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable long personId) {
        if(!personService.isPersonExist(personId)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        personService.deleteById(personId);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity addPe(@PathVariable long personId) {
//        if(!personService.isPersonExist(personId)){
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        personService.deleteById(personId);
//        return new ResponseEntity(HttpStatus.OK);
//    }
}

