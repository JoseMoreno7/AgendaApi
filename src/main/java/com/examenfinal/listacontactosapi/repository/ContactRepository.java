package com.examenfinal.listacontactosapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.examenfinal.listacontactosapi.entity.Contact;

// extendemos para tener la operaciones basicas
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
