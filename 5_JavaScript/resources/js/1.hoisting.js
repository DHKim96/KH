let i = 10;
console.log(i);

/**
 * Hoisting
 *  : 
 */

console.log(name);
var name = "jiwon";
console.log(name);

/**
 * Hoisting은 뭘까?
 *  : 모든 변수 선언문이 코드의 최상단으로 이동되는 것처럼 느껴지는 현상
 * 
 * let, const
 */

console.log(name);
let name = "jiwon"; // tdz(Temporal Dead Zone) 이라는 사각지대를 만들어 넣음