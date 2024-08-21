package com.example.taskmanagementsystem.task;

import com.example.taskmanagementsystem.task.dto.TaskCreateDto;
import com.example.taskmanagementsystem.task.dto.TaskPatchDto;
import com.example.taskmanagementsystem.task.dto.TaskResponseDto;
import com.example.taskmanagementsystem.task.dto.TaskUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody @Valid TaskCreateDto taskCreateDto) {
        TaskResponseDto taskResponseDto = taskService.create(taskCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponseDto>> getAllTask(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<TaskResponseDto> all = taskService.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Integer id) {
        TaskResponseDto responseDto = taskService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Integer id, @RequestBody @Valid TaskUpdateDto updateDto) {
        TaskResponseDto responseDto = taskService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDto> patchTask(@PathVariable Integer id, @RequestBody TaskPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        TaskResponseDto responseDto = taskService.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
