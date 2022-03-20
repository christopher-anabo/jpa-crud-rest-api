package com.partior.restapi.controller;


import com.partior.restapi.exception.RecordNotFoundException;
import com.partior.restapi.payload.TutorialDto;
import com.partior.restapi.service.ITutorialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RefreshScope
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/restapi")
public class RestApiController {

    @Autowired
    ITutorialService iTutorialService;

    @Autowired
    private ModelMapper modelMapper;


    @Value("${message:Config Server is not working. Please check...}")
    private String message;



    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialDto>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<TutorialDto> tutorials = new ArrayList<TutorialDto>();

            iTutorialService.getAllTutorials(title).stream().map(

                    post -> modelMapper.map(tutorials, TutorialDto.class)

            ).collect(Collectors.toList());

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/tutorials/{id}")
//    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable("id") long id) {
//        Optional<TutorialDto> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/tutorials")
//    public ResponseEntity<TutorialDto> createTutorial(@RequestBody TutorialDto tutorial) {
//        try {
//            TutorialDto _tutorial = iTutorialService
//                    .save(new TutorialDto(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ExceptionHandler(value = RecordNotFoundException.class)
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<TutorialDto> updateTutorial(@PathVariable("id") long id, @RequestBody TutorialDto tutorial) {
//        Optional<TutorialDto> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            TutorialDto _tutorial = tutorialData.get();
//            _tutorial.setTitle(tutorial.getTitle());
//            _tutorial.setDescription(tutorial.getDescription());
//            _tutorial.setPublished(tutorial.isPublished());
//            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//        try {
//            tutorialRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/tutorials")
//    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//        try {
//            tutorialRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<TutorialDto>> findByPublished() {
//        try {
//            List<TutorialDto> tutorials = tutorialRepository.findByPublished(true);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


    @GetMapping("/echo")
    public ResponseEntity<String> echo() {
        return new ResponseEntity<>("Message from Config Server:" + message, HttpStatus.OK);
    }
}
