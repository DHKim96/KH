import React, { useState } from 'react'
import { FaPlus } from "react-icons/fa6";
import styled from 'styled-components';

const InsertContainer = styled.div`
    width: 100%;
    padding-bottom: 24px;
    display: inline-flex;
    justify-content: center;
`

const InsertInput = styled.input`
    min-width: 250px;
    height: 40px;
    padding: 6px 12px;
    border-radius: 50px 0px 0px 50px;
    border: none;
    background-color: #f4f4f4;
    outline: none;
`

const InsertBtn = styled.button`
    width: 40px;
    height: 40px;
    border: none;
    cursor: pointer;
    border-radius: 0px 50px 50px 0px;
`

const TodoInsert = ({onInsert}) => {
    const [todoTitle, setTodoTitle] = useState("");
    
    const onChangeTitle = (ev) => {
        setTodoTitle(ev.target.value);
    }

    const onSubmit = (ev) => {
        onInsert(todoTitle);
        setTodoTitle("") // value초기화
    }

    return (
        <InsertContainer>
            <InsertInput 
                value={todoTitle}     
                placeholder='할일 입력'
                onChange={onChangeTitle}/>
            <InsertBtn onClick={onSubmit}>
                <FaPlus/>
            </InsertBtn>
        </InsertContainer>
    )
}

export default TodoInsert