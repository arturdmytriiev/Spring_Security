package org.example.springsec.repository;

import org.example.springsec.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NoteRepository extends JpaRepository<Note, Long> {
}
