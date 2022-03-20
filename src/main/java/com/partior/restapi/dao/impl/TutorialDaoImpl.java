package com.partior.restapi.dao.impl;

import com.partior.restapi.dao.ITutorialDao;
import com.partior.restapi.dao.entity.Tutorial;
import com.partior.restapi.dao.repository.TutorialRepository;
import com.partior.restapi.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TutorialDaoImpl implements ITutorialDao {

    @Autowired
    private TutorialRepository tutorialRepository;


    @Override
    public List<com.partior.restapi.dao.entity.Tutorial> findByPublished(boolean published) {
        return tutorialRepository.findByPublished(published);
    }

    @Override
    public List<com.partior.restapi.dao.entity.Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<com.partior.restapi.dao.entity.Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    @Override
    public Optional<com.partior.restapi.dao.entity.Tutorial> findById(long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Tutorial update(long id, Tutorial tutorial) {
        Optional<com.partior.restapi.dao.entity.Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            com.partior.restapi.dao.entity.Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return tutorialRepository.save(_tutorial);
        } else {
            throw new RecordNotFoundException();
        }
    }




    @Override
    public void deleteById(long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll(long id) {
        tutorialRepository.deleteAll();
    }
}
