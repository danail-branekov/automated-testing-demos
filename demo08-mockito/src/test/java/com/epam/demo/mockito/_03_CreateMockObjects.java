package com.epam.demo.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class _03_CreateMockObjects {
    @Mock
    private PersonDao personDao;

    @Mock
    private File file;

    @Test
    public void testMocks() {
        assertThat(personDao, instanceOf(PersonDao.class));
        assertThat(file, instanceOf(File.class));
    }
}
