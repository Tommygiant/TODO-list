package com.todo.list.service;

import com.todo.list.common.Result;
import com.todo.list.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  service
 * </p>
 *
 * @author todo list
 * @since 2023-09-28
 */
public interface TaskService extends IService<Task> {
    Result addTask(String name);

    Result updateTask(Integer id, String done);

    Result deleteTask(Integer id);

    Result getTaskList();

    Result setAllDone(String done);

    Result deleteAllDone();
}
