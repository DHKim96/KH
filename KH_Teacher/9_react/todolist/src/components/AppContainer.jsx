import React from 'react'
import styled from 'styled-components'

const App = styled.div`
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
`
const Container = styled.div`
    width: calc(100% - 24px);
    padding: 24px;
    display: inline-flex;
    flex-direction: column;
    justify-content: center;
`
const Title = styled.h1`
    font-size: 52px;
    font-weight: 900;
    text-align: center;
    margin: 0px;
`

const AppContainer = ({title, children}) => {
  return (
    <App className='App'>
        <Title>{title}</Title>
        <Container>{children}</Container>
    </App>
  )
}

export default AppContainer