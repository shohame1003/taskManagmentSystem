package com.example.taskmanagementsystem.task;

import com.example.taskmanagementsystem.common.service.GenericDtoMapper;
import com.example.taskmanagementsystem.task.dto.TaskCreateDto;
import com.example.taskmanagementsystem.task.dto.TaskResponseDto;
import com.example.taskmanagementsystem.task.dto.TaskUpdateDto;
import com.example.taskmanagementsystem.task.entity.Task;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapperDto extends GenericDtoMapper<Task, TaskCreateDto, TaskUpdateDto, TaskResponseDto> {
    private final ModelMapper mapper;

    @Override
    public Task toEntity(TaskCreateDto taskCreateDto) {
        return mapper.map(taskCreateDto, Task.class);
    }

    @Override
    public TaskResponseDto toResponseDto(Task task) {
        TaskResponseDto taskResponseDto = mapper.map(task, TaskResponseDto.class);
        taskResponseDto.setAuthorId(task.getAuthor().getId());
        taskResponseDto.setAssigneeId(task.getAuthor().getId());

        return taskResponseDto;
    }

    @Override
    public void update(TaskUpdateDto taskUpdateDto, Task task) {
        mapper.map(taskUpdateDto, task);
    }
}
