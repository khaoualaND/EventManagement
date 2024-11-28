package event.registration_service.controller;

import event.registration_service.model.Registration;
import event.registration_service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<Registration> registerUser(@RequestBody Registration registration) {
        return ResponseEntity.ok(registrationService.saveRegistration(registration));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Registration>> getRegistrationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByUser(userId));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Registration>> getRegistrationsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByEvent(eventId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelRegistration(@PathVariable Long id) {
        registrationService.cancelRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
