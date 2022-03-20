package com.partior.restapi.service.impl;


import com.partior.restapi.dao.ITutorialDao;
import com.partior.restapi.dao.entity.Tutorial;
import com.partior.restapi.service.ITutorialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Business Service implementation
 *
 */
@Service
@Slf4j
public class TutorialService implements ITutorialService {

    final ITutorialDao iTutorialDao;

    @Autowired
    public TutorialService( ITutorialDao iTutorialDao) {
        this.iTutorialDao = iTutorialDao;
    }



    @Override
    public List<Tutorial> getAllTutorials(String title) {

        List<Tutorial> tutorials = new ArrayList<>();

        if (title == null) {
           iTutorialDao.findAll().forEach(
                   (t) -> tutorials.add(t)
           );

        } else {
            iTutorialDao.findByTitleContaining(title).forEach(tutorials::add);
        }

        if (tutorials.isEmpty()) {

        }

        return null;
    }

    @Override
    public Tutorial getTutorialById(long id) {
        return null;
    }
}
