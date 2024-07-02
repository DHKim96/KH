import React, { useState } from 'react'
import ViewItem from './ViewItem';

const useCallbackTest = () => {
    const [num, setNum] = useState(1)
    const [dark, setDark] = useState(false);

    const getItems = () => {
        return [num, num+1, num+2]
    }

    const theme = {
        backgroundColor: dark ? "#333" : "#fff",
        color: dark ? "#fff" : "#333"
    }

    const onChangeNum = (ev) => {
        setNum(parseInt(ev.target.value));
    }

    return (
        <div style={theme}>
            <input 
                type="number"
                value={num}
                onChange={onChangeNum}
                />
            <button onClick={() => {setDark(!dark)}}>테마 변경</button>
            <ViewItem getItems={getItems} />
        </div>
    )
}

export default useCallbackTest