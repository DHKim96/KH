import React from 'react'

const styles = {
    nameText: {
        color: "black",
        fontSize: 16,
        fontWeight: 'bold'
    },
    commentText: {
        color: "black",
        fontSize: 16
    },
    image:{
        width: 50,
        height: 50,
        borderRadius: 25,
    },
    wrapper: {
        display: "flex",
        flexDirection: "row",
        border: "1px solid grey",
        borderRadius: 16,
        margin: 8,
        padding: 8
    },
    contentContainer: {
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        marginLeft: 8,
        alignItems: "flex-start"
    }
}

const Comment = (props) => {
  return (
    <div style={styles.wrapper}>
        <div>
            <img 
                src={props.path}
                style={styles.image}
            />
        </div>
        <div style={styles.contentContainer}>
            <span style={styles.nameText}>{props.name}</span>
            <span style={styles.commentText}>{props.comment}</span>
        </div>
    </div>
  )
}

export default Comment