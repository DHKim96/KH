import React, {useState} from 'react'
import Toolbar from './Toolbar'

const LandingPage = () => {
    const [isLoggin, setIsLoggin] = useState(false);

    const onClickLogin = () => {
        setIsLoggin(true)
    }

    const onClickLogout = () => {
        setIsLoggin(false)
    }
    
  return (
    <div>
        <Toolbar 
            isLoggin = {isLoggin}
            onClickLogin = {onClickLogin}
            onClickLogout = {onClickLogout}
       />
        <div style={{ padding: 24 }}>KH 정보교육원</div>
    </div>
  )
}

export default LandingPage