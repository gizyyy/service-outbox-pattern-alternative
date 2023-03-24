package com.example.gizem.yilmaz.domain.repository;

import com.example.gizem.yilmaz.domain.Student;
import reactor.core.publisher.Mono;

public interface StudentRepository {
    Mono<Student> save(Student student);


}
