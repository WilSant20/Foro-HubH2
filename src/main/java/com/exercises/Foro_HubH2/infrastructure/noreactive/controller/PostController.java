package com.exercises.Foro_HubH2.infrastructure.noreactive.controller;

import com.exercises.Foro_HubH2.application.usecase.IPostEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.PostDto;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.PageResponseConverter;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.PostDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private IPostEntityInteractor iPostEntityInteractor;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        PostDto dto = PostDtoMapper.postToDto(iPostEntityInteractor.createPost(post));
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        PostDto dto = PostDtoMapper.postToDto(iPostEntityInteractor.updatePost(post));
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePost(@RequestBody Post post) {
        iPostEntityInteractor.deletePost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<?> getPostById(@RequestBody Long id) {
        PostDto dto = PostDtoMapper.postToDto(iPostEntityInteractor.findByPostId(id));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/tags")
    public ResponseEntity<?> getPostByTags(@RequestBody Tag tag, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByTags(tag, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/author")
    public ResponseEntity<?> getPostByAuthor(@RequestBody User user, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByAuthor(user, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/solved")
    public ResponseEntity<?> getPostByIsSolved(@RequestParam Boolean bol, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByIsSolved(bol, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/range")
    public ResponseEntity<?> getPostByCreationDate(@RequestParam LocalDateTime begin, LocalDateTime end, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByCreationDateInRange(begin, end, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/title")
    public ResponseEntity<?> getPostByTitle(@RequestParam String title, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByTitleContainsIgnoreCase(title, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/message")
    public ResponseEntity<?> getPostByMessage(@RequestParam String message, Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findByMessageContainsIgnoreCase(message, pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPost(@RequestParam Pageable pageable) {
        PageResponse<Post> postPageResponse = iPostEntityInteractor.findAll(pageable);
        PageResponse<PostDto> page = PageResponseConverter.convertPage(postPageResponse, PostDtoMapper::postToDto);
        return ResponseEntity.ok(page);
    }

}
