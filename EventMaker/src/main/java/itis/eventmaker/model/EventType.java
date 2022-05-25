package itis.eventmaker.model;

import itis.eventmaker.dto.in.EventTypeDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_types")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "eventType")
    private List<Event> events;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
