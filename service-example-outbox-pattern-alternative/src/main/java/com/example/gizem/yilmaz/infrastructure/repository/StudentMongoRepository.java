package com.example.gizem.yilmaz.infrastructure.repository;

import com.example.gizem.yilmaz.domain.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentMongoRepository extends ReactiveMongoRepository<Student, Long> {
}
