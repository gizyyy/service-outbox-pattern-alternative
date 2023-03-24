package com.example.gizem.yilmaz.infrastructure.repository;

import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StudentDataMongoRepository implements StudentRepository {

    private final StudentMongoRepository studentMongoRepository;

    public Mono<Student> save(Student student) {
        return studentMongoRepository.save(student);
    }

}
