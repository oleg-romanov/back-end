package itis.eventmaker.repositories;

import itis.eventmaker.model.Category;
import itis.eventmaker.model.Event;
import itis.eventmaker.model.EventType;
import itis.eventmaker.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.name = ?1 and e.user = ?2")
    // @Query("select event from Event event inner join event.id")
    Optional<Event> findByNameAndUserId (String name, User user);
    List<Event> findAllByUserId(long id);
    List<Event> findAllByCategory(Category category);
    List<Event> findAllByEventType(EventType eventType);
    Optional<Event> findByIdAndUserId(long id, Long userId);

    @Query("select service from Event service where (:q = 'empty' or UPPER(service.name) like UPPER(concat('%', :q, '%'))) ")
    Page<Event> search(@Param("q") String q, Pageable pageable);

}