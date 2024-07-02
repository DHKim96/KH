/**
 * Hoisting
 */

console.log(name1); // name
var name1 = "jiwon";
console.log(name1);

/**
 * 
 * Hoisting은 뭘까?
 * 
 * 모든 변수 선언문이 코드의 최상단으로 이동되는 것처럼 느껴지는 현상
 * let, const
 */

console.log(name2);
let name2 = "jiwon";