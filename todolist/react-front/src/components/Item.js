
import React, { Component } from 'react'

import './index.css'

export default class index extends Component {
    // 处理鼠标的移入移出事件 
    state = {
        mouse:false
    }

    handleMouse = (mouse) => {
        return ()=>{
            this.setState({
                mouse:mouse
            })
        }
    }
    // 更新todo状态
    handleChecked = (id) => {
        return (event) => {
            let done = event.target.checked + '';
            this.props.updataTodo(id,done);
        }
    }
    handleDel = (id) => {
        return () => {
            this.props.delTodo(id);
        }
    }

    render() {
        const {name,id,done,date} = this.props
        const {mouse} = this.state
        return (
            <li onMouseLeave={this.handleMouse(false)} onMouseEnter={this.handleMouse(true)} style={{ background : mouse ? '#ddd' : 'white'}}>
                <label>
                    <input type="checkbox" checked={done} onChange={this.handleChecked(id)}/>
                    <span>{name}</span>
                    <span className="date">{date}</span>
                </label>
                <button className="btn btn-danger" style={{display: mouse ? 'block' : 'none'}} onClick={this.handleDel(id)}>delete</button>
            </li>
        )
    }
}
