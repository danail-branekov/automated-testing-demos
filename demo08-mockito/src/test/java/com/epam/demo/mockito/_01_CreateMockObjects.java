package com.epam.demo.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class _01_CreateMockObjects {
    private PersonDao personDao;

    @Before
    public void setUp() {
        personDao = Mockito.mock(PersonDao.class);
    }

    @Test
    public void testMocks() {
        assertThat(personDao, instanceOf(PersonDao.class));
    }
}
