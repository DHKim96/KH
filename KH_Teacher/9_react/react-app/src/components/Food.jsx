import React from 'react'

// JSX : 리액트에서 사용하는 기본적인 문법체계
//       자바스크립트와 HTML을 함께 사용한다.
//       HTML을 사용하던 중 스크립트를 사용하고 싶을 때는 {}를 통해서 사용하면 된다.

// Component : 하나의 함수형 컴포넌트는 무조건 적으로 하나의 태그를 리턴한다.
//             재사용할 수 있는 가장 작은 단위의 Eelement

//props : 부모컴포넌트에서 자식컴포넌트에 데이터를 전달하는 방식
//        컴포넌트의 속성=값으로 전달할 수 있다.
//        props변하면 자식요소는 리랜더링을 한다.
const Food = (props) => {
  return (
    <div>
        <h1>이 음식의 이름은 {props.name}</h1>
        <h1>이 음식은 1인분에 {props.price}원 입니다.</h1>
    </div>
  )
}

export default Food