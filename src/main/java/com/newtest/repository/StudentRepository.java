package com.newtest.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newtest.entity.StudentEntity;

@Configurable
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
