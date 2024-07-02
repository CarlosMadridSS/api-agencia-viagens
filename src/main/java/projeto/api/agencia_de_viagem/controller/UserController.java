package projeto.api.agencia_de_viagem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.api.agencia_de_viagem.model.AgencyUser;
import projeto.api.agencia_de_viagem.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<AgencyUser> createUser (@RequestBody AgencyUser agencyUser) {
        return new ResponseEntity<>(userService.save(agencyUser), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AgencyUser>> getAllUsers () {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgencyUser> getUserById (@PathVariable Long id) {

        Optional<AgencyUser> user = userService.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new AgencyUser(), HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<AgencyUser> updateUserById (@PathVariable Long id, @RequestBody AgencyUser agencyUser) {
        return new ResponseEntity<>(userService.update(id, agencyUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
