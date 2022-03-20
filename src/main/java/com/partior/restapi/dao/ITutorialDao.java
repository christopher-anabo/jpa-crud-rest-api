package com.partior.restapi.dao;




import com.partior.restapi.dao.entity.Tutorial;

import java.util.List;
import java.util.Optional;

/**
 * @author chris anabo
 *
 * Service interface where business related funcation can
 * be defined
 */
public interface ITutorialDao  {


    /**
     *
     * @param published
     * @return
     */
    List<com.partior.restapi.dao.entity.Tutorial> findByPublished(boolean published);

    List<com.partior.restapi.dao.entity.Tutorial> findAll();

    List<com.partior.restapi.dao.entity.Tutorial> findByTitleContaining(String title);


    Optional<com.partior.restapi.dao.entity.Tutorial> findById(long id);

    Tutorial save(com.partior.restapi.dao.entity.Tutorial tutorial);

    Tutorial update(long id, com.partior.restapi.dao.entity.Tutorial tutorial);

    void deleteById(long id);

    void deleteAll(long id);


}
