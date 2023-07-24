package com.programmers.part2;


import com.programmers.part2.config.CustomerRepository;
import com.programmers.part2.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void test() {
        // given
        Customer customer = new Customer("changhyeon", "hwang", 23);

        // when
        customerRepository.save(customer);

        // Then
        Customer entity = customerRepository.findById(1L).get();
        Assertions.assertThat(entity.getFirstName()).isEqualTo(customer.getFirstName());
    }


}
