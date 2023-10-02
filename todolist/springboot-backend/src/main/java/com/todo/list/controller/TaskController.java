package com.todo.list.controller;


import com.todo.list.common.Result;
import com.todo.list.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  front controller
 * </p>
 *
 * @author todo list
 * @since 2023-09-28
 */
@RestController
@Slf4j
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/addTask")
    @Transactional
    public Result addTask(String name) {
        return taskService.addTask(name);
    }

    @RequestMapping("/updateTask")
    @Transactional
    public Result updateTask(Integer id, String done) {

        log.info("id: {}, done: {}", id, done);
        return taskService.updateTask(id, done);
    }

    @RequestMapping("/deleteTask")
    @Transactional
    public Result deleteTask(Integer id) {
        return taskService.deleteTask(id);
    }

    @RequestMapping("/getTaskList")
    public Result getTaskList() {
        return taskService.getTaskList();
    }

    @RequestMapping("/setAllDone")
    @Transactional
    public Result setAllDone(String done) {

        return taskService.setAllDone(done);
    }

    @RequestMapping("/deleteAllDone")
    @Transactional
    public Result deleteAllDone() {
        return taskService.deleteAllDone();
    }
}
