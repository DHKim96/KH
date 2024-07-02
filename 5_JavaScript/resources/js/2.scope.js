/**
 * Scope
 */

var number1 = 20;

function test1(){
    console.log(number1);
}

// test1();

function test2(){
    var number1 = 40;
    console.log(number1);
}

// test2();

var number1 = 20;

function test3(){
    var number1 = 40;
    test4();
    console.log("number1 : " + number1);
}

function test4(){
    var number2 = 11;
    console.log("number2 : " + number1);
    console.log("number1 : " + number1);
}

test3();
console.log(number1);


/**
 * JS => Lexical Scope
 *  : 선언된 위치가 상위 스코프 결정
 * 
 * Dynamic Scope
 *  : 실행한 위치가 상위 스코프 결정
 */

let i = 1000;
for(let i = 0; i < 10; i++){ // 저장 영역이 달라서 가능
    console.log(i);
}
console.log("i = " + i);



