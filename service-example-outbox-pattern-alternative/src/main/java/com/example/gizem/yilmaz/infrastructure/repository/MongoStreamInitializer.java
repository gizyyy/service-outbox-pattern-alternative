package com.example.gizem.yilmaz.infrastructure.repository;

import com.example.gizem.yilmaz.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
@RequiredArgsConstructor
@Slf4j
public class MongoStreamInitializer {
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @PostConstruct
    public void init() {
        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .returnFullDocumentOnUpdate()
                .filter(Aggregation.newAggregation(Student.class, match(where("operationType").in("insert", "update", "replace"))))
                .build();

        Flux<ChangeStreamEvent<Student>> jobs = reactiveMongoTemplate
                .changeStream("student", options, Student.class);

        jobs.doOnNext(x -> {
                    log.info("Change received={}", x.getBody());
                    // next try to emit spring application event, and listen it to send ecst
                })
                .doOnCancel(() -> {
                    log.info("cancelling consuming...");
                }).subscribe();
    }
}
