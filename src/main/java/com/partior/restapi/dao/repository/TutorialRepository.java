package com.partior.restapi.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface TutorialRepository extends JpaRepository<com.partior.restapi.dao.entity.Tutorial, Long> {
	List<com.partior.restapi.dao.entity.Tutorial> findByPublished(boolean published);
	List<com.partior.restapi.dao.entity.Tutorial> findByTitleContaining(String title);
}
