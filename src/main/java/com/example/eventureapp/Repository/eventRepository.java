package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<Event, Long> {

}
