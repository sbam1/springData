package com.suseelbam.javatutorials.springData.repositories;

import com.suseelbam.javatutorials.springData.SpringDataApplication;
import com.suseelbam.javatutorials.springData.configuration.H2TestProfileJPAConfig;
import com.suseelbam.javatutorials.springData.entities.Address;
import com.suseelbam.javatutorials.springData.entities.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringDataApplication.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@Ignore
public class UsersRepositoryCompTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddressRepository addressRepository;

    Address address1;
    Address address2;
    Address address3;
    Address address4;

    @Before
    public void setup() {
        address1 = new Address("4120 Appian Way Ct", "Columbus", "HO", 43230, "USA");
        address2 = new Address("4121 Appian Way Ct", "Gahanna", "HO", 43231, "USA");
        address3 = new Address("4122 Appian Way Ct", "Worthington", "HO", 43232, "USA");
        address4 = new Address("4123 Appian Way Ct", "grove port", "HO", 43233, "USA");
        addressRepository.saveAll(Arrays.asList(address1, address2, address3, address4));

        Users userA = new Users("bamsuseel", "bamsuseel@email.com",address1);
        Users userB = new Users("anil123", "anil123@email.com", address3);
        Users userC = new Users("shyam", "shyam@email.com", address2);
        Users userD = new Users("susmapun", "susmapun@email.com",  address4);
        Users userE = new Users("sudha", "sudha@email.com", address3);
        Users userF = new Users("bhuwan", "bhuwan@email.com",address4);

        userA.setCreatedBy("suseel bam");

        usersRepository.saveAll(Arrays.asList(userA, userB, userC, userD, userE, userF));
    }

    @After
    public void cleanup() {
        usersRepository.deleteAll();
        addressRepository.deleteAll();
    }


    @Test
    public void findAll_should_return_all_users() {
        List<Users> searchResults = usersRepository.findAll();
        assertEquals(6, searchResults.size());

    }

    @Test
    @Transactional
    public void findAllByUserName_should_return_list_of_users_of_given_name() {
       List<Users> searchResult = usersRepository.findAllByUserName("bhuwan");
        assertEquals(1, searchResult.size());
        Users user = searchResult.get(0);
        assertEquals("bhuwan", user.getUserName());
        assertEquals("bhuwan@email.com", user.getEmail());
        assertEquals(address4.getStreet(), user.getAddress().getStreet());

    }

    @Test
    public void save_should_save_given_user() {
        Users user = new Users("newUser", "new emailAddress", address4);
        usersRepository.save(user);
        assertEquals(7,usersRepository.findAll().size());
    }



    @Test
    public void save_should_update_given_user() {
        Users user = new Users("newUser", "newuser@email.com", address4);
        user.setId(10);
        Users updated = usersRepository.save(user);
        assertEquals(6, usersRepository.findAll().size());
        assertEquals("newUser", updated.getUserName()) ;
        assertEquals("newuser@email.com", updated.getEmail());
    }


}
