package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.adapter;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.AnswerRepositoryPort;
import com.exercises.Foro_HubH2.infrastructure.common.entity.AnswerEntity;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.AnswerEntityMapper;
import com.exercises.Foro_HubH2.infrastructure.exceptions.ResourceNotFoundException;
import com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository.AnswerMongodbRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnswerRepositoryAdapter implements AnswerRepositoryPort {

    private final AnswerMongodbRepository answerRepository;

    @Override
    public Answer create(Answer answer) {
            log.info("Mapping answer to entity");
            AnswerEntity answer1 = AnswerEntityMapper.fromAnswerToEntity(answer);
            log.warn("Saving answer");
            answerRepository.save(answer1);
            log.info("Answer saved");
            return answer;
    }

    @Override
    public void delete(Answer answer) {
            log.info("Deleting answer");
            AnswerEntity answer1 = AnswerEntityMapper.fromAnswerToEntity(answer);
            answerRepository.delete(answer1);
    }

    @Override
    public Answer update(Answer answer) {

            AnswerEntity answer1 =
                    answerRepository.findById(answer.getAnswerId()).orElseThrow(() ->
                            new ResourceNotFoundException("Answer not found, id: " + answer.getAnswerId()));
            Optional.ofNullable(answer.getMessage())
                    .ifPresent(answer1::setMessage);
            Optional.ofNullable(answer.getMarkedAsSolution())
                    .ifPresent(answer1::setMarkedAsSolution);

            answerRepository.save(answer1);
            return AnswerEntityMapper.fromEntityToAnswer(answer1);
    }

    @Override
    public Answer findByAnswerId(Long id) {
        return  AnswerEntityMapper.fromEntityToAnswer(answerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Answer not " +
                        "found, id: "+id)));
    }

    @Override
    public PageResponse<Answer> findByPost(Post post, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnswerEntity> page1 = answerRepository.findByPost(post.getPostId(), pageable);
        return new PageResponse<>(page1.getContent().stream()
                .map(AnswerEntityMapper::fromEntityToAnswer)
                .collect(Collectors.toList()), page1.getNumber(), page1.getSize(),
                page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Answer> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnswerEntity> page1 = answerRepository.findByCreationDateInRange(beginDate, endDate, pageable);
        return new PageResponse<>(page1.getContent().stream()
                .map(AnswerEntityMapper::fromEntityToAnswer)
                .collect(Collectors.toList()), page1.getNumber(), page1.getSize(),
                page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Answer> findByAuthor(User author, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnswerEntity> page1 = answerRepository.findByAuthor(author, pageable);
        return new PageResponse<>(page1.getContent().stream()
                .map(AnswerEntityMapper::fromEntityToAnswer)
                .collect(Collectors.toList()), page1.getNumber(), page1.getSize(),
                page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Answer> findByMarkedAsSolutionEqualsTrue(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnswerEntity> page1 = answerRepository.findByMarkedAsSolutionTrue(pageable);
        return new PageResponse<>(page1.getContent().stream()
                .map(AnswerEntityMapper::fromEntityToAnswer)
                .collect(Collectors.toList()), page1.getNumber(), page1.getSize(),
                page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Answer> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnswerEntity> page1 = answerRepository.findAll(pageable);
        return new PageResponse<>(page1.getContent().stream()
                .map(AnswerEntityMapper::fromEntityToAnswer)
                .collect(Collectors.toList()), page1.getNumber(), page1.getSize(),
                page1.getTotalElements(), page1.getTotalPages());
    }
}
