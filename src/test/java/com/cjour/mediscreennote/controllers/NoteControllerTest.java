package com.cjour.mediscreennote.controllers;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = NoteController.class)
public class NoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    private List<Note> listOfNote;

    private static Note note;

    @Test
    public void should_return_welcome_ok() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void should_return_notes_ok() throws Exception {
        Mockito.when(noteService.findAll()).thenReturn(listOfNote);
        mockMvc.perform(get("/notes")).andExpect(status().isOk());
    }

    @Test
    public void should_return_patientNote_ok() throws Exception {
        Mockito.when(noteService.findNotesById(anyInt())).thenReturn(listOfNote);
        mockMvc.perform(get("/patientNote/{id}", "1")).andExpect(status().isOk());
    }

    @Test
    public void should_return_patientNoteadd_ok() throws Exception {
        Note note = new Note();
        String noteAsJson = new ObjectMapper().writeValueAsString(note);
        Mockito.when(noteService.create(new Note())).thenReturn(note);
        mockMvc.perform(post("/patientNote/add").contentType(MediaType.APPLICATION_JSON)
                .content(noteAsJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_patientNoteUpdate_created() throws Exception {
        Note note = new Note("1", 1, "test");
        String noteAsJson = new ObjectMapper().writeValueAsString(note);
        Mockito.when(noteService.update("1", new Note())).thenReturn(note);
        mockMvc.perform(put("/patientNote/update/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(noteAsJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_no_content() throws Exception {

        mockMvc.perform(delete("/patientNote/delete/{id}", 1)).andExpect(status().isNoContent());
    }
}
