package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemTest {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;



    @Test
    @DisplayName("status nullable = false 적용되는지 확인")
    void testStatusNotNull() {
        User owner = userRepository.save(new User("user","user@gmail.com","user","password1234"));
        User manager = userRepository.save(new User("admin","admin@gmail.com","admin","password4321"));
        Item item = new Item("사과","맛있습니다.",manager,owner);

        Item saved =itemRepository.save(item);

        Item findItem = itemRepository.findByIdOrElseThrow(saved.getId());

        assertThat(findItem.getStatus()).isNotNull();

        assertThat(findItem.getStatus()).isEqualTo("PENDING");
    }
}
