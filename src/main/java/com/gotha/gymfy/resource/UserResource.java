package com.gotha.gymfy.resource;

import com.gotha.gymfy.entity.User;
import com.gotha.gymfy.exception.GymfyBusinessException;
import com.gotha.gymfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity store(@RequestBody final User userBody) {

        try {
            this.userService.store(userBody);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (final GymfyBusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
