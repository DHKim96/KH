import logo from './logo.svg';
import { useEffect, useState } from 'react';
import './App.css';
import styled from 'styled-components';
import { DescriptText, Title } from './components/CommonsStyles';
import SearchBar from './components/SearchBar';
import { CallGpt } from './service/gpt';
import ChatDisplay from './components/ChatDisplay';

function App() {
  //프롬프트창에 입력되는 text데이터
  const [searchText, setSearchText] = useState('');
  const [chatDataList, setChatDataList] = useState(localStorage.getItem("chatList") ? 
                                                    JSON.parse(localStorage.getItem("chatList")) : []);

  const [isLoading, setIsLoading] = useState(false);

  const handleChangeSearchText = (ev) => {
    setSearchText(ev.target.value)
  }

  const handleClickSearchIcon = async () => {
    const chatData = {
      date : new Date(),
      question: searchText
    }
    
    try{
      setIsLoading(true);
      const message = await CallGpt({
        prompt : searchText
      })

      chatData.message = message;

      setChatDataList([
        ...chatDataList,
        chatData
      ])
 
    } catch(error){
      console.log(error)
    } finally{
      setIsLoading(false);
    }
  }

  //chatDataList의 값이 변경되면 localStorage에 저장해줘
  useEffect(() => {
    //localStorage에 저장할 수 있는 양식은 오직 string
    localStorage.setItem("chatList", JSON.stringify(chatDataList));
  },[chatDataList])

  return (
    <AppContainer>
      <Header>
        <Title>나만의 GPT</Title>
      </Header>
      <Contents>
        <ChatDisplay 
          chatDataList = {chatDataList}
          isLoading = {isLoading}
        />
      </Contents>
      <Footer>
        <SearchBar 
          searchText = {searchText}
          onChangeSearchText = {handleChangeSearchText}
          onClickSearchIcon = {handleClickSearchIcon}
        />
        <DescriptText>
          ChatGPT can make mistakes. Consider checking important information.
        </DescriptText>
      </Footer>
    </AppContainer>
  );
}

export default App;

const AppContainer = styled.div`
  display: flex;
  flex-direction: column;
  height: 100vh;
  width: 100%;
  max-width: 720px;
  margin: 0 auto;
`

const Header = styled.div`
  padding: 8px;
  height: 56px;
  width: 100%;
  position: absolute;
  left: 0px;
  top: 0px;
  background: white;
  opacity: 0.6;
`

const Contents = styled.div`
  padding: 60px 0 0 0;
  flex: 1;
  overflow-y: scroll;
  &::-webkit-scrollbar{
    display: none;
  }
`

const Footer = styled.div`
  height: 86px;
  display: flex;
  flex-direction: column;
`