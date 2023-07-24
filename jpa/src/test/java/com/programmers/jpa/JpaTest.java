package com.programmers.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.jpa.repository.CustomerRepository;
import com.programmers.jpa.repository.domain.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class JpaTest {

    @Autowired
    CustomerRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void INSERT_TEST() {
        // given
        CustomerEntity customer = new CustomerEntity("changhyeon", "hwang", 22);

        // when
        CustomerEntity savedCustomer = repository.save(customer);

        // then
        assertThat(savedCustomer.getFirstName()).isEqualTo(customer.getFirstName());
    }

    @Test
    @Transactional
    void UPDATE_TEST() {
        // given
        CustomerEntity customer = new CustomerEntity("changhyeon", "hwang", 22);
        repository.save(customer);

        // when
        CustomerEntity entity = repository.findById(1L).get();
        entity.setLastName("changhyeonhwang");

        CustomerEntity updated = repository.findById(1L).get();

        // then
        assertThat(entity.getLastName()).isEqualTo(updated.getLastName());
    }

}
