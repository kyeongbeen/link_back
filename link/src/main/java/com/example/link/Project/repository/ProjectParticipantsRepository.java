package com.example.link.Project.repository;

import com.example.link.Project.entity.ProjectParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectParticipantsRepository extends JpaRepository<ProjectParticipants, Integer> {
}
