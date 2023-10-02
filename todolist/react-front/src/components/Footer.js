
import React, { Component } from 'react'

import './index.css'

export default class index extends Component {

    // 全选/全不选
    handleChange = (event) => {
        this.props.allChecked(event.target.checked)
    }
    handleClick = () => {
        this.props.clearAllDone()
    }

    render() {
        const {todoList} = this.props;
        const doneCount = todoList.reduce((pre,todo)=> pre + (todo.done ? 1 : 0),0);
        const allCount = todoList.length;
        return (
            <div className="todo-footer">
                <label>
                    <input type="checkbox" onChange={this.handleChange} checked={ doneCount === allCount && allCount !== 0 ? true : false }/>
                </label>
                <span>
                    <span>done {doneCount}</span> / all {allCount}
                </span>
                <button className="btn btn-danger" onClick={this.handleClick}>Clear Completed Tasks</button>
            </div>
        )
    }
}

