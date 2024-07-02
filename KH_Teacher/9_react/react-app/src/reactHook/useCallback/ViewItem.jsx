import React, { useEffect, useState } from 'react'

const ViewItem = ({ getItems }) => {
    const [items, setItems] = useState([])

    useEffect(() => {
        setItems(getItems(5))
        console.log("숫자가 변동되었습니다.")
    }, [getItems])

    return (
        items.map((item, index) => <div key={index}>{item}</div>)
    )
}

export default ViewItem