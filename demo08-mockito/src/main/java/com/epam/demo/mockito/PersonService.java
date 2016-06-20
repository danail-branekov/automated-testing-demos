package com.epam.demo.mockito;

import java.util.Map;
import java.util.Map.Entry;

public class PersonService {
    private final PersonDao personDao;
    private boolean connected;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person get(final Integer personId) throws MyDbException, NoSuchPersonException {
        Person person = personDao.get(personId);
        if (person != null) {
            return person;
        }
        throw new NoSuchPersonException(String.format("Person with id %d not found", personId));
    }

    public Person update(Integer personId, String name) throws MyDbException, NoSuchPersonException {
        Person person = get(personId);
        Person updatedPerson = new Person(person.getPersonID(), name);
        personDao.update(updatedPerson);
        return updatedPerson;
    }

    public void bulkUpdate(Map<Integer, String> nameUpdates) throws MyDbException, NoSuchPersonException {
        for(Entry<Integer, String> updateEntry : nameUpdates.entrySet()) {
            update(updateEntry.getKey(), updateEntry.getValue());
        }
    }

    public void delete(Integer personId) throws MyDbException, NoSuchPersonException {
        Person person = get(personId);
        personDao.delete(person);
    }
}