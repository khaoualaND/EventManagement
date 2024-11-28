package event.registration_service.service;

import event.registration_service.model.Registration;
import event.registration_service.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public List<Registration> getRegistrationsByUser(Long userId) {
        return registrationRepository.findByUserId(userId);
    }

    public List<Registration> getRegistrationsByEvent(Long eventId) {
        return registrationRepository.findByEventId(eventId);
    }

    public void cancelRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}

