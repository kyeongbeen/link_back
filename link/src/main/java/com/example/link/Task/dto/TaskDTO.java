package com.example.link.Task.dto;

import com.example.link.Project.entity.Project;
import com.example.link.Task.TaskPriority;
import com.example.link.Task.TaskStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter @Builder
public class TaskDTO {
    private int taskId;
    private int assignedUser;
    private String title;
    private String content;
    private String deadline;
    private TaskPriority taskPriority;
    private TaskStatus status;
    private int projectId;
}
