let members = [
    '최지원',
    '김지원',
    '이지원',
    '박지원',
    '남궁지원'
]

//push
console.log(members.push('신지원'));
console.log(members)

//splice()
console.log(members.splice(0,3));

//concat
console.log(members.concat("지지원"));
console.log(members);

members = [
    '최지원',
    '김지원',
    '이지원',
    '박지원',
    '남궁지원'
]

let members2 = [
    ...members
]

console.log(members2)

console.log("---------------------------------------------")

let memberInfo = {
    name: "지원",
    age: 47,
    gender : 'M'
}

let memberInfo2 = {
    ...memberInfo,
    age : 12
}

console.log(memberInfo2)

console.log("-----------------------------------------")

//join()
console.log(members2.join());
console.log(members2.join('/'));
console.log(members2.join(' '));

//sort()
members2.sort();
console.log(members2);
console.log(members2.reverse());

let numbers = [ 1, 9, 7, 5, 3]
console.log(numbers);

// a, b를 비교한다.
// 1) a를 b보다 나중에 정렬하고싶다면 (뒤에두려면) 0보다 큰수를 반환
// 2) a를 b보다 먼저 정렬하려한다면 (앞에두려면) 0보다 작은 숫자를 반환
// 3) 원래순서를 유지하고싶다면 0을 반환한다.
numbers.sort((a, b) => {
    // return a > b ? 1 : -1; // 오름차순 정렬
    return a < b ? 1 : -1; //내림차순 정렬
});

numbers.sort((a, b) => a < b ? 1 : -1);


console.log(numbers);

console.log("------------------------")

//map
//기존배열의 요소를 전부 반복하면서
//retrun된 값으로 새로운 배열을 만들어주는 함수
// console.log(members2.map((m) => {
//     if(m.length > 3) {
//         return m + "[vip]";
//     } else {
//         return m + "[gold]";
//     }
// }));

// =>
// let tmpMembers = [];
// for(let m of members2) {
//     tmpMembers.push(m + 1);
// }

let classList = [{
    className : "자바 1장",
    time : "12 : 00",
    classNo : 1
},{
    className : "자바 2장",
    time : "13 : 00",
    classNo : 2
},{
    className : "자바 3장",
    time : "14 : 00",
    classNo : 3
}]

let studentList = [{
    name: "최지원",
    classNo : 1,
},{
    name: "최지원2",
    classNo : 3,
},{
    name: "최지원3",
    classNo : 2,
},{
    name: "최지원4",
    classNo : 2,
},{
    name: "최지원5",
    classNo : 1,
}]

console.log(studentList.map( s => {
    for(let c of classList) {
        if(s.classNo === c.classNo) {
            return {
                ...c,
                ...s
            }
        }
    }
    //filter로 변경해보기

    return s;
}))

//filter()
let numbers2 = [1, 8, 7, 6, 3];
let tmp2 = [];
for (let n of numbers2) {
    if(n % 2 === 0){
        tmp2.push(n); 
    }
}

tmp2 = numbers2.filter(n => n % 2 === 0);
console.log(numbers2.filter(n => n % 2 === 0));

//find()
console.log(tmp2.find(n => n % 2 === 1));

//findIndex()
console.log(numbers2)
console.log(numbers2.findIndex(n => n % 2 === 0));

// reduce
// reduce((누적변수, 배열의 요소) => {}, 초기값)
//배열을 통해서 특정 변수 하나를 만들 때
console.log(numbers2.reduce((p, n) => p + n, 0));
console.log(numbers2.reduce((sum, n) => {
    if (n % 2 === 1) {
        sum.push(n);
    }
    return sum;
}, []))