package com.examenfinal.listacontactosapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examenfinal.listacontactosapi.dto.ContactDTO;
import com.examenfinal.listacontactosapi.entity.Contact;

import com.examenfinal.listacontactosapi.service.ContactService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts") // ingresar a los endpoints a los metodos
@RestController // esta clase sera un controlador(retornamos objetos)
public class ContactController {

    
    private final ContactService contactService; // delegamos la inicializacion

    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll(); // cargar todos los datos de contactos

    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @Validated @RequestBody ContactDTO contactDTO) {
        return contactService.update(id, contactDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }

}
