package com.springframework.webapp.repositories;

import com.springframework.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
        }
