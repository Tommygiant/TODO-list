package com.todo.list.entity;

import lombok.Data;
/**
 * <p>
 *  task vo
 * </p>
 *
 * @author todo list
 * @since 2023-09-28
 */
@Data
public class TaskVo {
    private Integer id;
    private String name;
    private boolean done;
    private String date;
}
