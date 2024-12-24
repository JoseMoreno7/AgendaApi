package com.examenfinal.listacontactosapi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examenfinal.listacontactosapi.entity.Contact;
import com.examenfinal.listacontactosapi.repository.ContactRepository;

@SpringBootApplication
public class ListacontactosapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListacontactosapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
			List<Contact> contacts = Arrays.asList(

				new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
				new Contact("Marcelo", "marcelo@gmail.com", LocalDateTime.now()),
				new Contact("Luis", "luis@gmail.com", LocalDateTime.now()),
				new Contact("Jorge", "jorge@gamail.com", LocalDateTime.now()),
				new Contact("Sofia", "sofia@gmail.com", LocalDateTime.now())
			);
			contactRepository.saveAll(contacts);
		};
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
