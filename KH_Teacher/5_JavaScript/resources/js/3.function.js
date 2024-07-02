function test(){
    console.log("test함수 실행")
}

test();

const test2 = function(){
    console.log(arguments)
    console.log("test2함수 실행")
}

test2("num1", 20);

/**
 * Arrow함수
 */


const arrow1 = () => {
    console.log(this)
}

arrow1();