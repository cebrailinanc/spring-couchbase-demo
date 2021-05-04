package com.cbrl.couchbase.demo.infra.adapters.rest;

import com.cbrl.couchbase.demo.domain.user.port.incoming.UserPort;
import com.cbrl.couchbase.demo.infra.adapters.rest.model.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UserPort userPort;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody UserCreateRequest request) {
        userPort.create(request.toModel());
        return ResponseEntity.ok().build();
    }
}
