package com.todo.list.mapper;

import com.todo.list.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper
 * </p>
 *
 * @author todo list
 * @since 2023-09-28
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {

}
