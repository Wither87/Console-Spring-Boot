package com.console.consolespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.FileNotFoundException;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ConsoleSpringBootApplication implements CommandLineRunner {

	@Autowired
	FilesService filesService;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length != 1) {
			System.out.println("Неправильное количество аргументов.");
			return;
		}
		try {
			filesService.executeFunction(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
		}
	}
}
