import React from 'react'

const Toolbar = (props) => {
    const { isLoggin, onClickLogin, onClickLogout } = props;

    return (
        <div>
            {isLoggin && <div style={{ padding: 24 }}>안녕하세요 최지원님</div>}
            {isLoggin ?
                <button onClick={onClickLogout}>로그아웃</button> : 
                <button onClick={onClickLogin}>로그인</button>
            }
        </div>
    )
}

export default Toolbar