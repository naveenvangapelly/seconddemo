package com.newtest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newtest.entity.StudentEntity;

@Configurable
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
