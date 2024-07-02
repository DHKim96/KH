import React from 'react'
import styled from 'styled-components'
import { FaArrowUp } from "react-icons/fa";

const SearchBar = ({searchText, onChangeSearchText, onClickSearchIcon}) => {
  return (
    <SearchBarContainer>
        <SearchInput 
            value={searchText}
            onChange={onChangeSearchText}
            type='text'
            placeholder='궁굼한것을 물어보세요...'
            />
        <UploadIconBox
            search={searchText}
            onClick={onClickSearchIcon}>
            <FaArrowUp 
                style={{
                    color: "white"
                }}/>
        </UploadIconBox>
    </SearchBarContainer>
  )
}

export default SearchBar

const SearchBarContainer = styled.div`
    width: 100%;
    border: 1px solid #cccccc;
    padding: 14px 48px 14px 16px;
    border-radius: 12px;
    height: 52px;
    max-width: calc(100% - 24px);
    margin: 0 auto;
    position: relative;
`

const SearchInput = styled.input`
    border: none;
    outline: none;
    width: 100%;
    height: 100%;
`

const UploadIconBox = styled.div`
    position: absolute;
    top: 10px;
    right: 10px;
    width: 30px;
    height: 30px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 6px;
    background: ${(props)=> props.search ? "black" : "#e5e5e5"};
    cursor: ${(props)=> props.search ? "pointer" : "auto"};
`