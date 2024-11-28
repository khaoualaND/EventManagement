package event.event_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Timestamp date;
    private String venue;
    private Long organizerId; // Organizer user ID from User Service


}

