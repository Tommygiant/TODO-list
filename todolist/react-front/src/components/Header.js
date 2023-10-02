
import React, { Component } from 'react'
import './index.css'

export default class index extends Component {
    // 处理input enter事件
    handleKeyUp = (event) => {
        if(event.keyCode !== 13) return
        if(event.target.value.trim() === ''){
            alert("please enter a task name")
            return
        }
        const todoObj = {
            name:event.target.value,
        }
        this.props.addTodo(todoObj);
        event.target.value = "";
    }
    render() {
        return (
            <div className="todo-header">
                <input type="text" placeholder="Please enter your task name and press Enter to confirm" onKeyUp={this.handleKeyUp}/>
            </div>
        )
    }
}
