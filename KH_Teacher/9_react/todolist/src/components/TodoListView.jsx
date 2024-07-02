import React from 'react'
import styled from 'styled-components'
import { FaXmark } from "react-icons/fa6";

const ListContainer = styled.ul`
    width: 100%;
    margin: 12px 0px;
    padding: 0px 30px;
`

const TodoRow = styled.li`
    height: 34px;
    background: #f4f4f4;
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    cursor: pointer;
`

const DoneRow = styled(TodoRow)`
    text-decoration: line-through;
`

const RemoveBtn = styled.button`
    cursor: pointer;
    width: 34px;
    height: 34px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    position: absolute;
    right: 0px;
    background-color: rgb(192, 226, 255);
    border: none;
`

const TodoListView = ({todos, onRemove, onToggle}) => {

    return (
        <ListContainer>
            {
                todos.map(todo => 
                        todo.isDone ? 
                        <DoneRow 
                            key={todo.id}
                            onClick={() => onToggle(todo.id)}
                            >
                            {todo.title}
                            <RemoveBtn onClick={(ev) => {
                                                        ev.stopPropagation() // 이벤트 확산방지
                                                        //ev.preventDefault()// 고유동작 방지
                                                        onRemove(todo.id)
                                                    }
                                                }>
                                <FaXmark/>
                            </RemoveBtn>
                        </DoneRow> :
                        <TodoRow 
                            key={todo.id}
                            onClick={() => onToggle(todo.id)}
                            >
                            {todo.title}
                            <RemoveBtn onClick={(ev) => {
                                                        ev.stopPropagation() // 이벤트 확산방지
                                                        //ev.preventDefault()// 고유동작 방지
                                                        onRemove(todo.id)
                                                    }
                                                }>
                                <FaXmark/>
                            </RemoveBtn>
                        </TodoRow>
                        
                    )
            }
        </ListContainer>
    )
}

export default TodoListView