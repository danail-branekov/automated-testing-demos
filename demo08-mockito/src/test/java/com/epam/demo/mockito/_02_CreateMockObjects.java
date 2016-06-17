package com.epam.demo.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class _02_CreateMockObjects {
    @Mock
    private PersonDao personDao;

    @Mock
    private File file;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMocks() {
        assertThat(personDao, instanceOf(PersonDao.class));
        assertThat(file, instanceOf(File.class));
    }
}
