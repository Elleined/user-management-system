package com.example.loginfx.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRepositoryTest {

    private final DeleteRepository deleteRepository = new DeleteRepositoryImpl();

    @Test
    void delete() {
        deleteRepository.delete(3, "demadegu@gmail.com");
    }
}