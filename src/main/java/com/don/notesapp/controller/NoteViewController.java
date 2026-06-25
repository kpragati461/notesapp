package com.don.notesapp.controller;

import com.don.notesapp.entity.Note;
import com.don.notesapp.entity.User;
import com.don.notesapp.service.NoteService;
import com.don.notesapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/my-notes")
public class NoteViewController {

    private final NoteService noteService;
    private final UserService userService;

    public NoteViewController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    // Show all notes for logged-in user
    @GetMapping
    public String showNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }

    // Show create note form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("note", new Note());
        return "create-note";
    }

    // Handle create note form submission
    @PostMapping("/create")
    public String createNote(
            @Valid @ModelAttribute("note") Note note,
            BindingResult result,
            Authentication authentication
    ) {
        // If validation fails, go back to form and show errors
        if (result.hasErrors()) {
            return "create-note";
        }

        String username = authentication.getName();
        User user = userService.findByUsername(username);
        note.setUser(user);

        noteService.createNote(note);
        return "redirect:/my-notes";
    }

    // Show edit note form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "edit-note";
    }

    // Handle edit note form submission
    @PostMapping("/edit/{id}")
    public String updateNote(
            @PathVariable Long id,
            @Valid @ModelAttribute("note") Note note,
            BindingResult result
    ) {
        // If validation fails, go back to form and show errors
        if (result.hasErrors()) {
            return "edit-note";
        }

        Note existing = noteService.getNoteById(id);
        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
        noteService.updateNote(id, existing);
        return "redirect:/my-notes";
    }

    // Delete a note
    @PostMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/my-notes";
    }
}