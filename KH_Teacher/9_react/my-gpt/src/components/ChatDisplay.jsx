import React from 'react'
import styled from 'styled-components'
import { LoadingOutlined } from '@ant-design/icons';
import { Avatar, Space, Card } from 'antd';

const ChatDisplay = ({chatDataList, isLoading}) => {
  return (
    <ChatContainer>
        {
            chatDataList.map((chat, index) => (
                <div key={index}>
                    <Space>
                        <Avatar size={40}>JIWON</Avatar>
                        <Card
                            style={{
                                width:300,
                            }}
                            bodyStyle={{
                                padding: "12px"
                            }}>
                            {chat.question}
                        </Card>
                    </Space>
                    <RqeustArea>
                        <Space>
                            <Card
                                style={{
                                    width:400,
                                }}
                                bodyStyle={{
                                    padding: "12px"
                                }}>
                                {chat.message}
                            </Card>
                            <Avatar 
                                size={40} 
                                src={"https://www.irobotnews.com/news/photo/201803/13262_31414_3740.png"}
                            />
                        </Space>
                    </RqeustArea>
                </div>
            ))
        }
        { isLoading &&
          <div>
            AI 응답 작성중...
            <LoadingOutlined />
          </div>
        }
    </ChatContainer>
  )
}

export default ChatDisplay

const RqeustArea = styled.div`
    float: right;
    text-align: right;
`
const ChatContainer = styled.div`
    display: flex;
    flex-direction: column;
`