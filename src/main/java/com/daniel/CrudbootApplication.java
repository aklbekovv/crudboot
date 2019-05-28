package com.daniel;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.daniel.domain.Course;
import com.daniel.domain.CourseRepository;
import com.daniel.domain.Student;
import com.daniel.domain.StudentRepository;
import com.daniel.domain.User;
import com.daniel.domain.UserRepository;

@SpringBootApplication
public class CrudbootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CrudbootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CrudbootApplication.class, args);
	}
	
	/**
	 * Save demo users and students to H2 DB
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			// save students
			Student student1 = new Student("Daniel", "Akylbekov", "COM-15", "daniel.akylbekov@iaau.edu.kg");
			repository.save(new Student("Askarbek", "Baiasov", "COM-15", "askarbek.baiasov@iaau.edu.kg"));
			repository.save(new Student("Sanzhar", "Zhenishbek", "COM-15", "sanzhar.zhenishbekuulu@iaau.edu.kg"));
			repository.save(new Student("Daiyrbek", "Kanybekov", "COM-15","daiyrbek.kanybekov@iaau.edu.kg"));
			repository.save(new Student("Akylbek", "Mursaliev", "COM-15","akylbek.mursaliev@iaau.edu.kg"));
			repository.save(new Student("Yrysbek", "Tolokov", "COM-15", "yrysbek.tolokov@iaau.edu.kg"));
			repository.save(new Student("Dastan", "Keneshbekov", "COM-15", "dastan.keneshbekov@iaau.edu.kg"));
			repository.save(new Student("Nurulla", "Zholodoshev", "COM-15","nurulla.zholdoshov@iaau.edu.kg "));
			repository.save(new Student("Ibragim", "Murzatov", "COM-15","ibragim.murzatov@iaau.edu.kg "));
			repository.save(new Student("Saparbek", "Musaev", "COM-15", "saparbek.musaev@iaau.edu.kg "));
			repository.save(new Student("Bektur", "Israilov", "COM-15","bektur.israilov@iaau.edu.kg "));
			repository.save(new Student("Sagynbek", "Esenbekov", "COM-15","sagynbek.esenbekov@iaau.edu.kg "));

			Course course1 = new Course("Programming Java");
			Course course2 = new Course("Spring Boot basics");
			Course course3 = new Course("Software Engineering");
			Course course4 = new Course("Data Structure");
			Course course5 = new Course("Python");
			crepository.save(new Course("OOP"));
			crepository.save(new Course("Information Security"));
			crepository.save(new Course("C++"));
			crepository.save(new Course("JavaScript"));
			crepository.save(new Course("Calculus"));

			crepository.save(course1);
			crepository.save(course2);
			crepository.save(course3);
			crepository.save(course4);
			crepository.save(course5);

			
			Set<Course> courses = new HashSet<Course>();
			courses.add(course1);
			courses.add(course2);


			student1.setCourses(courses); 
			repository.save(student1);

			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user3 = new User("DANIEL", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "DANIEL");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}
}
