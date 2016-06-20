package com.epam.demo.mockito;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class _04_RecordExpectationsDemo {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private PersonDao personDao;

    Person firstPerson;
    Person secondPerson;
    private PersonService personService;

    @Before
    public void setUp() {
        personService = new PersonService(personDao);
        firstPerson = new Person(1, "first");
        secondPerson = new Person(2, "second");

    }

    @Test
    public void testSingleReturnValue() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        assertThat(personService.get(1).getPersonName(), is("first"));
    }

    @Test
    public void testMultipleReturnValues() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson).thenReturn(secondPerson).thenReturn(new Person(123, "third-person"));
        assertThat(personService.get(1).getPersonName(), is("first"));
        assertThat(personService.get(1).getPersonName(), is("second"));
        assertThat(personService.get(1).getPersonName(), is("third-person"));
        assertThat(personService.get(1).getPersonName(), is("third-person"));
    }

    @Test
    public void testAnswer() throws MyDbException, NoSuchPersonException {
        when(personDao.get(anyInt())).thenAnswer(new Answer<Person>() {
            public Person answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                Integer personId = (Integer) arguments[0];
                switch (personId) {
                    case 1:
                        return firstPerson;
                    case 2:
                        return secondPerson;
                    default:
                        throw new NoSuchPersonException("Unknown person: " + personId);
                }
            }
        });

        assertThat(personService.get(1), is(firstPerson));
        assertThat(personService.get(2), is(secondPerson));

        expectedException.expect(NoSuchPersonException.class);
        personService.get(3);
    }

    @Test
    public void testRecordThrowException() throws MyDbException, NoSuchPersonException {
        MyDbException dbException = new MyDbException();
        when(personDao.get(anyInt())).thenThrow(dbException);
        expectedException.expect(sameInstance(dbException));
        personService.get(123);
    }

    @Test
    public void testRecordVoidMethods() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        doThrow(new MyDbException()).when(personDao).update(Mockito.any(Person.class));
        expectedException.expect(MyDbException.class);
        personService.update(1, "another-name");
    }

    @Test
    public void testVerifyInvocationParameters() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        personService.delete(1);
        verify(personDao).delete(firstPerson);
    }

    @Test
    public void testVerifyWithCustomMatcher() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        personService.delete(1);
        verify(personDao).delete(argThat(new BaseMatcher<Person>() {
            public boolean matches(Object item) {
                Person deletedPerson = (Person) item;
                return deletedPerson == firstPerson;
            }

            public void describeTo(Description description) {
                description.appendText("first person");
            }
        }));

    }

    @Test
    public void testVerifyValueWithArgumentCaptor() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        personService.update(1, "updated-name");

        ArgumentCaptor<Person> updatedPersonCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personDao).update(updatedPersonCaptor.capture());
        assertThat(updatedPersonCaptor.getValue().getPersonName(), is("updated-name"));
    }

    @Test
    public void testVerifyInvocationOrder() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        personService.update(1, "updated-name");

        InOrder inOrder = inOrder(personDao/*, <any other mocks>*/);
        inOrder.verify(personDao).get(1);
        inOrder.verify(personDao).update(any(Person.class));
    }

    @Test
    public void testVerifyInvocationMultipleTimes() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(firstPerson);
        when(personDao.get(2)).thenReturn(secondPerson);

        Map<Integer, String> updateData = new HashMap<Integer, String>();
        updateData.put(1, "first-updated");
        updateData.put(2, "second-updated");

        personService.bulkUpdate(updateData);

        ArgumentCaptor<Person> updatedPersonCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personDao, times(2)).update(updatedPersonCaptor.capture());

        assertThat(updatedPersonCaptor.getAllValues().get(0).getPersonName(), is("first-updated"));
        assertThat(updatedPersonCaptor.getAllValues().get(1).getPersonName(), is("second-updated"));
    }

    @Test
    public void testZeroInvocations() throws MyDbException, NoSuchPersonException {
        personService.bulkUpdate(new HashMap<Integer, String>());
        verifyZeroInteractions(personDao);
    }

    @Test
    public void testNoMoreInteractions() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(null);

        expectedException.expect(NoSuchPersonException.class);
        personService.get(1);

        verify(personDao).get(1);
        verifyNoMoreInteractions(personDao);
    }

    @Test
    public void testRest() throws MyDbException, NoSuchPersonException {
        when(personDao.get(1)).thenReturn(null);

        expectedException.expect(NoSuchPersonException.class);
        personService.get(1);

        reset(personDao);
        verifyZeroInteractions(personDao);
    }
}
