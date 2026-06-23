package com.don.notesapp.service;

import com.don.notesapp.entity.Note;
import com.don.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    public Note getNoteById(Long id) {
    return noteRepository.findById(id).orElse(null);
    }

    public Note updateNote(Long id, Note updatedNote) {
    Note existingNote = noteRepository.findById(id).orElse(null);

    if (existingNote == null) {
        return null;
    }

    existingNote.setTitle(updatedNote.getTitle());
    existingNote.setContent(updatedNote.getContent());

    return noteRepository.save(existingNote);
     
}
public void deleteNote(Long id) {
    noteRepository.deleteById(id);
}
}