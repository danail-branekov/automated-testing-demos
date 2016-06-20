package com.epam.demo.mockito;

public interface PersonDao {
    public Person get(Integer personID) throws MyDbException;

    public void update(Person person) throws MyDbException;

    public void delete(Person person) throws MyDbException;
}
