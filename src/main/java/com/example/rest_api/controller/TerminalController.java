package com.example.rest_api.controller;

import com.example.rest_api.dto.TerminalDTO;
import com.example.rest_api.exception.BadRequestException;
import com.example.rest_api.exception.CustomNoContentException;
import com.example.rest_api.exception.CustomNotFoundException;
import com.example.rest_api.exception.JsonValidationException;
import com.example.rest_api.model.Terminal;
import com.example.rest_api.service.TerminalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/terminal")
public class TerminalController {

   @Autowired
   private TerminalService terminalService;

    @GetMapping
    public ResponseEntity<List<Terminal>> getAll () throws CustomNoContentException {
        return terminalService.getAll();
    }

    @GetMapping("/{logic}")
    public ResponseEntity<Terminal> getTerminal (@PathVariable("logic") int logic) throws CustomNotFoundException, BadRequestException {
        return terminalService.getTerminal(logic);
    }

    @PostMapping
    public ResponseEntity<Terminal> createTerminal(@RequestBody TerminalDTO terminalDTO) throws JsonValidationException, JsonProcessingException {
            return terminalService.createTerminal(terminalDTO);
        }

    @PutMapping("/{logic}")
    public ResponseEntity<Terminal> updateTerminal (@PathVariable("logic") int logic, @RequestBody TerminalDTO updateDTO) throws CustomNotFoundException, BadRequestException {
        return terminalService.updateTerminal(logic, updateDTO);
    }

    @DeleteMapping("/{logic}")
    public ResponseEntity<String> deleteTerminal (@PathVariable("logic") int logic) throws CustomNotFoundException, BadRequestException {
       return terminalService.deleteTerminal(logic);
    }
}
