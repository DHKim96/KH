import React, { Component } from 'react'
const styles = {
  wrapper:{
    display: "flex",
    flexDirection: "row",
    border: "1px solid grey",
    borderRadius: 16,
    margin: 8,
    padding: 8
  },
  commentText: {
    color: "black",
    fontSize: 18
  },
}

class Comment extends Component {
  constructor(props){
    super(props)

    // class Component에서는 state라는 json형식의 map을 통해
    // 필드를 만들어 줄 수 있다.
    this.state = {};
  }

  componentDidMount(){
    console.log(`${this.props.id}의 componentDidMount`)
  }

  componentDidUpdate(){
    console.log(`${this.props.id}의 componentDidUpdate`)
  }

  componentWillUnmount(){
    console.log(`${this.props.id}의 componentWillUnmount`)
  }

  render() {
    return (
      <div style={styles.wrapper}>
        <span style={styles.commentText}>
          {this.props.message}
        </span>
      </div>
    )
  }
}


export default Comment
