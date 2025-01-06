package com.example.link.Project.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter @Builder
public class ProjectDTO {
    private int projectId;
    private String projectName;
}
