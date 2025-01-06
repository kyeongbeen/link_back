package com.example.link.Project.service;

import com.example.link.Project.dto.ProjectCreateDTO;
import com.example.link.Project.dto.ProjectDTO;
import com.example.link.Project.entity.Project;
import com.example.link.Project.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    /** 새로운 프로젝트 생성 */
    public ProjectDTO createProject(String projectName) {
        Project project = new Project().builder()
                .projectName(projectName)
                .build();
        projectRepository.save(project);
        return ProjectDTO.builder().projectId(project.getProjectId()).projectName(project.getProjectName()).build();
    }

    /** 전체 프로젝트 리스트 조회 */
    public List<ProjectDTO> getLists(Integer userId) {
        return null;
    }

    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        Project project = projectRepository.findById(projectDTO.getProjectId()).get();
        project.setProjectName(projectDTO.getProjectName());
        return ProjectDTO.builder().projectId(project.getProjectId()).projectName(project.getProjectName()).build();
    }

    public String deleteProject(int projectId) {
        projectRepository.deleteById(projectId);
        return projectRepository.findById(projectId).isEmpty() ? "프로젝트가 삭제되었습니다." : "프로젝트가 삭제되지 않았습니다.";
    }
}
