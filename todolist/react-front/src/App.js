import React, {Component} from 'react'
import axios from 'axios'

import Header from './components/Header'
import Footer from './components/Footer'
import List from './components/List'

import './App.css';

const baseUrl = '/api/task'

export default class App extends Component {

    state = {
        todoList: []
    }

    async getTodoList() {
        const res = await axios.get(`${baseUrl}/getTaskList`)
        this.setState({
            todoList: res.data.data
        })
    }

    componentDidMount() {
        this.getTodoList()
    }



    // 添加todo
    addTodo = (todoObj) => {
        const name = todoObj.name
        axios.get(`${baseUrl}/addTask?name=`+name).then(res => {
            this.getTodoList()
        })
    }
    // 更新todo
    updataTodo = (id, done) => {
        axios.get(`${baseUrl}/updateTask?id=`+id + '&done=' + done).then(res => {
            this.getTodoList()
        })
    }

    // 删除
    delTodo = (id) => {
        axios.get(`${baseUrl}/deleteTask?id=`+ id).then(res => {
            this.getTodoList()
        })
    }

    // 全选/全不选
    allChecked = (done) => {
        axios.get(`${baseUrl}/setAllDone?done=`+done).then(res => {
            this.getTodoList()
        })
    }


    // 清除所以已经完成的任务
    clearAllDone = () => {
        axios.get(`${baseUrl}/deleteAllDone`).then(res => {
            this.getTodoList()

        })
    }

    render() {
        const {todoList} = this.state
        return (
            <div className="todo-container">
                <div className="todo-wrap">
                    <h2>TODO List</h2>
                    <Header addTodo={this.addTodo}/>
                    <List todoList={todoList} updataTodo={this.updataTodo} delTodo={this.delTodo}/>
                    <Footer todoList={todoList} allChecked={this.allChecked} clearAllDone={this.clearAllDone}/>
                </div>
            </div>
        )
    }
}

