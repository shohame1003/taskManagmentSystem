package com.example.taskmanagementsystem.task;

import com.example.taskmanagementsystem.common.repository.GenericSpecificationRepository;
import com.example.taskmanagementsystem.task.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends GenericSpecificationRepository<Task,Integer> {
}
