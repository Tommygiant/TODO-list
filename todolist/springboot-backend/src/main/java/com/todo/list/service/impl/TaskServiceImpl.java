package com.todo.list.service.impl;

import com.todo.list.common.Result;
import com.todo.list.entity.Task;
import com.todo.list.entity.TaskVo;
import com.todo.list.mapper.TaskMapper;
import com.todo.list.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  service impl
 * </p>
 *
 * @author todo list
 * @since 2023-09-28
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Result addTask(String name) {
        Task task = new Task();
        task.setName(name);
        task.setDone("false");
        task.setCreateTime(LocalDateTime.now());
        taskMapper.insert(task);
        return Result.suc();
    }

    @Override
    public Result updateTask(Integer id, String done) {
        Task task = taskMapper.selectById(id);
        task.setDone(done);
        taskMapper.updateById(task);
        return Result.suc();
    }

    @Override
    public Result deleteTask(Integer id) {
        taskMapper.deleteById(id);

        return Result.suc();
    }

    @Override
    public Result getTaskList() {
        List<Task> tasks = taskMapper.selectList(null);
        List<TaskVo> taskVos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Task task : tasks) {
            TaskVo taskVo = new TaskVo();
            taskVo.setId(task.getId());
            taskVo.setName(task.getName());
            taskVo.setDone(task.getDone().equals("true"));
            taskVo.setDate(task.getCreateTime().format(formatter));
            taskVos.add(taskVo);

        }
        return Result.suc(taskVos);
    }

    @Override
    public Result setAllDone(String done) {
        List<Task> tasks = taskMapper.selectList(null);
        for (Task task : tasks) {
            task.setDone(done);
            taskMapper.updateById(task);
        }
        return Result.suc();
    }

    @Override
    public Result deleteAllDone() {
        List<Task> tasks = taskMapper.selectList(null);
        for (Task task : tasks) {
            if (task.getDone().equals("true")) {
                taskMapper.deleteById(task.getId());
            }
        }
        return Result.suc();
    }
}
