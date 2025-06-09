package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Confirmation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends CrudRepository<Confirmation, Integer> {
}
