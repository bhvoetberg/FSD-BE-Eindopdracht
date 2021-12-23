package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getPlanning() {
        return ResponseEntity.ok(planningService.getPlanning());
    }

//    @GetMapping(value = "/{username}")
//    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
//        return ResponseEntity.ok().body(userService.getUser(username));
//    }
//
//    @PostMapping(value = "")
//    public ResponseEntity<Object> createUser(@RequestBody UserPostRequest userPostRequest) {
//
//        String newUsername = userService.createUser(userPostRequest);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
//                .buildAndExpand(newUsername).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @PutMapping(value = "/{username}")
//    public ResponseEntity<Object> updateKlant(@PathVariable("username") String username, @RequestBody User user) {
//        userService.updateUser(username, user);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping(value = "/{username}")
//    public ResponseEntity<Object> deleteKlant(@PathVariable("username") String username) {
//        userService.deleteUser(username);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping(value = "/{username}/authorities")
//    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
//        return ResponseEntity.ok().body(userService.getAuthorities(username));
//    }
//
//    @PostMapping(value = "/{username}/authorities")
//    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
//        try {
//            String authorityName = (String) fields.get("authority");
//            userService.addAuthority(username, authorityName);
//            return ResponseEntity.noContent().build();
//        } catch (Exception ex) {
//            throw new BadRequestException();
//        }
//    }
//
//    @DeleteMapping(value = "/{username}/authorities/{authority}")
//    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
//        userService.removeAuthority(username, authority);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping(value = "/{username}/password")
//    public ResponseEntity<Object> setPassword(@PathVariable("username") String username, @RequestBody String password) {
//        userService.setPassword(username, password);
//        return ResponseEntity.noContent().build();
//    }
//
//}

}
