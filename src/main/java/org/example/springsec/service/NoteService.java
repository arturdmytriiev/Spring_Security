package org.example.springsec.service;

import org.example.springsec.model.Note;
import org.example.springsec.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class NoteService {
    @Autowired
private final NoteRepository noteRepository;

public List<Note> listAll() {
    List<Note> noteList = noteRepository.findAll();
    return noteList;
}

public Note add (Note note) {
    noteRepository.save(note);
    return note;
}

public void deleteById(Long id) {
    if(noteRepository.existsById(id)) {
        noteRepository.deleteById(id);
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}

public void update(Note note) {
    if(noteRepository.existsById(note.getId())) {
        noteRepository.save(note);
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}

public Note getById(Long id) {
    if(noteRepository.existsById(id)) {
        Object note = noteRepository.findById(id).get();
        return (Note) note;
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}
}
