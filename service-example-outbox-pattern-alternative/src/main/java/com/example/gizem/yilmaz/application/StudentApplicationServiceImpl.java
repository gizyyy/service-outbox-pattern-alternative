package com.example.gizem.yilmaz.application;

import com.example.gizem.yilmaz.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final StudentRegistrationService studentRegistrationService;

    @Override
    public Mono<Student> process(Student student) {
        return studentRegistrationService.register(student);
    }

}
