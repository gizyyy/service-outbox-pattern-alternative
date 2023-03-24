package com.example.gizem.yilmaz.domain;

import com.example.gizem.yilmaz.domain.event.StudentAddedEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@Document
public class Student extends AbstractAggregateRoot<Student> {
    @Id
    private long studentId;

    private String studentName;

    private Instant occurredAt;

    private Student(long studentId, String studentName, Instant occurredAt) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.occurredAt = occurredAt;
        registerEvent(new StudentAddedEvent(this.studentId, this.studentName, this.occurredAt));
    }

    public static Student from(long studentId, String studentName, Instant occurredAt) {
        Student student = new Student(studentId, studentName, occurredAt);
        return student;
    }
}
