package com.don.notesapp.service;

import com.don.notesapp.entity.Note;
import com.don.notesapp.entity.User;
import com.don.notesapp.exception.NoteNotFoundException;
import com.don.notesapp.repository.NoteRepository;
import com.don.notesapp.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Note createNote(Note note) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        note.setUser(user);
        return noteRepository.save(note);
    }

    // ← now sorted by newest first
    public List<Note> getAllNotes() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        return noteRepository.findByUser(user,
                Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    // ← new search method
    public List<Note> searchNotes(String keyword) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        return noteRepository.findByUserAndTitleContainingIgnoreCase(
                user, keyword, Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());
        return noteRepository.save(existingNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}