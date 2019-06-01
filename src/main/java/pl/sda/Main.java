package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.repository.PersonRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        PersonRepository personRepository = (PersonRepository) context.getBean("personRepository");

        Person person = createPerson();
        personRepository.save(person);

        Iterable<Person> all = personRepository.findAll();
        for (Person person1 : all) {
            System.out.println(person1);
        }

    }

    private static Person createPerson() {
        Person person = new Person();
        person.setFirstName("Olek");
        person.setLastName("Kowalski");
        return person;
    }
}
