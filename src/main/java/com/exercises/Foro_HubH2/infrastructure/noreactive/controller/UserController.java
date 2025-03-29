package com.exercises.Foro_HubH2.infrastructure.noreactive.controller;

import com.exercises.Foro_HubH2.application.usecase.IUserEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.UserDto;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.PageResponseConverter;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserEntityInteractor userEntityInteractor;

    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        UserDto user = UserDtoMapper.UserToDto(userEntityInteractor.findById(id));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        UserDto userDto = UserDtoMapper.UserToDto(userEntityInteractor.createUser(user));
        return ResponseEntity.ok(userDto);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        UserDto userDto = UserDtoMapper.UserToDto(userEntityInteractor.updateUser(user));
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user) {
        userEntityInteractor.deleteUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        UserDto user = UserDtoMapper.UserToDto(userEntityInteractor.findByEmail(email));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(Pageable pageable) {
        PageResponse<User> users = userEntityInteractor.findAll(pageable);
        PageResponse<UserDto> newUsers = PageResponseConverter.convertPage(users, UserDtoMapper::UserToDto);
        return ResponseEntity.ok(newUsers);
    }

    @GetMapping("/name")
    public ResponseEntity<?> findByNameContainsIgnoreCase(@RequestParam Pageable pageable, String name) {
        PageResponse<User> users = userEntityInteractor.findByNameContainsIgnoreCase(pageable, name);
        PageResponse<UserDto> newUsers = PageResponseConverter.convertPage(users, UserDtoMapper::UserToDto);
            return ResponseEntity.ok(newUsers);
    }

}
