import React from 'react'
import Food from './Food'

const Menu = () => {
  return (
    <div id='menu'>
      <Food name={"짜장면"} price={7000} />
      <Food name={"햄버거"} price={3500} />
      <Food name={"김밥"} price={3000} />
    </div>
  )
}

export default Menu