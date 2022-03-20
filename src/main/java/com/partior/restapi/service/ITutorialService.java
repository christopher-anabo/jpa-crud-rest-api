package com.partior.restapi.service;

import com.partior.restapi.dao.entity.Tutorial;
import com.partior.restapi.payload.TutorialDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 *
 * Service interface
 *
 * A Service Layer defines an application's boundaryand its set of available operations from the
 * perspective of interfacing client layers.
 * It encapsulates the application's business logic, controlling transactions and coor-dinating responses
 * in the implementation of its operations
 *
 * Business logic implementation
 * Input to dao validation and transformation
 * Encapsulation of different resources
 * Transformation of response
 *
 * Interface names should be nouns, in mixed case with the first letter of each internal word capitalized.
 * Try to keep your Interface names simple and descriptive. Use whole words-avoid acronyms and abbreviations
 * (unless the abbreviation is much more widely used than the long form, such as URL or HTML).
 *
 */
public interface ITutorialService {


    public List<Tutorial> getAllTutorials(String title) ;


    public Tutorial getTutorialById(long id) ;



}
