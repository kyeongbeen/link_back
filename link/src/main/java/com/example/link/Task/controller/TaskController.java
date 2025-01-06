package com.example.link.Task.controller;

import com.example.link.Task.dto.TaskDTO;
import com.example.link.Task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/lists")
    public ResponseEntity<List<TaskDTO>> getLists(@RequestParam int projectId) {
        return new ResponseEntity<>(taskService.getLists(projectId),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.OK);
    }

    @PatchMapping("/lists")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.updateTask(taskDTO), HttpStatus.OK);
    }

    @DeleteMapping("/lists/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        return new ResponseEntity<>(taskService.deleteTask(taskId), HttpStatus.OK);
    }

}
