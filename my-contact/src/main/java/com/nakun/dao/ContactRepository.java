package com.nakun.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nakun.entities.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String term);

}
