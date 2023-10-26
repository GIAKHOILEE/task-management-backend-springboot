package com.example.taskmanager.DTO.projectDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class projectRequestDTO {
    private Long owner ;
    private String projectName ;
    private String projectDescription ;
    private int level ;
    private Date startDate ;
    private Date endDate ;
    private String status ;

    public projectRequestDTO() {
    }

}
