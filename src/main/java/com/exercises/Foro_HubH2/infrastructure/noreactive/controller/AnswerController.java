package com.exercises.Foro_HubH2.infrastructure.noreactive.controller;


import com.exercises.Foro_HubH2.application.usecase.IAnswerEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.AnswerDto;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.AnswerDtoMapper;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.PageResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final IAnswerEntityInteractor answerEntityInteractor;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestBody Answer answer){
        AnswerDto answerDto = AnswerDtoMapper.AnswerToDto(answerEntityInteractor.createAnswer(answer));
        return ResponseEntity.ok(answerDto);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAnswer(@RequestBody Answer answer){
        answerEntityInteractor.deleteAnswer(answer);
        return ResponseEntity.ok("Answer deleted Successfully");
    }

    @PutMapping
    public ResponseEntity<?> updateAnswer(@RequestBody Answer answer){
        AnswerDto answerDto = AnswerDtoMapper.AnswerToDto(answerEntityInteractor.updateAnswer(answer));
        return ResponseEntity.ok(answerDto);
    }

    @GetMapping("/id")
    public ResponseEntity<?> findByAnswerId(@RequestBody Long id) {
            AnswerDto answerDto = AnswerDtoMapper.AnswerToDto(answerEntityInteractor.findByAnswerId(id));
        return ResponseEntity.ok(answerDto);
    }

    @GetMapping("/post")
    public ResponseEntity<?> findByPost(@RequestBody Pageable pageable, Post post){
        PageResponse<Answer> answers = answerEntityInteractor.findByPost(pageable, post);
        PageResponse<AnswerDto> page = PageResponseConverter.convertPage(answers, AnswerDtoMapper::AnswerToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/date")
    public ResponseEntity<?> findByCreationDateInRange(@RequestBody Pageable pageable, LocalDateTime beginDate,
                                                       LocalDateTime endDate){
        PageResponse<Answer> answers = answerEntityInteractor.findByCreationDateInRange(pageable, beginDate, endDate);
        PageResponse<AnswerDto> page = PageResponseConverter.convertPage(answers, AnswerDtoMapper::AnswerToDto);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/author")
    public ResponseEntity<?> findByAuthor(@RequestBody Pageable pageable, User author){
        PageResponse<Answer> answers = answerEntityInteractor.findByAuthor(pageable, author);
        PageResponse<AnswerDto> page = PageResponseConverter.convertPage(answers, AnswerDtoMapper::AnswerToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/solution")
    public ResponseEntity<?> findByMarkedAsSolutionEqualsTrue(Pageable pageable){
        PageResponse<Answer> answers = answerEntityInteractor.findByMarkedAsSolutionEqualsTrue(pageable);
        PageResponse<AnswerDto> page = PageResponseConverter.convertPage(answers, AnswerDtoMapper::AnswerToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(Pageable pageable){
        PageResponse<Answer> answers = answerEntityInteractor.findAll(pageable);
        PageResponse<AnswerDto> page = PageResponseConverter.convertPage(answers, AnswerDtoMapper::AnswerToDto);
        return ResponseEntity.ok(page);
    }

}
