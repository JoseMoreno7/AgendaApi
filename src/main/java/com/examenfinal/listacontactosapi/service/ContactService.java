package com.examenfinal.listacontactosapi.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.examenfinal.listacontactosapi.dto.ContactDTO;
import com.examenfinal.listacontactosapi.entity.Contact;
import com.examenfinal.listacontactosapi.exception.ResourceNotFoundException;
import com.examenfinal.listacontactosapi.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {
    
    private final ContactRepository contactRepository; // delegamos la inicializacion

    private final ModelMapper mapper;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll(); // cargar todos los datos de contactos
    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO) {
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {
        Contact contactFromDb = findById(id);
        mapper.map(contactDTO, contactFromDb);
        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);

        contactRepository.delete(contactFromDb);
    }

}
