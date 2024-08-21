package com.example.taskmanagementsystem.task;

import com.example.taskmanagementsystem.common.service.GenericCrudService;
import com.example.taskmanagementsystem.task.dto.TaskCreateDto;
import com.example.taskmanagementsystem.task.dto.TaskPatchDto;
import com.example.taskmanagementsystem.task.dto.TaskResponseDto;
import com.example.taskmanagementsystem.task.dto.TaskUpdateDto;
import com.example.taskmanagementsystem.task.entity.Task;
import com.example.taskmanagementsystem.user.UserRepository;
import com.example.taskmanagementsystem.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Getter
@RequiredArgsConstructor
public class TaskService extends GenericCrudService<Task, Integer, TaskCreateDto, TaskUpdateDto,
        TaskPatchDto, TaskResponseDto> {

    private final TaskRepository repository;
    private final TaskMapperDto mapper;
    private final Class<Task> EntityClass = Task.class;
    private final UserRepository userRepository;

    @Override
    protected Task save(TaskCreateDto taskCreateDto) {

        User user = userRepository.findById(taskCreateDto.getAuthorId()).orElseThrow(EntityNotFoundException::new);

        Task task = mapper.toEntity(taskCreateDto);

        task.setAuthor(user);
        task.setAssignee(user);

        return repository.save(task);
    }

    @Override
    protected Task updateEntity(TaskUpdateDto taskUpdateDto, Task task) {
        mapper.update(taskUpdateDto, task);
        return repository.save(task);
    }
}
