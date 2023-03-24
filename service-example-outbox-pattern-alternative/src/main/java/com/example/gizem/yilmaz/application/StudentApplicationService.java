package com.example.gizem.yilmaz.application;

import com.example.gizem.yilmaz.domain.Student;
import reactor.core.publisher.Mono;

public interface StudentApplicationService {
    Mono<Student> process(Student student);

}
