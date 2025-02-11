package com.salesianos.triana.security_clase_prueba_V2.note.repository;

import com.salesianos.triana.security_clase_prueba_V2.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByAuthor(String author);

}