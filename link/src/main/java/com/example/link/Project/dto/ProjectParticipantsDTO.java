package com.example.link.Project.dto;

import com.example.link.Project.entity.Project;
import com.example.link.User.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter @Builder
public class ProjectParticipantsDTO {
    private int projectParticipantsId;
    private int userId;
    private int projectId;
    private String enterDate;

}
