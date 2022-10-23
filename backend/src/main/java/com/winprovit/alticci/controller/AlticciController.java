package com.winprovit.alticci.controller;

import com.winprovit.alticci.service.AlticciService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/alticci")
public class AlticciController {

    @Autowired
    AlticciService alticciService;

    @ApiOperation(value = "Retrieve sequence Alticci by Indice 'n'")
    @GetMapping(path = "/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> get(@PathVariable(name = "n") Long indice) {
        return ResponseEntity.ok(alticciService.sequence(indice));
    }
}
